
public class AddThread extends Thread {

	String name;

	AddThread(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(name + "starts running.");
		
		for(int i = 1; i <= 10; i++) {
			ThreadTest.num ++;
			System.out.println(name + " : " + ThreadTest.num);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name + "finished"); 
	}
}
