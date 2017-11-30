import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Producer extends Thread {

	int foodNum = 0;
	int MAX_SIZE = 5;
	String producerName;
	
	DataOutputStream out;

	public Producer(String producerName, OutputStream o)
	{
		this.producerName = producerName;
		out = new DataOutputStream(o);

	}

	@Override
	public void run()
	{
		while (true)
		{
			if (foodNum == MAX_SIZE)
			{
				System.out.println("box is full，size = " + foodNum);
				break;
			}
			foodNum++;
			try {
				out.writeInt(foodNum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("produce success foodNum = " + foodNum);

		}
	}
}