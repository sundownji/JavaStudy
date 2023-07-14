package ex13interface;

/*인터페이스에 변수를 정의하면 무조건 상수가 되므로 주로 "인터페이스형 상수"라고 표현한다.
 *주로 프로그램에서 설정값이나 명시적인 코드를 위해 사용*/
import java.util.Scanner;

/*패키지 안에서만 사용 가능 그리고 접근지정자가 default라 그런거임*/
/*해당 인터페이스의 접근지정자는 default이므로 해당 패키지를 벗어나면 사용할 수 없다.
  만약 프로젝트 전체에서 사용하고 싶다면 public으로 선언해야 한다.
  (근데 이미 메인 클래스가 public 선언하고 사용되서 지금 못 쓰는거임)*/
//interface Game{
//	int SCISSORS=1, ROCK=2, PAPER=3;
//}

public class E04InterfaceConstant {

	public static void main(String[] args) {
		System.out.println("가위(1) 바위(2) 보(3) 게임입니다.");
		System.out.print("선택하세요(정수입력): ");

		Scanner scanner = new Scanner(System.in);
		int sel = scanner.nextInt();
		
		switch(sel) {
		/*의미없는 1,2,3으로 표현하는 것보다 상수를 사용하는게 가독성이 더 좋아짐
		 * 1,2,3은 설정값이 많은 경우 모두 기억하기 힘들잖니 그래서 위에 */
		case Game.SCISSORS:
			System.out.println("가위를 냈습니다.");
			break;
		case Game.ROCK:
			System.out.println("바위를 냈습니다.");
			break;
		case Game.PAPER:
			System.out.println("보자기를 냈습니다.");
			break;
		default:
			System.out.println("잘못냈슴다");
		}
	
	}

}
