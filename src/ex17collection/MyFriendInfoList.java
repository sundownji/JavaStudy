package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
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
public class MyFriendInfoList {
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

	public static void main(String[] args) {
		//사용자 입력을 받기 위해서 Scanner 인스턴스 생성
		Scanner scan =new Scanner(System.in);
		//기능을 담당하는 핸들러 클래스의 인스턴스 생성
		//컬렉션은 인스턴스 생성시 크기를 지정할 필요가 없다.
		//데이터의 갯수에 따라 자동으로 증가된다.
		FriendInfoHandler handler = new FriendInfoHandler(int 3);
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
//	private Friend[] myFriends;
//	private int numOfFriends;
	
	/*기존에 인스턴스배열에 저장했던 것을 컬렉션으로 변경한다. 컬렉션은 제네릭을 기반으로
	 하므로 인스턴스 생성시 저장할 객체의 타입을 결정하게 된다. 여기서는 Friend클래스를
	 상속한 High, Univ를 저장할 것이므로 아래와 같이 선언하면 된다.*/
	ArrayList<Friend> lists;
	
	//생성자: 컬렉션은 데이터 저장시 자동인덱싱이 되므로 크기는 필요없다.
	public FriendInfoHandler(int num) {
		lists = new ArrayList<Friend>();

	}
	
	/*
	 연습문제] List컬렉션을 기반으로 친구(고딩/대딩) 정보를 추가하는 프로그램을 작성하시오.
	 1차는 추가/출력1/출력2까지 진행합니다.
	 출력1은 확장 for문을 통해 구현하세요.
	 출력2는 이터레이터를 통해 구현하세요.
	 
	 */
	
	//친구 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		/*고딩 or 대딩 모두 기본정보가 있으므로 먼저 입력받는다.*/
		String iName,iPhone,iAddr,iNickname,iMajor;
		//공통정보 입력받기
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			//고딩친구 정보 추가
			System.out.print("별명:");iNickname = scan.nextLine();
			/*High 인스턴스를 생성 해당 인스턴스는 자신의 타입이나 부모인 Friend에
			 저장할 수 있다.*/ 
			Friend f = new HighFriend(iName, iPhone, iAddr, iNickname);	
			lists.add(f);
		
		}
		else if(choice==2) {
			//대학교친구
			//next() = nextLine() 같은거임
			System.out.print("전공:");iMajor = scan.next();
			//부모기 때문에 바로 접근 가능
			lists.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		/*기존 객체 배열은 정보를 추가할때마다 인덱싱을 위해 변수를 ++ 하는 부분이
		 필요하겠지만, List의 경우 자동인덱싱을 지원하므로 단지 추가만 해주면된다.*/
	}

	//친구의 전체 정보 출력(확장 for문 사용)
	public void showAllDate() {
		for(int i = 0; i<lists.size(); i++) {
			lists.get(i).showAllDate();
		}
		System.out.println("===전체정보 출력====");
		/* 배열,변수,정보 꺼내오기
		 * 확장for문의 형식
		 	=>for(저장된 타입 참조변수:반복 할 배열 or 컬렉션(인스턴스)){
		 */
//		for(Friend fr: myFriends) {
//			fr.showAllDate();
//			System.out.println(fr.showAllDate()); 프린트 안에서 프린트 부르는 거 오류		
		}
	
	//사용법이 다른 거지 fr.=.next는 같은 것이라고 생각하면 된디
	//친구의 간략 정보 출력(이터레이터 사용) itr 이터레이터 변수 이름으로 자주사용
	//이터레이터 단계가 하나 추가된다고 생각하면 된다.
	//하나씩 꺼내는게 포인트
	public void showSimpleInfo() {
		for(Friend fr:lists) {
			fr.showBasicInfo();
		}
		System.out.println("==간략 정보가 출력==");
//		Iterator<Friend> itr = lists.iterator();
//		//원소가 있는지 알수 있는 함수 hasNext()
//		while(itr.hasNext()) {
//			itr.next().showBasicInfo();
//		}
	}	
	
	/////////////////////////////////////////////////////////////
	//정보 검색
	/*연습문제] 이름을 입력받아 연락처를 검색하는 메소드 작성 확장 프로그램 복붙 if문*/
	public void searchInfo() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요.:");
		String searchName = scan.nextLine();
		
		Iterator<Friend> itr = lists.iterator();
		while(itr.hasNext()) {
			Friend fr = itr.next();
			if(searchName.compareTo(fr.name)==0) {
				fr.showAllDate();
				System.out.println("==귀하가 요청하는 정보를 찾았습니다==");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("==찾는 정보가 없습니다.");
//		//저장된 갯수만큼 반복해서 검색
//		for(Friend fr:myFriends) {
//			//입력한 이름과 일치하는 항목을 찾는다.
//			if(searchName.equals(fr.name)){
//				fr.showBasicInfo();
//				isFind = true;
//			}
//		}
//		
//		if(isFind==true) 
//			System.out.println("일치하는 정보를 찾았습니다.");
//		else {
//			System.out.println("일치하는 정보가 없습니다.");
//		}
		
		
		
		
		//배열에 저장된 연락처의 갯수만큼 반복한다.(하나 드가면 하나 증가한 거 알)
//		for(int i=0; i<numOfFriends; i++) {
//			if(searchName.compareTo(myFriends[i].name)==0) {
//				//연락처의 전체정보를 출력한다.
//				myFriends[i].showAllDate();
//				System.out.println("--귀하가 요청하신 정보를 찾았습니다.--");
//				//확인용 변수 true로 변경한다.
//				isFind = true;
//			}
//		}
//		//false를 유지하고 있다면 검색결과가 없고 못 찾은 거라서 아래와 같이 출력한다.
//		if(isFind==false)
//			System.out.println("--없는 정보입니다.--");
	}
	/*오늘의 숙제] 삭제할 이름을 입력받은 후 삭제하는 메서드를 구현하시오.*/
	
	//연락처 정보 삭제
	public void deleteInfo() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		for(Friend fr: lists) {
			if(deleteName.compareTo(fr.name)==0) {
				lists.remove(fr);
				deleteIndex = 1;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터 없음");
		}
		else {
			System.out.println("데이터 삭제");
		}
		
	}
//		Iterator<Friend> itr = lists.iterator();
//		while(itr.hasNext()) {
//			Friend fr = itr.next();
//			if(fr.name.equals(deleteName)) {
//				lists.remove(fr);
//				isFind = true;
//				break;
//			}
//		}
		
		
		
//		for(Friend fr:myFriends) {
//			if(deleteName.equals(fr.name)){
//				myFriends.remove(fr);
//			}
//		}
//			//입력한 이름과 일치하는 항목을 찾는다.
////				fr.showAllDate();
//				System.out.println(myFriends.remove(deleteName));
//			}
//				System.out.println("삭제 완료");
//				isFind = true;
//		
			}		
		
		
	
			

//		/* 배열의 원소 중 삭제된 원소의 인덱스값을 저장하기 위한 변수로
//		  삭제한 후 빈자리를 채워넣을 때 사용한다. 인덱스는 0부터 시작이므로 
//		  -1를 초기값으로 설정한다. */
//		int deleteIndex = -1; // 변수를 -1로 생성
//		
//		//삭제할 데이터를 찾기위해 저장된 갯수만큼 반복한다.
//		for(int i=0; i<numOfFriends; i++) { 
//			//입력된 이름과 일치하는지 확인한다. 
//			if(deleteName.compareTo(myFriends[i].name)==0) {
//				/* 인스턴스 배열에서 삭제는 null로 변경하면 된다. 참조값이 null이라는 것은
//				   참조할 인스턴스가 없다는 의미이므로 삭제하는 것과 동일한 결과가 된다. */
//				myFriends[i] = null; 
//				//삭제된 원소의 index를 저장한다.
//				numOfFriends--; 
//				//전체 카운트를 1 차감한다.
//				//하나의 객체를 삭제하면 즉시 for문을 탈출 (바로 반복문 탈출하기 위해 break 사용한다.)
//				break;
//			}
//		}
//		//삭제된 데이트가 없는 경우 -1을 유지 print문 출력
//		if(deleteIndex==-1) { //근데 변수 -1로 되었던 게 그대로면 삭제된 데이터가 없는거라
//			System.out.println("--삭제된 데이터가 없습니다.--"); //프린트문 출력
//		}
//		else {
//			/*만약에 인스턴스 배열에서 원소를 삭제한 후 바로 뒤에 있는 원소를 앞으로 하나씩
//			  복사한다. 만약 이 부분이 처리되지 않는다면 차후 검색이나 삭제시
//			  NullPointerException이 발생할 수 있다. */
//			for(int i=deleteIndex; i<numOfFriends; i++) {
//				myFriends[i] = myFriends[i+1]; 
//			}
//			//삭제된 결과를 출력
//			System.out.println("==데이터("+deleteIndex+"번)가 삭제되었습니다.==");
//		}
	
