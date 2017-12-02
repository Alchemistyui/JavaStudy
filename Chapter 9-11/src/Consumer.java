import java.io.IOException;
import java.io.PipedReader;

public class Consumer extends Thread {

	String consumerName;

	PipedReader in;
	
	public Consumer(String consumerName, PipedReader i) {
		this.consumerName = consumerName;
		in = i;
	}

	@Override
	public void run() {
		
		int foodNum = 0;
		
		
		
		
		while (true) {
			
		try {
			foodNum = in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (foodNum == 0) {
				System.out.println("box is empty,size = " + foodNum);
				break;
				
				
			}
			foodNum--;
			System.out.println("consume success foodNum = " + foodNum);


		}
	}

}
