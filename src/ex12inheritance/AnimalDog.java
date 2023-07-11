package ex12inheritance;

public class AnimalDog extends Animal {
	//확장한 멤버변수
	String dogKind;
	String name;
	
	public void bark() {
		System.out.println("이름은 "+ name +"고 종은 "+callAni()+"인 "+dogKind+"인 강아지가 짖는다.");
	}
	public void showDog() {
		super.showAnimal();
		System.out.println("강아지의 종류:"+dogKind);
		System.out.println("강아지의 이름:"+name);
	}
	public AnimalDog(String species, int age, String gender,String dogKind,String name) {
		super(species,age,gender);
		this.dogKind=dogKind;
		this.name=name;
	}

}
