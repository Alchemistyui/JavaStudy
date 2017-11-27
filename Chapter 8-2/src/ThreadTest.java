
public class ThreadTest {

	static int num = 0;

	ThreadTest() {
		AddThread add1 = new AddThread("addThread1");
		AddThread add2 = new AddThread("addThread2");
		SubThread sub1 = new SubThread("subThread1");
		SubThread sub2 = new SubThread("subThread2");
		add1.start();
		add2.start();
		sub1.start();
		sub2.start();
	}

	public static void main(String[] args) {
		ThreadTest thread = new ThreadTest();
	}

}
