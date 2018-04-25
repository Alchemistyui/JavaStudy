import java.io.BufferedReader;
import java.io.BufferedWriter;
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

			// 得到请求链接

			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String url = br.readLine();

			// System.out.println("url ..."+url);

			String resource = "";
			try {
				// 打得到请求网页名
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

			String newPath = path + resource;

			// 读取服务器本地文件
			File file = new File(newPath);

			BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

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
			try {
				BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

				String readLine = null;
				String contentType = "";
				int index = resource.indexOf(".");
				String type = resource.substring(index + 1);
				// System.out.println(type);
				// System.out.println("html ..."+resource.substring(index));
				// 标准头部
				if (type == "html") {
					contentType = "text/html;charset=utf-8";
				} else if (type == "png") {
					contentType = "image/png";
				} else if (type == "jpg") {
					contentType = "image/jpeg";
				} else if (type == "css") {
					contentType = "text/css";
				} else if (type == "js") {
					contentType = "application/x-javascript";
				}
				String head = "HTTP/1.1 200 OK\r\n" + "Content-Type:" + contentType + "\r\n" + "\r\n";
				head = new String(head.getBytes("gbk"), "utf-8");
				// fbw.write(head);
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
				// 一行一行读取文件并输出到网页
				String data = "";
				// = fbr.read();
				while ((readLine = fbr.readLine()) != null) {
					data += readLine;
					// fbw.newLine();
				}
				fbw.write(head + data);
				fbw.flush();

				fbw.close();

				fbr.close();

				accept.close();
				// } catch (FileNotFoundException e) {
				// String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:
				// text/html\r\n"
				// + "Content-Length: 23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
				// fbw.write(errorMessage.getBytes());
				// }

			} catch (FileNotFoundException e) {
				String head = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n";
				 head = new String(head.getBytes("utf-8"),"utf-8");
				 fbw.write(head + "\r\n" + "<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n");
				 System.out.println("404");
			}
		}
	}
}
