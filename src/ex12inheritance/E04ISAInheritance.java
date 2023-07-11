package ex12inheritance;
/*
 Is-A 관계 
 :X is a Y => X는 Y의 일종이다로 표현가능한 관계
 -노트북은 컴퓨터의 일종이다.
 -휴대폰은 전화기의 일종이다.
 이와같이 Is-A 관계가 성립하는 객체를 상속으로 표현하기에 적합하다.
 따라서 실제 업무에서도 유사한 기능의 클래스들을 상속으로 묶어서 정의한다.
 
 */
//컴퓨터: 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산한다.
class Computer{
	//멤버변수: 컴퓨터의 소유주
	String owner;
	
	//디폴트 생성자
	//public Computer(){}
	
	//인수를 가지고 있는 생성자를 개발자가 임의로 추가해서 만들었다면 디폴트 생성자는 추가 안된다.
	public Computer(String name) {
		owner= name;
	}
	
	// 멤버메서드: 접근 지정자가 private로 되어 있기 때문에 외부에서 접근이 안된다.
	/* private 접근지정자로 선언된 멤버메서드는 외부 클래스 혹은 상속받은 클래스에서
	  접근이 불가능하므로, public으로 선언된 메서드를 통해 간접적으로 호출해야한다. */
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	}
	//위의 private 메서드들을 외부에서 접근해 호출이 안되기 때문에 외부에서 호출 할 수 있도록
	//public으로 선언된 메서드를 하나 만들어 간접적으로 호출함
	
	/*캡슐화
	 private으로 선언된 멤버메서드를 외부에서 호출할 수 있게 public으로 지정하여 선언한
	 메서드로 "캡술화" 되어있다.*/
	public void calculateFunc() {
		keyboardTouch(); //입력한 후
		calculate(); //계산 실행
	}

}
/* 컴퓨터를 상속한 노트북 컴퓨터: 컴퓨터가 가진 기본 연산기능에 휴대성을 확장하여 정의한다.
 휴대 이용을 위해 배터리 멤버변수가 추가되었다. */
class NotebookComputer extends Computer{
	//자식클래스에서 확장한 멤버변수
	int battary;
	
	/*생성자 메서드 정의 :내부엔 멤버변수 1개 밖에 없지만, 멤버변수 2개를 받고 있음 
	  하나는 부모생성자에게 전달하기 위한 멤버변수 1개랑 초기화할 멤버변수 1개 총 2개를 받고 있음*/
	public NotebookComputer(String name, int initCharge) {
		/*부모클래스의 생성자를 호출하기 위해 사용한 super()는 생략할 수 있지만,
		  앞에 다른 문장이 먼저 기술되면 에러가 발생한다. 
		  항상 부모의 생성자를 최우선으로 호출해야한다.*/
		super(name);
		//멤버변수 초기화
		battary = initCharge;
	}
	//배터리 충전을 표현한 멤버메서드
	public void charging() {
		battary += 5;
	}
	//휴대하면서 컴퓨터를 사용하는 것을 표현한 멤버메서드
	public void movigCal() {
		//사용전 배터리를 확인한 후 사용여부를 판단한다.
		if(battary < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			//메서드에서 아래와 같이 return은 실행이 중지된다.
			//return은 반환, 중지 두개를 의미함
			return;
		}
		
		System.out.println("이동하면서");
		/*아래 2개의 메서드는 private으로 선언되었으므로 상속을 받은 자식 클래스에서도
		  접근할 수 없어 에러가 발생된다. 
		  이 경우 public으로 선언된 메서드를 통해 호출해야한다. 
		  => 그게 바로 calculateFunc()*/
//		keyboardTouch(); //부모 private로 선언된 메서드라 호출 자체가 불가능
//		calculate(); //부모 private로 선언된 메서드라 호출 자체 불가능
		calculateFunc();
		
		//배터리를 1 차감한다.
		battary -= 1;
	}
}
/*테블릿 노트북: 컴퓨터의 기본 연산기능과, 휴대이용,전용펜으로 드로잉 할 수 있는 기능까지
  추가된 컴퓨터를 추상화한다.*/
class TableNotebook extends NotebookComputer{
	
	//테블릿 사용을 위한 펜슬을 표현한 멤버변수
	String registPencil;
	
	//생성자 멤버변수 3개, 멤버변수 선언한 건 1개 부모에게 받을 거 2개 
	public TableNotebook(String name, int initCharge, String pen) {
		super(name,initCharge);
		registPencil = pen;
	}
	//테블릿 사용을 위해 배터리량 체크 및 등록된 펜인지 확인하는 멤버메서드
	public void write(String penInfo) {
		//배터리 충분한지 확인
		if(battary<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		//equals - 똑같으면 true, 다르면 false
		//compareTo - 아스키코드 비교 크다 작다 판단 
		//0 = 똑같은 문자열
		//-1,+1 = 다르다는 문자열 확인하기 위해 compareTo라는 함수 사용
		
		/*등록된 펜인지 문자열비교를 통해 확인한다.
		A.compareTo(B): 문자열 A와 B를 비교하여 0이 반환=동일한 문자열이고 
		-1과 1이 반환 = 서로 다른 문자열이라는 것을 판단하는 String 클래스에 정의된 메서드이다.
		 */
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		/*부모클래스에 정의된 메서드를 호출한다. 상속받은 자식 클래스에서는
		  이와같이 부모의 멤버메서드를 호출하여 자신의 기능처럼 사용할 수 있다.
		  단, 접근이 가능한 지정자로 선언되어야한다(private으로 선언되면 접근 못해)
		  super.는 생략 가능하다.
		 */
		super.movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary -= 1;
	}
}
public class E04ISAInheritance {

	public static void main(String[] args) {
		//노트북 인스턴스 생성
		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		//테블릿 인스턴스 생성
		TableNotebook tablet = new TableNotebook("이동욱",5,"ISE-1234");
		
		System.out.println("===노트북컴퓨터사용===");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();//배터리가 1씩 차감되므로 여기까지 사용가능
		noteBook.movigCal();//배터리가 모두 소모되어 사용불가능
		noteBook.movigCal();
		System.out.println("===ISE-1234 펜으로 테블릿 사용===");
		tablet.write("ISE-1234");//사용가능
		
		System.out.println("===XYZ-9876 펜으로 테블릿 사용===");
		tablet.write("XYZ-9876");//사용불가능
		

	}

	
}
