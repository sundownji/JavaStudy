package ex07string;

public class E02StringMethod3 {

	public static void main(String[] args) {

		System.out.println("String 클래스의 주요 메소드3");
		
		String str1 = "Welcome to java";
		String str2 = "자바야 놀자!";
		
		/*11]lastIndexOf():사용법은 indexOf()와 동일하지만 문자열의
		 * 뒤에서부터 찾는 것이 다른점이다.*/
		System.out.println(str1.lastIndexOf("ava"));
		System.out.println(str1.lastIndexOf("J"));
		System.out.println("indexOf:"+str1.indexOf("a"));
		System.out.println("LastIndexOf:"+str1.lastIndexOf("a"));
	
		/*12]replace:특정 문자열을 찾아서 지정된 문자열로 변경한다.
		 * 만약 찾는 문자열이 없다면 변경만 되지 않을뿐 에러가 발생하지 않는다.*/
		
		System.out.println("J를 G로 변경하기"); //문자열 변경 없음
		System.out.println(str1.replace("J", "G"));
		System.out.println("java를 korea로 변경하기");//korea로 변경
		System.out.println(str1.replace("java", "korea"));
		
		/*13]split():문자열을 구분자를 통해 분리해서 string타입의 배열로 반환
		 * 해당 구분자가 없는 경우에는 크기가 1인 배열로 반환한다.*/
		System.out.println("###13###");
		String phoneNumber = "010-1234-1234";
		String[] phoneArr = phoneNumber.split("-");
		for(int i=0; i<phoneArr.length; i++) {
			System.out.printf("phoneArr[%d]=%s\n", i, phoneArr[i]);
		}
		phoneArr = phoneNumber.split("%");
		for(int i=0; i<phoneArr.length; i++) {
			System.out.printf("phoneArr[%d]=%s\n", i, phoneArr[i]);
		}
		
		/*14]substring:시작인덱스와 마지막인덱스 사이의 문자열을 잘라서 반환
		 * 방법1:인덱스를 하나만 사용->이 경우 인덱스부터 문자열의 끝까지를 잘라낸다.
		 * 방법2:시작인덱스,종료인덱스를 사용-> 인덱스에 해당하는 부문만 잘라서 반환*/
		
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3,7));
	
	
	
	}

}
