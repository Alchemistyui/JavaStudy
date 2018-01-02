
public class SellTicket {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();

		Sellor sellor1 = new Sellor("sellor1", ticket);
		Thread thread1 = new Thread(sellor1);

		Sellor sellor2 = new Sellor("sellor2", ticket);
		Thread thread2 = new Thread(sellor2);

		thread1.start();
		thread2.start();
	}

}

class Ticket {
	static int ticket = 30;

	void sell(String name) {
		int count = 0;
		while (ticket > 0) {
			synchronized (this) {
				ticket--;
				count++;
				System.out.println(name + " sold " + count + " now ticket:" + ticket);
				if (count % 5 == 0) {
					notifyAll();
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}
}

class Sellor implements Runnable {

	String name;
	Ticket ticket;

	Sellor(String name, Ticket ticket) {
		this.name = name;
		this.ticket = ticket;
	}

	@Override
	public void run() {
		ticket.sell(name);
	}

}