import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Consumer extends Thread {

	String consumerName;

	DataInputStream in;
	
	public Consumer(String consumerName, InputStream i) {
		this.consumerName = consumerName;
		in = new DataInputStream(i);
	}

	@Override
	public void run() {
		
		int foodNum = 0;
		try {
			foodNum = in.readInt();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(foodNum);
		
		while (true) {
			
		
			if (foodNum == 0) {
				System.out.println("box is empty,size = " + foodNum);
				break;
				
			}
			foodNum--;
			System.out.println("consume success foodNum = " + foodNum);


		}
	}

}
