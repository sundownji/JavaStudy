package ex08class;
/*
 시나리오] 기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스를 정의
 해보자. 아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 
 해당 수치는 임의로 바꿔도 된다.
 init() 멤버메소드에서는 계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.
*/
class CalculatorEx{
	int add;
	int min;
	int mul;
	int div;
	
	void init(int add,int min,int mul,int div) {
		
	}
	void ShowOpCount() {
		System.out.printf("덧셈횟수:%d\n"+add);
		System.out.printf("뺄셈횟수:%d\n"+min);
		System.out.printf("곱셉횟수:%d\n"+mul);
		System.out.printf("나눗셈횟수:%d\n"+div);
	}
}

public class QuSimpleCalculator {

	public static void main(String[] args) {
		CalculatorEx cal = new CalculatorEx();
//		cal.init();
//		System.out.println("1 + 2 = " + cal.add(1 , 2));
//		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
//		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
//		System.out.println("100 / 25 = " + cal.div(100 , 25));
//		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
//		cal.showOpCount();


	}

}
