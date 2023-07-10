package ex11static;
/*
 static 블럭:
 동일한 클래스내 main()보다 먼저 실행되는 블럭으로 main()메서드의 실행코드가
 없어도 먼저 실행된다. 또한 생성자보다도 먼저 실행된다.
 */
//넓은지역에서 만든건 좁은 지역에서 사용가능한. 그래서 멤버변수들을 static 블럭에서 사용가능함
public class E02StaticBlockMain {
	//인스턴스형 멤버(변수,메서드)
	int instanceVar;
	void instanceMethod() {}
	
	//정적멤버(정적변수,정적메서드)
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	
	//static 블럭 정의
	static {
		//블럭내에서 정적멤버변수에 접근할 수 있다.
		staticVar = 1000;		
		//지역내(static블럭)에서만 쓸 수 있는 일반적인 변수 생성이 가능함
		/*블럭내에서만 사용할 수 있는 변수로써, 블럭내에서는 일반변수를 생성할 수 있다.*/
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+ localVar); 
		/*static 블럭내에서는 인스턴스형 멤버를 사용할 수 없다.*/
		//static 블럭 안에서 인스턴스형 변수,메서드 사용 불가능.
//		System.out.println("instanceVar="+ instanceVar);  
//		instanceMethod();
		
		//정적멤버는 사용할 수 있다.
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		
		System.out.println("===static block 끝===");
	}
	/*생성자 메서드:생성자보다 먼저 실행되는지 확인해보기 위해 생성자 메서드를 정의함
	 생성자에서는 정적멤버에 접근 가능. 일반적인 멤버변수와 동일 */
	public E02StaticBlockMain() {
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
	}
	public static void main(String[] args) {
		
		System.out.println("==메인메소드==");		
		//블럭내에서만 사용 가능한 localVar, 블럭을 나와서는 사용 못함
		/* static 블럭 내에서 선언된 변수는 지역변수이므로 main메서드에서는 사용
		 할 수 없다. 해당 지역에서만 사용할 수 있다.*/
		//System.out.println("localVar="+ localVar);
	
		//new를 통해(생성자) 인스턴스를 생성한다.
		new E02StaticBlockMain();
	}
}

