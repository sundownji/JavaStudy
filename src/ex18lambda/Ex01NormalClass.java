package ex18lambda;

interface ISchool1{
	void studyLamba(String str);
}
class Student1 implements ISchool1{
	@Override
	public void studyLamba(String str) {
		System.out.println(str+"을 공부합니다.");
	}
}
public class Ex01NormalClass {

	public static void main(String[] args) {
		ISchool1 sch = new Student1();
		sch.studyLamba("람다식");

	}

}
