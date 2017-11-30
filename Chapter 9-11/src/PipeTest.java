import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeTest {

	public static void main(String[] args) {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = null;
		try {
			in = new PipedInputStream(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Consumer consumer = new Consumer("消费者", in);
		Producer producer = new Producer("生产者", out);
		
		consumer.start();
		producer.start();
	}

}
