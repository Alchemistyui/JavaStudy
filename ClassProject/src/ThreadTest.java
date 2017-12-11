
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread myThread1 = new MyThread("My thread 1.");
		MyThread myThread2 = new MyThread("              My thread 2.");
		MyThread myThread3 = new MyThread("                            My thread 3.");

		
		Thread thread1=new Thread(myThread1);
		Thread thread2=new Thread(myThread2);
		Thread thread3=new Thread(myThread3);
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MIN_PRIORITY);

		thread1.start();
		thread2.start();
		thread3.start();
	}

}

class MyThread implements Runnable {

	String msg;

	MyThread(String msg) {
		this.msg = msg;
	}

	public void run() {

		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg + "awake....");
	}
}