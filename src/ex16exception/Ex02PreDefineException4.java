package ex16exception;

import java.util.Date;

public class Ex02PreDefineException4 {
	 
	static Date toDay;
	
	public static void main(String[] args)  {	
		
		System.out.println("### NullPointerException ###");
		System.out.println("toDay="+ toDay);
		try {			 
			/* 인스턴스가 변수만 생성하고 
			 */
			System.out.println(toDay.getTime());
		}
		catch(NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다.");
			System.out.println("예외메세지:"+ e.getMessage());
		}
				 
	}////end of main	
	 
}
