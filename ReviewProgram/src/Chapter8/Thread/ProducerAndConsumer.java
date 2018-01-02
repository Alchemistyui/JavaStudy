package Chapter8.Thread;

public class ProducerAndConsumer {

	public static void main(String[] args) {
		GoodsBox box = new GoodsBox();
		
		Producer producer1 = new Producer("producer1", box);
		Producer producer2 = new Producer("producer2", box);
		Consumer consumer1 = new Consumer("consumer1", box);
		Consumer consumer2 = new Consumer("consumer2", box);
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
	}
}

class GoodsBox {
	static int goods;
	int MAX_SIZE = 5;
	
	public void produce(String name) {
		while(true) {
			synchronized(this) {
				while (goods == MAX_SIZE) {
					System.out.println("box is full~");
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				goods++;
				System.out.println("successful produced goods, now: " + goods);
				notifyAll();
			}
			
		}
		
	}
	
	public void consume(String name) {
		while(goods != 0) {
			synchronized(this) {
				if (goods == 0) {
					System.out.println("box is empty~");
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				goods--;
				System.out.println("successful consumed goods, now: " + goods);
				notifyAll();
			}
		}
		}
		
}


class Producer extends Thread {
	String name;
	GoodsBox box;
	
	Producer(String name,GoodsBox box) {
		this.name = name;
		this.box = box;
	}
	
	public void run() {
		box.produce(name);
	}
}

class Consumer extends Thread {
	String name;
	GoodsBox box;
	
	Consumer(String name,GoodsBox box) {
		this.name = name;
		this.box = box;
	}
	
	public void run() {
		box.consume(name);
	}
}
