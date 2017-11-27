
public class Consumer extends Thread {

	Person person;
	String consumerName;

	public Consumer(String consumerName, Person person) {
		this.consumerName = consumerName;
		this.person = person;
	}

	@Override
	public void run() {
		try {
			person.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
