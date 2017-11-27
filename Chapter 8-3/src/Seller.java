
public class Seller extends Thread {

	String name;
	int soldNumber = 0;
	Store store;

	Seller(String name, Store store) {
		this.name = name;
		this.store = store;
	}

	public void run() {
	store.sellGoods(this);
	}

}
