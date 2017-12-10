
import java.net.URL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DownloadWebpage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		URL url = new URL("http://www.baidu.com");
		String str = null;
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		File f = new File("/Users/ryshen/Desktop/DownloadWebpage.html");

		if (f.exists()) {
			f.delete();
		}

		f.createNewFile();

		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);

		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
		
	}

}
