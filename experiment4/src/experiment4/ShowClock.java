package experiment4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ShowClock {

	public static void main(String[] args) {

		Clock beijing = new Clock("Asia/Shanghai", "北京");
		Clock tokyo = new Clock("Asia/Tokyo", "东京");
		Clock london = new Clock("Europe/London", "伦敦");
		beijing.start();
		tokyo.start();
		london.start();
	}

}

class Clock extends Thread {
	String timeZone;
	String where;

	Clock(String timeZone, String where) {
		this.timeZone = timeZone;
		this.where = where;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 北京
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
			System.out.println("毫秒数:" + date.getTime() + "," + where + "时间 :" + dateFormat.format(date));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		}

	}
}