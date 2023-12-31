package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*사용자 정의클래스
 * 1.Exception 클래스를 상속
 * 2.생성자에서 예외발생시 출력할 메세지를 super()를 통해 입력
 * 3.예외 발생지점에서 if문으로 감지한 후 예외객체를 생성 및 throw.
 * 4.catch문에서 예외객체를 잡아 처리
*/

class AgeErrorException extends Exception{
	public AgeErrorException() {
		super("나이 입력이 잘못되었어요.");
	}
}
public class Ex06DeveloperDefine {

	public static void main(String[] args) {
		System.out.print("나이를 입력하세요:");
		try {
			/*아래 메서드에서 AgeErrorException 예외객체를 throw하면 여기에서 예외처리한다.
			 * 즉, 메서드를 호출한 지점에서 예외처리하는 방식이다.*/
			int age = readAge();
			System.out.println("당신의 나이는 "+ age +" 입니다.");
		} 
		catch (AgeErrorException e) {
			System.out.println("[예외발생]"+e.getMessage());
		}
	}
	//예외던지기를 하여 호출한 지점으로 에러를 전달한다.
	public static int readAge() throws AgeErrorException{
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;
		try {
			/*나이 입력시 문자를 잘못 입력하는 경우에 대해 예외처리를 하고 있다.
			 * 이부분은 Java에서 미리 정의해놓은 예외처리 클래스를 사용한다.*/
			inputAge = sc.nextInt();			
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		
		/*만약 나이를 음수로 입력하는 경우 JVM이 감지하지 못하므로 이때는 if문을 통해
		 판단해야한다. 개발자가 정의한 예외객체를 생성한 후 직접 throw 한다.*/
		}
		if(inputAge<0) {
			AgeErrorException ex = new AgeErrorException();
			/* 예외객체를 throw하면 즉시 에러가 발생한다. 이를 반드시 catch해야한다.
			  그렇지 않으면 JVM에 의해 예외객체가 throw 되는 것과 동일하게 프로그램이
			  비정상 종료된다. */
			throw ex;
		}
		return inputAge;
	}

}
