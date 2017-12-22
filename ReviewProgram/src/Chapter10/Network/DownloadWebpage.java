package Chapter10.Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class DownloadWebpage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ad = InetAddress.getByName("www.baidu.com");
		System.out.println(ad.getHostAddress());
		//---------------
		File f = new File("/Users/ryshen/Desktop/JavaTest.html");
		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();

		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		URL url = new URL("http://www.baidu.com");
		BufferedReader br = new BufferedReader(new InputStreamReader((url.openStream())));
		
		String str;
		while((str = br.readLine()) != null) {
			bw.write(str);
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
