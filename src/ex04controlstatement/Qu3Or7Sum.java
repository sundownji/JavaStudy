package ex04controlstatement;

public class Qu3Or7Sum {

	public static void main(String[] args) {

//		숫자의 합을 구하는 프로그램을 while문으로 작성. 단,3과 7의 공배수인 경우 합에서 제외
//		21부터 줄줄 출력의 결과는 누적되는 모든 수를 콘솔에 print()하래
		int total = 0;
		int a =1;
		while(a<=100) {
			if(a%3==0|| a%7==0) {
				if(a%(3*7)!=0) {
				total += a;
				System.out.print(a);
				if(a<99) System.out.print("+");
				}
			}
			a++;
		}
		System.out.println("3의배수 이거나 7의 배수의 숫자 합:"+total);
	}

}
//공배수는 제외하기 전 코드