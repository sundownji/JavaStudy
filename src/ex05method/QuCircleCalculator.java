package ex05method;

import java.util.Scanner;

public class QuCircleCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하세요.:");
		double radius = scanner.nextDouble();
		//반지름 실수가 될 수도 있기 때문에 nextInt()가 아니라 nextDouble()
		//로 사용해야한다.
		System.out.println("원의 둘레("+radius+") : "+circleRound(radius));
		System.out.println("원의 넓이("+radius+") : "+circleArea(radius));
		System.out.printf("원의 넓이("+radius+") : "+circleArea(radius));
	}
	//반환값도 있고 매개변수도 있는 타입임
	static double circleRound(double a) {
		return a * 3.14 * 2;
	}
	/*
	//return print문처럼 결과 출력을 할 수도 있지만 그럴수도 아닐 수도
	함수 4가지 형식(반환값 ox,매개변수ox)
		//반환값이 없는 함수
	 	static void aFunc(){
	 	return을 보통 쓰지 않는다. - if문이랑 같이 사용된다.
	  	if(true) return; -값을 반환하려는 용도 아니고 함수를 종료하려고 리턴을 사용함
	  	
	  	 
	  	//반환값이 있는 경우에는 반드시 값을 반환해야함
	  	static int bFunc(){
	  		return 1;(return 1.0은 오류임 1.0은 실수라 double쓰기)
	  	}
	  	
	  	//더블에 반환값을 리턴해야함
	  	static double cFunc(){
	  		return 1.0;(return 1 오류 안된다. 자연형변환되는거라 그럼)
	*/
	//반환값도 있고 매개변수도 있는 타입임
	static double circleArea(double b) {
		return 3.14 * b * b ;
	}
}

//메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
//-넓이공식 : 3.14 * 반지름 * 반지름
//-둘레공식 : 2 * 3.14 * 반지름

//실행결과]
//원의 둘레(5.5) : 34.54
//원의 넓이(5.5) : 94.985

