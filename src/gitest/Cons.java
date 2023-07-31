package gitest;

//디폴트 생성자:마음의 눈으로 볼 수 있음
//클래스 만들면 생성자 무조건
class A{
	
}
class B extends A {
	public B() {//디폴트 생성자
		super();
	} 
		
}
public class Cons {
	public static void main(String[] args) {
		//생성자 없으면 인스턴스를 만들 수 없으니까 생성자가 무조건 있어야함
		B b = new B();
	}

}
