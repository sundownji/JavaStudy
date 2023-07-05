package ex04controlstatement;

import java. util.Scanner;

public class E02Switch {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int iNum =scanner.nextInt();
		System.out.println("입력한 숫자는:"+iNum);
		
		int remain = iNum % 3;
		switch(remain) {
		case 0:
			System.out.println("나머지는 0입니다.");
			break;
		case 1:
			System.out.println("나머지는 1입니다.");
			break;
		default:
			System.out.println("나머지는 2입니다.");
		}
		
//		long ln = 100;
//		switch(ln) {
//		case 100:
//			System.out.println("long타입 사용?");
//		default:
//			System.out.println("안되는군");
//		}
//		switch(!Num%3==0) {
//			System.out.print("논리식도 안되는군");
//		}
		String title ="자바";
		switch(title) {
		case "자바" :System.out.println("자바 좋아");
			break;
		case "JAVA":System.out.println("자바 긋");
			break;
		}
		int season = 8;
		switch(season) {
		case 3:case 4:case 5:
			System.out.println("봄입니다.");
			break;
		case 6:case 7:case 8:case 9:
			System.out.println("여름입니다.");
			break;
		case 10:
			System.out.println("가을입니다.");
			break;
		case 11:case 12:case 1:case 2:
			System.out.println("겨울입니다.");
		}
		/*
		시나리오]국,영,수 점수의 평균값을 구하여 학점을 출력하는 프로그램을 작성하시오.
		 90점 이상은 A학점, 60점 미만은 F학점을 출력하면 된다.
		*/
//		int kor=99, eng=70, math=64;
//		int age=(kor+eng+math)/(3*10);
	}

}
