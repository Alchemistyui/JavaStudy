
public class Person {

		private int foodNum = 0;
		private Object lock = new Object();

		private final int MAX_NUM = 5;

		public void produce() throws InterruptedException
		{
			synchronized (lock)
			{
				while (foodNum == MAX_NUM)
				{
					System.out.println("box is full，size = " + foodNum);
					lock.wait();
				}
				foodNum++;
				System.out.println("produce success foodNum = " + foodNum);
				lock.notifyAll();
			}

		}

		public void consume() throws InterruptedException
		{
			synchronized (lock)
			{
				while (foodNum == 0)
				{
					System.out.println("box is empty,size = " + foodNum);
					lock.wait();
				}
				foodNum--;
				System.out.println("consume success foodNum = " + foodNum);
				lock.notifyAll();
			}

		}

	public static void main(String[] args) {
		Person person = new Person();
		new Thread(new Consumer("消费者1", person)).start();
		new Thread(new Consumer("消费者2", person)).start();
	
		new Thread(new Producer("生产者1", person)).start();
		new Thread(new Producer("生产者2", person)).start();
		

	}

}
