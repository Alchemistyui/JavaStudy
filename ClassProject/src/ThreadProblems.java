import java.util.Random;

public class ThreadProblems {

	static int good = 1000;
	static Object lock = new Object();

	public static void main(String args[]) {
		Seller s1 = new Seller("售货员1");
		Seller s2 = new Seller("售货员2");
		Seller s3 = new Seller("售货员3");
		s1.start();
		s2.start();
		s3.start();
	}

}

class Seller extends Thread {

	static ReadWriteLock lock = new ReadWriteLock();

	static Random rand = new Random();

	String name;
	int sales = 0;

	Seller(String name) {
		this.name = name;
	}

	public void run() {
		while (ThreadProblems.good > 0) {
			// System.out.println(name + " 卖东西咯");
			sales++;
			try {
				lock.lockWrite();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ThreadProblems.good--;
			try {
				lock.unlockWrite();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(rand.nextInt(3));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("东西买完了" + name + "一共卖了" + sales);
	}

}