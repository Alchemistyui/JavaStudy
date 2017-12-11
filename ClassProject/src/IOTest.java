import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class IOTest {

	public static void main(String[] args) throws IOException {
		PipedOutputStream s1 = new PipedOutputStream();
		PipedInputStream s2 = new PipedInputStream(s1);
		
		Producer t1=new Producer(s1);
		Consumer t2=new Consumer(s2);
		
		t1.start();
		t2.start();
	}

}

class Producer extends Thread {

	PipedOutputStream s;

	Producer(PipedOutputStream s) {
		this.s = s;
	}

	public void run() {
		while (true)
			produce();
	}

	public void produce() {
		int i = (int) (System.currentTimeMillis() % 100);
		try {
			s.write(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("produced:" + i);
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Consumer extends Thread {
	PipedInputStream s;

	Consumer(PipedInputStream s) {
		this.s = s;
	}

	public void run() {
		while (true)
			try {
				consume();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void consume() throws IOException, InterruptedException {
		if (s.available() > 0) {
			System.out.println("\tconsumed:" + s.read());
		} else {
			System.out.println("\tconsumed nothing...");
		}
		sleep(70);
	}
}