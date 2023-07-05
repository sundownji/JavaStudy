package ex05method;

public class E08RecursiveError {

	public static void main(String[] args) {
		showhi(3);
	}
	/*
	재귀메서드의 오류코드
	1.감소연산자로 인해 cnt의 값은 차감되지만
	2.조건식의 위치가 잘못되어
	3.재귀호출을 하기 전에 종료체크를 할 수 있도록 수정해야 한다.
	
	StackOverflow:스택오버플로우. 스택은 함수가 종료되기 전까지의 모든 정보를 저장하는 메모리이다.
		무한 공간이 아니기 때문에 무한루프에 빠지면 저장능력이 초과해서 해당 에러가 발생한다.
	*/
	public static void showhi(int cnt) {
		System.out.println("HI~!");
		System.out.println("cnt="+cnt);
		//showhi(--cnt); 해당위치에서는 에러가 발생
		/* 위에서 재귀호출이 되므로 if문의 블럭은 실행할 기회가 없어진다. 따라서 if문 블럭
		아래쪽으로 호출문장을 이동해야 한다. */
		if(cnt==1) {
			return;
		}
		showhi(--cnt); //정상적으로 실행되는 위치
	}

}
