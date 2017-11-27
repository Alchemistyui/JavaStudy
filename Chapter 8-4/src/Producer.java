
public class Producer extends Thread {

	Person person;
	String producerName;

	public Producer(String producerName, Person person)
	{
		this.producerName = producerName;
		this.person = person;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				person.produce();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
