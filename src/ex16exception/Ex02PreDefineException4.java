package ex16exception;

import java.util.Date;

public class Ex02PreDefineException4 {
	 
	//정적변수를 생성. 객체 생성되지 않았음
	static Date toDay;
	
	public static void main(String[] args)  {	
		//관련된 로직 try로 묶어라
		try {			 
			System.out.println("### NullPointerException ###");
			/*참조변수가 null인 상태*/
			System.out.println("toDay="+ toDay);
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
