import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class InternetTest {

	public static void main(String[] args) throws Exception {
		// InetAddress ia = InetAddress.getByName("www.baidu.com");
		// System.out.println(ia.getHostAddress());
		URL url = new URL("http://www.baidu.com");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}

}
