package ex16exception;

public class Ex02PreDefineException6 {
	 
	public static void main(String[] args)  {	
		/*오브젝트 클래스를 단독적으로 생성한 경우 다른 클래스와의 상속관계가
		 전혀 없는 상태이므로 이 상태에서는 형변환을 할 수 없어 예외가 발생*/
		Object object = new Object();//오브젝트 무조건 최상위, 부모임
		try {
			//string 타입 형변환 에러 -> 오브젝트
			//순수한 Object객체이므로 자식 타입으로 형변환 할 수 없다.
			String strObject = (String)object;
		}
		catch(ClassCastException e) {
			System.out.println("형변환 할 수 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("==ClassCastException발생후==");
			
		System.out.println("끝~~~");
		
		String str = "형변환되나요?";
		boolean castFlag = myClassCasting(str);
		if(castFlag==true)
			System.out.println("됩니다요..");
		else
			System.out.println("안되네요..ㅜㅜ;");
				 
	}////end of main	
	
	/**/
	public static boolean myClassCasting(Object o) {
		if(o instanceof String) {
			return true;
		}
		else {
			return false;
		}
	}
}

