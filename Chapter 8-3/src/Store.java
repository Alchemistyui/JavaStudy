
public class Store  {

	static int goods = 35;
	static Object lock = new Object();
	
	
	void sellGoods(Seller seller) {
		while (Store.goods > 0) {
			synchronized (lock) {
				Store.goods--;
				seller.soldNumber++;
				System.out.println(seller.name + "sold :" + seller.soldNumber);
				if (seller.soldNumber % 10 == 0) {
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Seller seller1 = new Seller("seller1", store);
		Seller seller2 = new Seller("seller2", store);
		seller1.start();
		seller2.start();
//		try {
//			seller2.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
