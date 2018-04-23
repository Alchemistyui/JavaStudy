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


public class WebServer {

	public static void main(String[] args) throws IOException {
		String path = "/Users/ryshen/Desktop/";
		ServerSocket serverSocket = new ServerSocket(8888);
		
		System.out.println("Serving HTTP on port %s ...");
			
		while (true) {
            Socket accept = serverSocket.accept();

            InputStream inputStream = accept.getInputStream();

            // 得到请求链接
            
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String url = br.readLine();
            
            String html = "";
            try {
                //打得到请求网页名
                html = url.split(" ")[1];
            } catch (Exception e) {
                continue;
            }
            //设置默认网页为index.html
            if (html.equals("/")) {
                html = "InitialPages.vue";
            }
            //不处理图片请求
            if (html.equals("/console.html")) {
            		html = "console.html";
            }

            String newPath = path + html;

            // 读取服务器本地文件
            File file = new File(newPath);

            BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

            String readLine = null;

            //标准头部
            fbw.write("HTTP/1.1 200 OK\r\n");
            fbw.write("Content-type:text/html;charset=UTF-8\r\n");
            fbw.write("\r\n");

            //一行一行读取文件并输出到网页
            while ((readLine = fbr.readLine()) != null) {
            	fbw.write(readLine);
            	fbw.newLine();
            }
            fbw.flush();

            fbw.close();

            fbr.close();

            accept.close();
		}
	}
}
		
		
		
