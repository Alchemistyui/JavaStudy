import java.io.IOException;
import java.io.PipedWriter;

public class Producer extends Thread {

	int foodNum = 0;
	int MAX_SIZE = 5;
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
		while (true)
		{
			if (foodNum >= MAX_SIZE)
			{
				System.out.println("box is full，size = " + foodNum);
				break;
//				try {
//					sleep(3000);
//					continue;
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			foodNum++;
			try {
				out.write(foodNum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("produce success foodNum = " + foodNum);

		}
	}
}