package ex08class;
/*시나리오] 은행계좌를 추상화 해보자.
 멤버변수 : 예금주
 		계좌번호
 		잔고
 멤버메서드: 입금하다
 		출금하다.
 		계좌잔고조회
 조건1: 입금은 무제한으로 가능함
 조건2: 잔고가 부족한 경우에는 출금불능 처리*/
//class에 필요한 거 멤버변수, 멤버메서드
class Account{
		//멤버변수
		String name;
		//계좌 연산의 대상이 아니기 때문에 String 타입을 사용함
		String accountNumber;
		//잔고의 경우 입출금 연산이 필요함으로 int 타입으로 선언함
		int balance;
		
		//멤버메서드
		//입금처리 : 매개변수로 전달된 money원 만큼 잔고에 합산
		void deposit(int money) {
			balance += money;
			System.out.println(money+"원 입금");
		}
		//출금처리 : 
		void withdraw(int money) {
			//출금을 위해 잔고와 출금액을 비교 처리
			if(balance >= money) {
				//잔고가 출금할 금액보다 같거나 크면(충분하면) money만큼 차감
				balance -= money;
				System.out.println("계좌에서 "+money+"원 출금");
			}
			//잔고보다 출금액이 크다면 출금할 수 없다.
			else {
				System.out.println("잔고부족으로 출금불가능");
			}
		}
		//계좌조회 : 예금주와 현재 잔고 등을 출력한다.
		void showAccount() {
			System.out.println("계좌주:"+ name);
			System.out.println("계좌번호:"+ accountNumber);
			System.out.println("잔고:"+balance);
		}
		//초기화메서드 : 멤버변수를 매개변수로 전달된 값을 통해 초기화한다.
		void init(String n, String a, int b) {
			name = n;
			accountNumber = a;
			balance= b;
		}

	}
public class E04AccountMain {

		public static void main(String[] args) {
			
			//첫번째 계좌 인스턴스 생성
			Account account = new Account();
			//init이라는 초기화메서드를 활용해 객체를 초기화함
			account.init("장동건", "111-21-9999", 1000);
			//입금과 출금을 진행한 후 계좌정보를 확인한다.
			account.deposit(9000);
			account.withdraw(5000);
			account.showAccount();
			
			//두번째 계좌 인스턴스 생성
			Account account2 =new Account();
			//멤버변수에 직접 접근하여 인스턴스를 초기화한다.
			account2.name ="송강";
			account2.accountNumber ="123-4567-890123";
			account2.balance = 9000000;
			account2.showAccount();
		}
}