package ex18lambda;

interface ISchool2{
	void studyLambda(String str);
}

public class Ex02AnonymousClass {

	public static void main(String[] args) {

		ISchool2 sch = new ISchool2() {
			
			@Override
			public void studyLambda(String str) {
				System.out.println(str+" 을 공부하기 위해 익명의클래스를 만들어");
			}
				
				
		};


		sch.studyLambda("람다식");

	}

}
