package quiz;

import java.util.Random;
import java.util.Scanner;

/*

난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
승부를 판단하여 출력한다.
1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.

 무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 1
사용자 : 가위, 컴퓨터 : 보
이겼습니다.

무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 4
가위바위보 할줄 모르세요? 제대로 내세요^^;

….게임진행...

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 1

….게임재시작…

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 0
게임이 종료되었습니다. 감사합니다.

….게임종료….

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 5
잘못입력하셨습니다. 재시작(1), 종료(0)중에 입력하세요…..

*/
public class QuRockPaperScissors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int player = scanner.nextInt();
		int com = 0;
		Random r = new Random();
		com = r.nextInt(3)+1;
		System.out.println("무엇을 내겠습니까? (1:가위,2:바위,3:보):");
		System.out.println("사용자:"+player+",컴퓨터:"+com);
		
		if(player == 1) {
			if(com == 2) {
				System.out.println("이겼습니다.");
			}
			else if(com == 3) {
				System.out.println("졌습니다.");
			}
			else {
				System.out.println("비겼습니다.");
			}
		}
		else if(player == 2) {
			if(com == 2) {
				System.out.println("비겼습니다.");
			}
			else if(com == 3) {
				System.out.println("이겼습니다.");
			}
			else {
				System.out.println("졌습니다.");
			}
		}
		else if(player == 3) {
			if(com==2) {
				System.out.println("졌습니다. ");
			}
			else if(com == 3) {
				System.out.println("비겼습니다.");
			}
			else {
				System.out.println("이겼습니다.");
			}
		}
		else if(0>= player || player >= 4){
			System.out.println("다시 입력하세요.");
		}

	}

}
