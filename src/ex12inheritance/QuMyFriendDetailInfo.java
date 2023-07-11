package ex12inheritance;

//친구의 정보를 저장할 기본클래스
class MyFriendInfo{
	private String name;
	int age;
	
	//생성자 메서드
	public MyFriendInfo(String n, int a) {
		name = n;
		age = a;
	}
	public void showMyFriendInfo() {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
	
}
//친구의 기본정보 외 상세정보를 저장할 클래스
class MyFriendDetailInfo extends MyFriendInfo
{
	private String addr;
  	private String phone;
  	
  	public MyFriendDetailInfo(String name,int old, String add, String n) {
  		super(name,old);
  		addr = add;
  		phone = n;
  	}
  /* 매개변수랑 이름 똑같이 만드는 예시
   * public MyFriendDetailInfo(String name,int age, String addr, String phone) {
  		//부모클래스의 생성자 호출
  		super(name,age);
  		//자신의 멤버변수 초기화
  		this.addr = addr;
  		this.phone = phone;
  	} */
	public void showMyFriendDetailInfo(){
		showMyFriendInfo();
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}
class QuMyFriendDetailInfo {
	public static void main(String[] args) {
		MyFriendDetailInfo mfd = new MyFriendDetailInfo("이순신",100,"성균관","010-1000-8888");
		mfd.showMyFriendDetailInfo();
		//이름, 나이, 주소, 전화번호를 인자로 객체를 생성…
		//정보Print
	}
}
