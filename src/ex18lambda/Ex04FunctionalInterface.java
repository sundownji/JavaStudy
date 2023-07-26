package ex18lambda;

interface ISchool4{
	void studyLambda(String str);
	//void studyLambda2(String str);
}
public class Ex04FunctionalInterface {
	
	static void execute(ISchool4 school4, String s) {
		school4.studyLambda(s);
	}
	
	public static void main(String[] args) {
		ISchool4 sch =(str) -> System.out.println("ISchool4를 구현받아 정의한 람다식"
				+str);
		
		execute(sch,"\n람다를 매개변수로 전달합니다.");
	}

}
