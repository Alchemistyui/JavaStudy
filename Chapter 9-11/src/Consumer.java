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
		
		int integer = 0;
		
		
		
		
		for (int i = 0; i < Producer.MAX_NUM; i++) {
			
		try {
			integer = in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("consume success get integer = " + integer);


		}
	}

}
