package ex12inheritance;

import java.util.Scanner;

/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로 인스턴스 생성은 하지 않는다.
단지 기본정보를 저장하고 상속을 목적으로 정의된 클래스이다.
이와 같이 데이터를 저장하기 위한 용도의 클래스를 가르켜 VO(Value Object)라고 한다.
즉 값만 가진 객체라는 뜻이다. 
*/
class Friend {
	//멤버변수: 이름,번호,주소 기본정보 3가지를 저장
	String name;
	String phone;
	String addr;
	
	//생성자 : 멤버변수 초기화
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버메서드:멤버변수에 저장된 모든 정보를 출력하는 메서드
	public void showAllDate() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);
		System.out.println("주소:"+addr);
	}
	//실행부가 없는 상태로 만들어진 간략 정보를 출력하기 위한 메서드로 정의.
	//해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의
	public void showBasicInfo() {}
	
}
//프렌드 클래스를 상속받아 확장한 고닥교친구 클래스:고닥교 친구 정보를 저장할 클래스
class HighFriend extends Friend{
	//자식 클래스에서 확장한 멤버변수: 별명
	String nickname;
	//생성자: 부모의 생성자를 먼저 호출한 후 멤버변수 초기화. 
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/* 오버라이딩1: 고딩 친구의 전체정보를 출력하기 위해 부모에서 정의한 메서드를 super를 통해 호출하고,
	 자식에서 확장한 변수를 추가해서 출력한다. */
	@Override
	public void showAllDate() {
		System.out.println("==고닥교친구(전체정보)==");
		super.showAllDate();
		System.out.println("별명:" + nickname);
		
	}
	/*오버라이딩2: 자식 클래스에서 오버라이딩하여 재정의한 메서드로 고딩친구의 간략한 정보를 출력한다.
	  부모클래스에서는 실행부가 없는 상태로 정의되었다. */
	@Override
	public void showBasicInfo() {
		System.out.println("==고닥교친구==");
		System.out.println("별명:" + nickname);
		System.out.println("전번:" + phone);
	
	}
}
//대학교 친구 정보를 저장하기 위한 클래스 
class UnivFriend extends Friend{
	//확장된 멤버변수:전공
	String major;
	
	//생성자:부모 먼저 호출한 후 멤버변수 초기화
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	/*오버라이딩1: HighF클래스와 동일한 패턴으로 정의 */
	@Override
	public void showAllDate() {
		System.out.println("===대딩친구(전체정보)===");
		super.showAllDate();
		System.out.println("전공:"+major);
	}
	/*오버라이딩2: HighF클래스와 동일한 패턴으로 정의 */
	@Override
	public void showBasicInfo() {
		System.out.println("===대딩친구===");
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);

	}
	
}
//메인클래스
public class E10MyFriendInfoBook {
	/* 메뉴를 출력하는 용도의 메서드로 매개변수,반환타입이 없는 형태로 정의되어있다.
	   main()에서 직접 호출하기 위해 static으로 선언되어있다. */
	public static void menuShow() {
		System.out.println("-----메뉴를 입력하세요.-----");
		System.out.print("1.고딩친구입력");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색");
		System.out.print("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");		
	}
	/*
	 * 무한루프 조건으로 사용자가 원할 때 종료할 수 있는 구조를 만들어준다.
	   break문은 반복문을 탈출시키는 기능이 있으므로 이와 같은 무한루프에서 자주 사용한다.
	 - 메인메서드()에서는 특별한 기능을 구현하지 않고 프로그램 전반의 흐름에 대해서만 담당한다. 
	*/
	public static void main(String[] args) {
		//사용자 입력을 받기 위해서 Scanner 인스턴스 생성
		Scanner scan =new Scanner(System.in);
		//기능을 담당하는 핸들러 클래스의 인스턴스 생성
		FriendInfoHandler handler = new FriendInfoHandler(100);
		while(true) {
			//1.메뉴를 출력한다.
			menuShow();
			//2.사용자는 수행할 기능의 메뉴를 선택한다.
			int choice = scan.nextInt();
			//3.선택한 번호에 따라 switch문으로 각 메서드를 호출한다.
			
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllDate();
				break;
			case 4:
				handler.showSimpleInfo();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램종료");
				return;//메인함수 리턴이면 프로그램 종료임
			}
		}
	}

}
class FriendInfoHandler{
	
	private Friend[] myFriends;
	private int numOfFriends;
	//생성자
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	//친구 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:");iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {
			System.out.print("전공:");iMajor = scan.nextLine();
			myFriends[numOfFriends++]= new UnivFriend(iName,iPhone,iAddr,iMajor);
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	//친구의 전체 정보 출력
	public void showAllDate() {
		System.out.println("showAllDate 호출됨");
	}
	//친구의 간략 정보 출력
	public void showSimpleInfo() {
		System.out.println("showSimpleInfo 호출됨");
	}
	//정보 검색
	public void searchInfo() {
		System.out.println("searchInfo 호출됨");
	}
	//정보 삭제
	public void deleteInfo() {
		System.out.println("deleteInfo 호출됨");
	}
}