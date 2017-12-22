package Chapter9.IOStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadConnectWithPipe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PipedOutputStream os = new PipedOutputStream();
		PipedInputStream is = new PipedInputStream(os);

		Producer p = new Producer(os);
		Consumer c = new Consumer(is);
		p.start();
		c.start();
	}

}

class Producer extends Thread {
	PipedOutputStream os;
	int number;
	static int TIMES = 5;

	Producer(PipedOutputStream os) {
		this.os = os;
	}

	public void run() {

		for (int i = 0; i < TIMES; i++) {
			number = 1 + (int) (Math.random() * 50);
			try {
				os.write(number);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producer produced number:" + number);
		}

	}

}

class Consumer extends Thread {
	PipedInputStream is;
	int number;

	Consumer(PipedInputStream is) {
		this.is = is;
	}

	public void run() {

		for (int i = 0; i < Producer.TIMES; i++) {
			try {
				number = is.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("           Consumer consumed number: " + number);

		}

	}
}