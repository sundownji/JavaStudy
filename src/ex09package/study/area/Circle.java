package ex09package.study.area;

/*원의 넓이를 구하기 위해 작성한 클래스*/
public class Circle {
	//멤버변수 : 반지름
	double rad;
	//멤버상수 : 원주율(파이값)
	final double PI;
	
	//생성자메서드 (클래스명과 동일한 이름으로 지어야함)
	public Circle(double rad) {
		//변수명이 동일한 경우 구분을 위해서 this.를 사용함
		//this는 클래스 자신을 가리킴 왼쪽은 멤버 오른쪽은 매개
		this.rad = rad;
		//생성자에서는 멤버상수를 초기화할 수 있다.
		PI = 3.14159;
	}
	//멤버메서드 : 원의 넓이를 계산해서 반환한다.
	public double getArea() {
		return PI * rad * rad;
	}
}
