package ex12inheritance;

public class Real {

	public static void main(String[] args) {

	Parent1 p = new Child1();
	Child1 c1 = new Child1();
	System.out.println("p.x="+p.x);
	p.method();
	System.out.println();
	System.out.println("c.x="+c1.x);
	c1.method();
	}
}

class Parent1  {
	int x = 100;
	void method() { 
	System.out.println("부모 클래스");
}
}
class Child1 extends Parent1 {
		int x= 200;
		void method() {
		System.out.println("x="+x);
		System.out.println("super.x="+ super.x);
		System.out.println("this.x=" + this.x);
		}
}

