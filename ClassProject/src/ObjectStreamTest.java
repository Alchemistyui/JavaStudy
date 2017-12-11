import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectStreamTest {

	public static void main(String args[]) throws Exception {

		File f = new File("test.txt");
		// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		// oos.writeObject(f);
		// oos.flush();
		// oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		Object o = ois.readObject();
		System.out.println("o:" + o.toString());
		if (o instanceof File) {
			File f2 = (File) o;
			System.out.println(f2.equals(f));
		}

	}

}
