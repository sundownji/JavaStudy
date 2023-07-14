package ex07string;

/*
사용자로 부터 아이디를 입력받은 후 다음 조건에 만족하는지 확인할 수 있는 프로그램을 작성하시오.
아이디는 8~12자 사이로만 사용할 수 있다. (length() 메서드 활용)
영문과 숫자로만 입력할 수 있다. (charAt() 메서드 활용)
특수기호, 공백, 그 외 모든 문자는 입력할 수 없다. 
위 조건에 만족하면 true, 만족하지 않으면 false를 반환한다. 
메서드명 : boolean idValidate(String inputId)
힌트 : (idChar>='a' && idChar<='z') 이와 같은 조건을 사용하면 된당^^*
실행결과]
	아이디를 입력하세요 : kosmo123
	사용할 수 있는 아이디입니다. 

	아이디를 입력하세요 : ko^smo 99
	사용할 수 없습니다.

*/
import java.util.Scanner;

public class QuValidateld {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력하세요:");
		String id = scanner.nextLine();
		
		/* 만약 String을 Javascript처럼 배열로 만들고 싶다면 toCharArray()메서드를
		  사용하면 된다. 해당 메서드는 String을 char타입의 배열로 변환해준다. 
		  toCharArray()인덱스를 통해
		  바로 사용, charat은 인덱스에 접근 가능해서 사용*/
		  char[] charArr = id.toCharArray();
		  for(int i=0; i<charArr.length; i++){
		  	System.out.print(charArr[i]+"-");
		  }
		//아이디 인수로 전달한 후 사용여부에 따라 boolean값을 반환 받
		boolean idch = idValidate(id);
		if(idch==true) {
			System.out.println("사용가능한 아이디입니다.");
		}
		else {
			System.out.println("사용불가한 아이디입니다. 다시 입력해주세요.");
		}
	}
	static boolean idValidate(String inputId) {
		//아이디 유효성 확인용 변수  
		boolean idch = true;
		
		//아이디 길이 검증
		if(8<=inputId.length()&&inputId.length()<=12) {
			//입력한 아이디의 길이만큼 반복 
			//자바 길이만큼 반복, 메서드 활용해 문자 하나씩 뽑아서 아스키코드로 확인
			for(int i=0; i<inputId.length(); i++) {
				char idchr = inputId.charAt(i);
				
				if(!('0'<=idchr && idchr<='9' || ('a'<=idchr && idchr<='z') ||
						('A'<=idchr && idchr <='Z'))  ) {
					System.out.println(idchr+"=>허용안됨");
					idch = false;
					//문자열에서 허용되지 않은 문자를 찾았다면 뒷 부분 없으므로 즉시 반복문 탈출
					break; 
				}
			}
		}
		else {
			//아이디 길이가 잘
			idch = false;
	}
		return idch;

	}
}

