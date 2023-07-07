package ex10accessmodifier;



/* 첫번째 버전은 각 클래스의 멤버변수가 고정된 초기값으로 선언되어 상태가 다른
 	인스턴스를 생성할 수 없다는 단점이 있었다. 
 * 두번째 버전에서는 초기화 메서드를 추가하여 다양한 초기값을 가진 인스턴스를
 	생성할 수 있다.*/


//과일판매자를 추상화 한 클래스
class FruitSeller3{
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;
	
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+myMoney);
	}
}
class FruitBuyer3{
	int myMoney; //보유금액
	int numOfApple; //구매한 사과의 갯수
	
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}

	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+myMoney);
		System.out.println("[구매자]사과갯수:"+numOfApple);
	}
}
public class E02FruitSalesMain5 {

	public static void main(String[] args) {
				
		FruitSeller3 seller1 =new FruitSeller3(0, 100, 1000);
		
		FruitSeller3 seller2 =new FruitSeller3(0, 80, 500);
		
		FruitBuyer3 buyer =new FruitBuyer3(10000, 0);
		
		System.out.println("===================");
		System.out.println("구매행위가 일어나기 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		//////////////////////////////////////////////
		/* 아래의 코드는 문법적으로는 오류가 없으나 지불금액과 구매한 사과의 관계가
		  전혀 맞지 않는 논리적 오류가 발생되었다. 즉, 코드(메서드)로
		  구현한 규칙이 완전히 무너지게 된다. 객체지향 프로그래밍에서는
		  이런 오류를 막기위해 멤버변수에 대한 '정보은닉'을 권장하고 있다.
		  멤버변수의 외부접근을 원천적으로 차단하고, 멤버메서드를 통해서만
		  접근하게 하여 프로그래밍의 논리적 오류를 차단하는 역할을 한다.*/
		
		seller1.myMoney += 1000; //판매자1에게 1000원 지불
		buyer.myMoney -= 1000; //구매자의 금액 차감
		seller1.numOfApple -= 50; //사과 50개를 구매한다.
		buyer.numOfApple += 50; //구매자는 사과 50개가 증가한다.
		//=1000원 내고 사과 50개 구매하는 모습이다.. 쓰읍
		/////////////////////////////////////////////

		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("===================");
		System.out.println("구매행위가 일어난 후의 상태");
		//5개를 판매
		seller1.showSaleResult();
		//10개를 판매
		seller2.showSaleResult();
		//10,000원 지불하고 15개를 구매
		buyer.showBuyResult();

	}

}
