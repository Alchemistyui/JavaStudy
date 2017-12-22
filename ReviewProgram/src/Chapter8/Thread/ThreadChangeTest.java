package Chapter8.Thread;

public class ThreadChangeTest {

	public static void main(String[] args) {
		Count count = new Count();
		ThreadAdd add1 = new ThreadAdd("add1", count);
		ThreadAdd add2 = new ThreadAdd("add2", count);

		ThreadSub sub1 = new ThreadSub("sub1", count);
		ThreadSub sub2 = new ThreadSub("sub2", count);

		add1.start();
		add2.start();
		sub1.start();
		sub2.start();
	}

}

class Count {
	static int times;

	void ThreadAdd(String name) {

		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				Count.times++;
				System.out.println("             " + name + " added times, now:" + Count.times);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	void ThreadSub(String name) {

		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				Count.times--;
				System.out.println(name + " subtracted times, now:" + Count.times);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

class ThreadAdd extends Thread {
	String name;
	Count add;

	ThreadAdd(String name, Count add) {
		this.name = name;
		this.add = add;
	}

	public void run() {
		add.ThreadAdd(name);
	}

}

class ThreadSub extends Thread {
	String name;
	Count sub;

	ThreadSub(String name, Count sub) {
		this.name = name;
		this.sub = sub;
	}

	public void run() {
		sub.ThreadSub(name);
	}

}
