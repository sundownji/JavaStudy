package ex09package.study.seller;

public class FruitSeller4 {

		//<다양한 형태의 인스턴스를 만들기 위해서 하드코딩하지말고, 매개변수형태로 전달하고 전달받은 값으로 형태를 바꿔야 고정된 값만 나오지 않음>
		//멤버변수
		//과일판매자가 가지고 있는 사과의 재고수량
		int numOfApple;
		//과일판매자의 수익금
		int myMoney;
		//일반 멤버 변수에서 멤버상수로 바꿈 에러가 나지 않는 이유는 밑에 FruitSeller4 생성자
		//
		final int APPLE_PRICE;
		
		//생성자 만들려면 클래스명과 똑같이 만들어야함, 밑에 public F~쓰고 void를 
		//없애니까 오류가 없어진다. 

		/* 멤버상수는 값의 변경이 불가능하고, 단 한번만 초기화 되어서 일반 멤버메소드에서는
		 	초기화 할 수 없다. 또한 초깃값이 없는 상태로 선언 자체가 불가능하다.
		 	하지만 생성자는 객체 생성시 딱 한번만 호출되고, 개발자가 마음대로 
		 	호출 할 수 없으므로 한번 이상 초기화되지 않음이 보장된다. 
		 	따라서 '멤버상수'는 '생성자'에서 초기화 할 수 있다. */
		public FruitSeller4(int money, int appleNum, int price) {
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
		//판매자의 현재상태를 출력한다.
		public void showSaleResult() {
			System.out.println("[판매자]남은사과갯수:"+ numOfApple);
			System.out.println("[판매자]판매수익:"+myMoney);
		}
	
	}

