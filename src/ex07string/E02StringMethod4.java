package ex07string;
/*
시나리오] 주민등록번호를 이용하여 성별을 판단하는
프로그램을 charAt()을 이용해서 작성하시오.
190419-3000000 => 남자
190419-4000000 => 여자


시나리오] 해당 문자열이 이메일 형식인지 검사하는
프로그램을 contains()를 이용해서 작성하시오.
hong@daum.net => 이메일형식임
not@naver => 이메일형식이아님


시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()를
이용해서 작성하시오.
	

시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
작성하시오. 
파일명 : my.file.images.jpg

*/
public class E02StringMethod4 {

	public static void main(String[] args) {
		String str1 = "190419-3000000";
		String str2 = "190419-4000000";
		
		System.out.println("=====1번=====");
		if(str1.charAt(7)=='1'|| str1.charAt(7)=='3') {
			System.out.println("남자");
		}
		else if(str2.charAt(7)=='2'|| str2.charAt(7)=='4') {
			System.out.println("여자");
		}
		else {
			System.out.println("주민번호가 잘못 입력되었습니다.");
		}
//		if(str2.charAt(7)=='2'||)
//		System.out.println("str1의 주민등록번호 두번째 줄의 첫번째:"+str1.charAt(7));
//		System.out.println("뒷자리에 1,3이 들어가면 남성이다.");
//		System.out.println("str2의 주민등록번호 두번째 줄의 첫번째:"+str2.charAt(7));
//		System.out.println("뒷자리에 2,4가 들어가면 여성이다.");
		
		System.out.println("=====2번====="); //contains()를 이용해서 작성
		String str3 = "hong@daum.net";
		String str4 = "not@naver";
		if(str3.contains("@")&& str3.contains(".")) {
			System.out.println("이메일 형식 맞습니다.");
		}
		else {
			System.out.println("이메일 형식이 아닙니다.");
		}
		//indexOf(), split()으로 구현해보기
	
		System.out.println("=====3번=====");
		//만약에 사용자가 쓴 숫자로 판단하는걸로 만들려면 어떻게 만들어야 할꽈
		int index = str1.indexOf("-")+1;
		//int index2 = str2.indexOf('-')+1; 여자로 하려면 
		if(str1.charAt(index)=='1' || str1.charAt(index)=='3') {
			System.out.println("남자");
		}
		else if(str1.charAt(index)=='2' || str1.charAt(index)=='4') {
			System.out.println("여성");
		}
		
		
		System.out.println("=====4번=====");
		//파일명에서 확장자만 잘라내는 프로그램이라 바꾸지않아도 되는 듯
		String str5 ="my.file.images.jpg";
		int indexNum =str5.lastIndexOf(".")+1;
		System.out.println("내가 찾은 인덱스:"+indexNum);
		String fileExt =str5.substring(indexNum);
		System.out.println("파일확장자:"+fileExt);

		System.out.println(str5.replace(".jpg", ".img"));
	}

}
