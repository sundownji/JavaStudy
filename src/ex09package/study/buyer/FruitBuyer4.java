
package ex09package.study.buyer;


public class FruitBuyer4{
	//멤버변수 선언<멤버변수 이름 위에 과일판매자와 동일하지만 클래스가 달라서 상관없다.>
	int myMoney; //보유금액
	int numOfApple; //구매한 사과의 갯수
	
	//멤버변수의 초깃값을 제거한 후 초기화메서드를 추가한다.
	public FruitBuyer4(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}

	public void buyApple(ex09package.study.seller.FruitSeller4 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+myMoney);
		System.out.println("[구매자]사과갯수:"+numOfApple);
	}
}
