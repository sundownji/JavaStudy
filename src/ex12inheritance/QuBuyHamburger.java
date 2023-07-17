package ex12inheritance;


class Burger {
		//멤버변수
		/* 버거명, 가격, 패티, 소스, 야채 표현 */
		String burgerN;
		private int price;
		String patty;
		String source;
		String vegetable;
		
		//인자생성자
		public Burger(String burgerN, int price, String patty, String source, String vegetable) {
			this.burgerN = burgerN;
			this.price = price;
			this.patty = patty;
			this.source = source;
			this.vegetable = vegetable;
		}
		
		//getter : price만 필요
		public int getPrice() {
			return price;
		}

		
		//햄버거 정보 출력
		/* 버거명, 가격, 식재료 출력*/
		public void showburger() {
			System.out.println("버거명:"+burgerN);
			System.out.println("가격 :" + price);
			System.out.println("식재료 :"+patty+source+vegetable);
			System.out.printf("식재료:%s,%s,%s\n,"+patty,source,vegetable);
		}
		
	
	}
	//햄버거의 기본가격 추상화 
class HamburgerPrice {
		//멤버변수
		/* 햄버거종류, 음료, 프렌치프라이 */
		Burger burger;
		final int COKE = 1000;
		final int POTATO = 1500;
		
				
		//인자생성자: 멤버상수는 이미 초기화되어 있으므로 햄버거 인스턴스만 초기화한다.
		public HamburgerPrice(Burger burger) {
			this.burger = burger;
	
		}
		//기본가격계산
		public int showdefultprice() {
			return burger.getPrice()+COKE+POTATO;
		
		}

		//햄버거와 결제금액 출력
		public void showPrice() {
			burger.showburger(); //햄버거의 정보 출력
			System.out.printf("결제금액: %d\n",showdefultprice());
			System.out.println("=============================");
			}
	
}
//세트가격을 추상화(기본가격을 상속)
class SetPrice extends HamburgerPrice {	
		//멤버변수 없음
	
		//인자생성자
		public SetPrice(Burger burger) {
			super(burger);
		}
		
		//세트가격계산(오버라이딩)
		@Override
		public int showdefultprice() {
			//return super.price() -500;
			return burger.getPrice()+COKE+POTATO-500; 

		}
	
		//햄버거와 세트결제금액 출력(오버라이딩)	
		@Override
		public void showPrice() {
			burger.showburger();
			System.out.printf("세트결제금액: %d\n",showdefultprice());

		}
		
}
	

	public class QuBuyHamburger {

		public static void main(String[] args) {
			
			//치즈버거 객체 생성
			Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
			//치킨버거 객체 생성
			Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상추");
			
			//치즈버거를 기본가격으로 구매
			HamburgerPrice price1 = new HamburgerPrice(burger1); 
			price1.showPrice();	// 4500원	
			
			//치킨버거를 세트가격으로 구매
			HamburgerPrice price2 = new SetPrice(burger2); 
			price2.showPrice();	// 5000원
		}
	}

