package ex12inheritance;

/*
instanceof 연산자: 
-인스턴스 변수가 어떤 타입의 변수인지를 판단하는 연산자로 형변환(즉 상속관계가 있으면)이
가능하면 true를 반환한다. 
-객체간에 형변환이 되려면 반드시 두 클래스간에 상속관계가 있어야한다.
-부모타입의 참조변수로 자식 인스턴스를 참조할 수 있으므로 매개변수를 부모타입으로 만들면 자식 인스턴스를
인수로 받을 수 있다.
-매개변수로 전달되는 인수는 부모타입으로 자동형변환(업캐스팅)되므로 정상적인 사용을 위해 
강제형변환(다운캐스팅) 해야 하는데 이때 확인을 위해 사용된다.
 */
class Box{
	public void boxWrap() {
		System.out.println("Box로 포장합니다.");
	}
}
class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다.");
	}
}
class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다.");
	}
}
public class E09InstanceOf {
	
	/*
	- 메서드 정의시 부모타입의 매개변수로 설정하면 자식타입의 인스턴스를
	한꺼번에 받을 수 있다.
	- Box타입으로 인수를 받게 되면 자동형변환(업캐스팅) 되므로 자식클래스의 멤버메서드를 호출
	할 수 없게된다.
	- 이때 자식의 멤버메서드를 호출하기 휘해서 강제형변환(다운캐스팅)이 필요하다.
	- instanceof 연산자를 통해 자식타입으로 형변환이 가능한지 판단한 후 true를 반환하면
	다운 캐스팅을 진행한다.
	*/
	
	//매개변수 타입 박스타입(부모)
	static void wrapBox(Box b) {
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox) b).goldWrap();
		}
		else if(b instanceof PaperBox) {
			((PaperBox) b).paperWrap();
		}
		else if(b instanceof Box) {
			b.boxWrap();
		}
	}

	/*
	- 만약 부모타입의 매개변수로 자식타입의 인수를 받을 수 없다면 아래와 같이
	각각의 타입에 따른 모든 메서드를 정의해야 한다.
	
	static void wrapBox(Box b) {}
	static void wrapBox(PaperBox b) {}
	static void wrapBox(GoldPaperBox b) {}
	
	상속관계가 더 깊어진다면 메서드는 점점 늘어나게 되어 코드는 더욱 더 복잡해진다.
	따라서 부모로 자식을 참조할 수 있는 것은 개발자에게 편리함을 가져다준다.
	*/

	
	public static void main(String[] args) {
		//각 인스턴스를 생성한다.
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		/* 각 자식 타입의 인수를 부모타입의 매개변수로 전달한다.
		  Box가 최상위 부모이므로 하위의 모든 인수를 받을 수 있다.
		  이는 상속관계가 있으므로 가능하다. */
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
		/* String 인스턴스는 box와는 아무런 관계가 없으므로 인수를 전달할 수 없다.
		   즉 상속관계가 성립하지 않는다. */
		String str = new String("나는 누구?");
//		wrapBox(str); 에러발생
//		if(str instanceof Box) {} 전혀 관련 없기 때문에 에러발생
	
	
	}

}
