package ex09package;

import ex09package.study.buyer.FruitBuyer4;

/* 첫번째 버전은 각 클래스의 멤버변수가 고정된 초기값으로 선언되어 상태가 다른
 	인스턴스를 생성할 수 없다는 단점이 있었다. 
 * 두번째 버전에서는 초기화 메서드를 추가하여 다양한 초기값을 가진 인스턴스를
 	생성할 수 있다.*/

import ex09package.study.seller.FruitSeller4;


//과일판매자를 추상화 한 클래스

//구매자를 추상화 한 클래스

public class E03FruitSalesMain4 {

	public static void main(String[] args) {
		
		/*
		생성자를 사용해서 인스턴스를 생성하면 생성과 동시에 초기화 할 수 있으므로
		초기화 메서드를 사용하는 것보다 적은 코드로 작성할 수 있다.
		*/
		//판매자 1: 사과 100개 단가 1,000원 정의
		
		FruitSeller4 seller1 =new FruitSeller4(0, 100, 1000);
		
		//판매자 2:사과 80개 단가 500원으로 정의
		FruitSeller4 seller2 =new FruitSeller4(0, 80, 500);
		
		//구매자 : 보유금액 10,000원
		FruitBuyer4 buyer =new FruitBuyer4(10000, 0);
		
		System.out.println("===================");
		System.out.println("구매행위가 일어나기 전의 상태");
		//구매행위가 일어나기 전에 재고수량은 100개, 80개, 현재잔액은 10,000원
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();

		//각각의 판매자에게 5000원씩 지불하고 사과를 구매한다.
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
