package ex07string;

import java.util.Scanner;

public class QuValidateld {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력하세요:");
		String id = scanner.nextLine();
		boolean idch = idValidate(id);
		if(idch==true) {
			System.out.println("사용가능한 아이디입니다.");
		}
		else {
			System.out.println("사용불가한 아이디입니다. 다시 입력해주세요.");
		}
	}
	static boolean idValidate(String inputId) {
		
		boolean idch = true;
		
		if(8<=inputId.length()&&inputId.length()<=12) {
			for(int i=0; i<inputId.length(); i++) {
				char idchr = inputId.charAt(i);
				
				if(!('0'<=idchr && idchr<='9' || ('a'<=idchr && idchr<='z') ||
						('A'<=idchr && idchr <='Z'))  ) {
					System.out.println(idchr+"=>허용안됨");
					idch = false;
					break;
				}
			}
		}
		else {
			idch = false;
	}
		return idch;

	}
}

