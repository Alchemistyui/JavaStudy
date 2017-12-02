import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeTest {

	public static void main(String[] args) {
		PipedReader out = new PipedReader();
		PipedWriter in = null;
		try {
			in = new PipedWriter(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Consumer consumer = new Consumer("消费者", out);
		Producer producer = new Producer("生产者", in);
		
		consumer.start();
		producer.start();
	}

}
