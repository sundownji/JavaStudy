package ex16exception;

import java.util.Scanner;

public class Ex02PreDefineException2 {

	public static void main(String[] args) {
		 System.out.println("### NumberFormatException ###");
		 Scanner sc = new Scanner(System.in);
		 try {
			 /* 입력시 정수가 아닌 문자 혹은 문자열을 입력하면 정수로 변환이
			   불가능하므로 예외가 발생된다. */
			 //숫자포맷이 아닌데 숫자포맷으로 실행할경우 오류난디 
			 //자스 10살해도 10만 출력되는데 자바는 10살하면 오류로 출력
			 System.out.print("나이를 입력하세요.");
			 String strAge = sc.nextLine();
			 int ageAfter10 = Integer.parseInt(strAge)+10;
			 //자바에서 parseInt 앞에 Integer 붙여야함
			 System.out.println("당신의 10년 후 나이는:"+ageAfter10);
		} 
		 catch (Exception e) {
			 System.out.println("나이는 숫자로만 입력해야 합니다.");
			 System.out.println("예외메세지:"+e.getMessage());
			 e.printStackTrace();
			// TODO: handle exception
		}
	}//end of main

}
