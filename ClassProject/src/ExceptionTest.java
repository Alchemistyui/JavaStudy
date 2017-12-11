import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) throws IllegalScoreException {

		System.out.println(args[2]);
		
//		try {

			System.out.println("这是一个学生成绩管理系统");

			System.out.println(getScore());

//		} catch (Exception e) {
//			System.out.println("成绩输入有误：" + e.getMessage());
//			e.printStackTrace();
//		}

	}

	public static String getScore() throws IllegalScoreException {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入学生的姓名：");
		String name = sc.nextLine();
		System.out.print("请输入学生的成绩：");
		int score = sc.nextInt();
		if (score < 0 || score > 100) {
			IllegalScoreException e = new IllegalScoreException(score);
			throw e;
		}
		return name + "的成绩是:" + score;
	}

}

class IllegalScoreException extends Exception {

	int score;

	IllegalScoreException(int score) {
		this.score = score;
	}

	public String getMessage() {
		return "Illegal score: " + score;
	}

}
