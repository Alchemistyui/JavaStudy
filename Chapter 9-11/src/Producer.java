import java.io.IOException;
import java.io.PipedWriter;

public class Producer extends Thread {

	int integer = 0;
	static int MAX_NUM = 5;
	String producerName;
	
	PipedWriter out;

	public Producer(String producerName, PipedWriter o)
	{
		this.producerName = producerName;
		out = o;

	}

	@Override
	public void run()
	{
		for (int i = 0; i < MAX_NUM; i++) {
			try {
				integer=1+(int)(Math.random()*50);
				out.write(integer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("produce success integer = " + integer);

		}
	}
}