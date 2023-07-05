package ex05method;

import java.util.Scanner;

public class QuSimpleOperation {
		static void arithmetic(int f, int s) {
		System.out.println("덧셈결과:"+(f+s));
		System.out.println("뺄셈결과:"+(f-s));
		System.out.println("곱셈결과:"+(f*s));
		System.out.println("나눗셈 몫:"+(f/s));
		System.out.println("나눗셈 나머지:"+(f%s));
		//printf ( %d %% %d -> % 두개 써야함)
			
		}
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("첫번째 정수를 입력하세요:");
			int first = scanner.nextInt();
			System.out.println("두번째 정수를 입력하세요:");
			int second = scanner.nextInt();
			arithmetic(first,second);
		
	}

}
