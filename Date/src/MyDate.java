
public class MyDate {

	int year;
	int month;
	int day;
	
	void setDate(int y, int month, int d) {
		year = y;
		this.month = month;
		day = d;
		
		System.out.println("You sucessfully set date" + year + "-" + this.month + "-" + day);
	}
	
	
	void addDate(int d) {
		day += d;
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if (day >= 31) {
				day -= 31;
				month++;
			}
			break;
		
		case 2:
			if (day >= 29 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ) {
				day -= 29;
				month++;
			}
			else if (day >= 28) {
				day -= 28;
				month++;
			}
			break;
		default:
			if (day >= 30) {
				day -= 30;
				month++;
			}
		}
		
		if (month > 12) {
			month -= 12;
			year++;
		}
	}
	
	void showDate () {
		System.out.println("The date is " + year + "-" + this.month + "-" + day);
	}
	
	
	public static void main(String[] args) {
		MyDate date = new MyDate();
		
		date.setDate(1999, 03, 11);
		date.showDate();
		
		date.addDate(30);
		date.showDate();

	}

}
