package ex09package.study.perimeter;

//원의 둘레를 구하기 위해 작성한 클래스
public class Circle {
	//멤버변수
	double rad;
	//멤버상수
	final double PI;
	
	//생성자메소드
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.14159;
	}
	//멤버메소드: 원의 둘레를 계산한 후 반환한다.
	public double getPerimeter() {
		return 2 * PI * rad;
	}
}
