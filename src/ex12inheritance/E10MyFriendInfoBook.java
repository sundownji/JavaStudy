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
/*해당 프로그램에서 기능을 담당하는 클래스로 핸들러 혹은 매니저클래스라고 부른다.*/
class FriendInfoHandler{
	//멤버변수
	/* 상속관계에서 부모클래스로 인스턴스 배열을 생성한다. 부모로 자식을 참조할 수 있으므로
	  부모타입의 배열에는 자식타입의 인스턴스를 저장할 수 있다. */
	private Friend[] myFriends;
	/*배열에 저장된 연락처 정보를 카운트하기 위한 멤버변수 추가할때마다 ++연산자로 1씩 증가한다.*/
	private int numOfFriends;
	//생성자:인스턴스 배열의 크기를 인수로 받은 후 초기화한다.
	public FriendInfoHandler(int num) {
		//정보를 저장할 인스턴스 배열을 생성한다.
		myFriends = new Friend[num];
		//배열의 인덱스는 0부터 시작이므로 이와같이 초기화한다.
		numOfFriends = 0;
	}
	//친구 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		/*고딩 or 대딩 모두 기본정보가 있으므로 먼저 입력받는다.*/
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		//입력선택에 따라 고딩 혹은 대딩으로 분기하여 입력받는다.
		if(choice==1) { //고딩을 선택한 경우 별명을 추가로 입력받는다.
			System.out.print("별명:");iNickname = scan.nextLine();
			//HighFriend라는 인스턴스 생성한 후 참조변수에 저장한다.
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			/*참조변수를 인스턴스 배열에 추가한다. 인덱스로 사용된 변수의 초기값이 0이므로,
			  0번 인덱스에 추가한 뒤 1 증가 시킨다. 이를 위해 '후위증가' 하고있다.*/
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {//대딩을 선택한 경우 전공을 추가로 입력받는다.
			System.out.print("전공:");iMajor = scan.nextLine();
			//인스턴스를 생성과 동시에 배열에 추가한다.
			myFriends[numOfFriends++]= new UnivFriend(iName,iPhone,iAddr,iMajor);
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
		/* 더이상 실행할 문장이 없으면 해당 메서드는 메모리에서 소멸되고,
		   호출한 지점인 main 메서드로 돌아간다. */
	}
	/*
	저장된 친구의 정보를 출력하기 위한 멤버메서드 
	1.친구정보를 추가할 때 High 혹은 Univ인스턴스를 배열에 저장한다.
	2.이때 인스턴스는 Friend타입으로 자동형변환(업캐스팅)되어 저장된다.
	3.정보 출력시 배열에 입력된 개체수만큼 반복하여 각 원소를 통해 정보를 출력한다.
	4.출력을 위한 멤버메서드는 상속관계에서 오버라이딩 처리되어 있으므로 참조변수의 영향을
		받지 않고 항상 자식클래스에 오버라이딩 된 메서드가 호출된다.
	5.즉 저장된 인스턴스는 Friend타입이지만 오버라이딩을 통해 별도의 형변환이
		필요하지 않다. 항상 원하는 정보를 간단히 출력할 수 있게된다.
	 */
	//친구의 전체 정보 출력
	public void showAllDate() {
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showAllDate();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	//친구의 간략 정보 출력
	public void showSimpleInfo() {
		/* 만약 부모클래스인 Friend에 showBasicInfo() 메서드를 정의하지 않으면
		  자식클래스에서는 오버라이딩을 할 수 없음으로 개별적인 멤버메서드를 정의해야한다.
		  정보가 저장되는 배열을 Friend타입이므로 자식 인스턴스를 저장하면 자동으로
		  형변환(업캐스팅)된다. 이때 자식의 정보를 출력하는 메서드를 바로 호출할 수 없으므로
		  아래와 같이 일일이 확인한 후 강제형변화(다운캐스팅)를 시켜줘야한다.
		 * for(int i=0; i<numOfFriends; i++) {
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend)myFriends[i]).showBasicInfo();				
			}
			else if(myFriends[i] instanceof HighFriend){
				((HighFriend)myFriends[i]).showBasicInfo();
			}
		}*/
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다.==");
	}	
	
	//정보 검색
	public void searchInfo() {
		//검색결과가 있는지 확인하기 위한 변수
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요.:");
		String searchName = scan.nextLine();
		
		//배열에 저장된 연락처의 갯수만큼 반복한다.(하나 드가면 하나 증가한 거 알)
		for(int i=0; i<numOfFriends; i++) {
			/*배열의 각 인덱스에 저장된 인스턴스의 참조값을 통해 멤버변수에 접근한다.
			  검색을 위해 입력한 이름과 비교해서 일치하는 경우에만 정보를 출력한다.
			  이때 equals()를 사용해도 결과는 동일하다.*/
			if(searchName.compareTo(myFriends[i].name)==0) {
				//연락처의 전체정보를 출력한다.
				myFriends[i].showAllDate();
				System.out.println("--귀하가 요청하신 정보를 찾았습니다.--");
				//확인용 변수 true로 변경한다.
				isFind = true;
			}
		}
		//false를 유지하고 있다면 검색결과가 없고 못 찾은 거라서 아래와 같이 출력한다.
		if(isFind==false)
			System.out.println("--없는 정보입니다.--");
	}
	//정보 삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		/* 배열의 원소 중 삭제된 원소의 인덱스값을 저장하기 위한 변수로
		  삭제한 후 빈자리를 채워넣을 때 사용한다. 인덱스는 0부터 시작이므로 
		  -1를 초기값으로 설정한다. */
		int deleteIndex = -1; // 변수를 -1로 생성
		
		//삭제할 데이터를 찾기위해 저장된 갯수만큼 반복한다.
		for(int i=0; i<numOfFriends; i++) { 
			//입력된 이름과 일치하는지 확인한다. 
			if(deleteName.compareTo(myFriends[i].name)==0) {
				/* 인스턴스 배열에서 삭제는 null로 변경하면 된다. 참조값이 null이라는 것은
				   참조할 인스턴스가 없다는 의미이므로 삭제하는 것과 동일한 결과가 된다. */
				myFriends[i] = null; 
				//삭제된 원소의 index를 저장한다.
				numOfFriends--; 
				//전체 카운트를 1 차감한다.
				//하나의 객체를 삭제하면 즉시 for문을 탈출 (바로 반복문 탈출하기 위해 break 사용한다.)
				break;
			}
		}
		//삭제된 데이트가 없는 경우 -1을 유지 print문 출력
		if(deleteIndex==-1) { //근데 변수 -1로 되었던 게 그대로면 삭제된 데이터가 없는거라
			System.out.println("--삭제된 데이터가 없습니다.--"); //프린트문 출력
		}
		else {
			/*만약에 인스턴스 배열에서 원소를 삭제한 후 바로 뒤에 있는 원소를 앞으로 하나씩
			  복사한다. 만약 이 부분이 처리되지 않는다면 차후 검색이나 삭제시
			  NullPointerException이 발생할 수 있다. */
			for(int i=deleteIndex; i<numOfFriends; i++) {
				myFriends[i] = myFriends[i+1]; 
			}
			//삭제된 결과를 출력
			System.out.println("==데이터("+deleteIndex+"번)가 삭제되었습니다.==");
		}
	}
}