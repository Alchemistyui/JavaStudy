import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileNotFoundException;

public class WebServer {

	public static void main(String[] args) throws IOException {
		String path = "/Users/ryshen/Desktop/编程/WebStudy/webServerResource/";
		ServerSocket serverSocket = new ServerSocket(8888);

		System.out.println("Serving HTTP  ...");

		while (true) {
			Socket accept = serverSocket.accept();

			InputStream inputStream = accept.getInputStream();

			// 得到请求报文第一行
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String url = br.readLine();

			// System.out.println("url ..."+url);

			String resource = "";
			try {
				// 取得请求资源路径
				resource = url.split(" ")[1];
				System.out.println(resource);
				// 设置默认网页为index.html
				if (resource.equals("/")) {
					resource = "index.html";
				}

				// int index2 = url.indexOf(" ", index);
				// System.out.println("index "+index);
				// System.out.println("html ..."+resource.substring(index));

			} catch (Exception e) {
				continue;
			}
//			获取本地绝对路径
			String newPath = path + resource;

			
			// if (!file.exists()) {
			// String head = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:
			// text/html\r\n";
			// head = new String(head.getBytes("utf-8"),"utf-8");
			// fbw.write(head + "\r\n" + "<html><head></head><body><h1>404 Not
			// Found</h1></body></html>\\r\\n");
			// System.out.println("404");
			//// continue;
			// }
			// else {
			// System.out.println(file.getName());
			// }
			BufferedOutputStream fbw = null;
			BufferedInputStream fbr = null;
			try {
				
				// 读取服务器本地文件
				File file = new File(newPath);
//				建立写管道
				fbw = new BufferedOutputStream(accept.getOutputStream());

				fbr = new BufferedInputStream(new FileInputStream(file));
//				读取获得所需请求资源类型
				String readLine = null;
				String contentType = "";
				int index = resource.indexOf(".");
				String type = resource.substring(index + 1);
				// System.out.println(type);
				// System.out.println("html ..."+resource.substring(index));
				
				
				// 响应报文标准头部
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
				String head = "HTTP/1.1 200 OK\r\n" + "Content-Type:" + contentType + "\r\n" + "\r\n";
				head = new String(head.getBytes("utf-8"), "utf-8");
				 fbw.write(head.getBytes());
				// }
				// if(type == "html") {
				//// System.out.println("html");
				// fbw.write("Content-Type:text/html\r\n");
				// }
				// else if (type == "png") {
				// fbw.write("HTTP/1.1 200 OK\r\n"
				// + "Content-Type:image/png\r\n"
				// + "\r\n");
				// }
				// fbw.write("\r\n");

				// System.out.println("emmmm");
				
				 int len = 0;
		            //byte[] bytes = new byte[inputStream .available()];
		            byte[] bytes = new byte[1024];
		            while ((len = fbr.read(bytes)) != -1) {
		                fbw.write(bytes);
		                fbw.flush();
		            }
				// 一行一行读取文件
//				int data = 0;
//				 data = fbr.read();
////				while ((readLine = fbr.readLine()) != null) {
////					data += readLine;
////					// fbw.newLine();
////				}
////				发送响应报文
//				fbw.write(head + data);
				
				// } catch (FileNotFoundException e) {
				// String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:
				// text/html\r\n"
				// + "Content-Length: 23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
				// fbw.write(errorMessage.getBytes());
				// }

			} catch (FileNotFoundException e) {
				String head = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n";
				 head = new String(head.getBytes("utf-8"),"utf-8");
				 byte[] bytes = new byte[1024];
				 bytes = (head + "\r\n" + "<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n").getBytes();
				 fbw.write(bytes);
				 System.out.println("404");
			} finally {
				fbw.flush();

				fbw.close();
				if (fbr != null) {
					fbr.close();
				}

				accept.close();
			}
		}
	}
}
