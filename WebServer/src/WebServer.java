import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileNotFoundException;

public class WebServer {
	// 定义服务器端口
	int port;
	// 定义服务器文件所在路径
	String path;
	ServerSocket serverSocket;

	WebServer() throws IOException {
		// 初始化对象
		port = 8888;
		path = "/Users/ryshen/Desktop/编程/WebStudy/webServerResource";
		// 创建绑定到特定端口的服务器套接字
		serverSocket = new ServerSocket(port);
		// 输出表示服务器运作
		System.out.println("Serving HTTP  ...");
	}

	// 在日志文件中添加日志数据的函数
	void writeLog(String REQUEST, String HOST) throws IOException {
		// 创建临时文件保存插入节点后的数据
		File tmp=File.createTempFile("tmp", null);
		tmp.deleteOnExit();//在JVM退出时删除此临时文件

		//以读写的方式建立一个RandomAccessFile对象，可读可写方式打开
		// 不能使用file类，因为其不能随机读写，不能满足XML文件的需求
		RandomAccessFile raf=new RandomAccessFile(path + "/log.xml", "rw");

		// 创建文件输入输出类对象
		FileOutputStream tmpOut=new FileOutputStream(tmp);
		FileInputStream tmpIn=new FileInputStream(tmp);
		// 指定文件插入位置
		raf.seek(10);


		byte [] buff=new byte[1024];
        //用于保存临时读取的字节数
		int hasRead=0;
        //循环读取插入点后的内容，插入需要指定添加的数据
		while((hasRead=raf.read(buff))>0){
            // 将读取的数据写入临时文件中
			tmpOut.write(buff, 0, hasRead);
		}  

		raf.seek(10);//返回原来的插入处
        //追加需要追加的内容
		String str = " <CD><REQUEST>"+REQUEST+"</REQUEST><HOST>"+HOST+"</HOST></CD>";
		raf.write(str.getBytes());
        //最后追加临时文件中的内容，即原文件的插入点后的内容
		while((hasRead=tmpIn.read(buff))>0){
			raf.write(buff,0,hasRead);
		}  

	}

	void serve() throws IOException {
		// 服务器一直提供服务
		while (true) {
			// 接受到套接字的连接
			Socket accept = serverSocket.accept();
 			// 通过输入管道获取HTTP请求报文
			InputStream inputStream = accept.getInputStream();

			// 包装输入管道，提高速度
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			// 得到请求报文第一行，第二行
			String url = br.readLine();
			String host = br.readLine();

			// 判断是否是浏览器控制台界面get传送数据，修改服务器文件路径
			if (url.split(" ")[1].indexOf("/console.html?")!=-1) {
				String str = url.split(" ")[1].split("=")[1];
				// 传送后/变为%2F，将其转换回去
				path = str.replace("%2F", "/");
				
			}
			// 其余简单get请求
			else {
				String resource = getResource(url);

			//	获取本地绝对路径
				String newPath = path + resource;
				responseResource(newPath, accept, resource);
				// 在日志文件中添加内容
				writeLog(url, host);
			}


		}
	}

	// 在get报文第一行中分离出请求文件的相对路径
	String getResource(String url) {
		String resource = "";
		System.out.println(url);
		// 取得请求资源路径
		resource = url.split(" ")[1];
		// 设置默认网页为index.html
		if (resource.equals("/")) {
			resource = "/index.html";
		}
		return 	resource;
	}


	// 发响应报文的函数
	void responseResource(String newPath, Socket accept, String resource) throws IOException {
		// 读取本地文件的输入管道及本地文件输出到浏览器的管道
		// 此处只能使用字节流，因为字符流在处理图片时不能显示，图片中的字符变多，可能因为读取了多余的空白字符
		BufferedOutputStream os = null;
		BufferedInputStream fis = null;
		try {

			// 读取服务器本地文件
			File file = new File(newPath);
			// 建立读写管道
			os = new BufferedOutputStream(accept.getOutputStream());
			fis = new BufferedInputStream(new FileInputStream(file));
			// 读取获得所需请求资源类型
			String readLine = null;
			String contentType = "";
			// 找到第一个.的索引并提取后面类型的字符串
			int index = resource.indexOf(".");
			String type = resource.substring(index + 1);

			// 判断请求资源类型来填充不同的报文首部
			// 注意字符串比较不能用==，==是比较地址是否相等，equals才是比较字符串内容
			if (type.equals("html")) {
				contentType = "text/html;charset=utf-8";
			} else if (type.equals("png")) {
				contentType = "image/png";
			} else if (type.equals("jpg")) {
				contentType = "application/x-jpg";
			} else if (type.equals("css")) {
				contentType = "text/css";
			} else if (type.equals("js")) {
				contentType = "application/x-javascript";
			}
			// 响应报文标准头部，并将其utf8编码
			String head = "HTTP/1.1 200 OK\r\n" + "Content-Type:" + contentType + "\r\n" + "\r\n";
			head = new String(head.getBytes("utf-8"), "utf-8");
			// 向管道写响应报文头部
			os.write(head.getBytes());

			// 采用read(byte[] b, int off, int len)方法，因为若采用read(byte[] b)方法，
			// 最后不满1024的时候每次写都会填满缓冲区，造成页面中多余其他元素
			// 而用现在这种方法，读到最后一次的时候就只是写实际的字节数
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}

		// 若请求不存在的文件则返回404报文
		} catch (FileNotFoundException e) {
			String head = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n";
			head = new String(head.getBytes("utf-8"),"utf-8");
			byte[] bytes = new byte[1024];
			bytes = (head + "\r\n" + "<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n").getBytes();
			os.write(bytes);
			System.out.println("404");
		} finally {
			// 最后关闭各种管道
			os.flush();

			os.close();
			// 如果文件不存在则不存在fis的关闭
			if (fis != null) {
				fis.close();
			}
			// 连接关闭
			accept.close();
		}
	}



	public static void main(String[] args) throws IOException {
		// 构建服务器对象
		WebServer server = new WebServer();
		// 服务器开始提供服务
		server.serve();


	}
}
