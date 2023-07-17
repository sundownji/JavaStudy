package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02PreDefineException3 {

	public static void main(String[] args) {
		System.out.println("### InputMismatchException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("나이를 입력하세요.");
			int intAge = sc.nextInt();
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년 후 나이는:"+ageAfter10);
		} catch (InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 안된다.");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();

		} 

	}

}
