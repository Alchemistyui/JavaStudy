package Chapter8.Thread;

public class ThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Goods goods = new Goods();

		Seller seller1 = new Seller("seller1", goods);
		Seller seller2 = new Seller("seller2", goods);
		Seller seller3 = new Seller("seller3", goods);
		seller1.start();
		seller2.start();
		seller3.start();
	}

}

class Goods {
	static int goods = 30;

	void sell(String name) {
		int count = 0;
		while (goods > 0) {
			synchronized (this) {

				goods--;
				count++;
				System.out.println(name + " sold: " + count + " goods: " + goods);
				if (count % 3 == 0) {
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

class Seller extends Thread {
	String name;
	Goods goods;

	Seller(String name, Goods goods) {
		this.name = name;
		this.goods = goods;
	}

	public void run() {
		goods.sell(name);
	}
}