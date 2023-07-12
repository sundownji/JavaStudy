package ex12inheritance;

class Myclass{
	//멤버변수
	private int a;
	private String b;
	private double c;
	private boolean d;
	//생성자
	public Myclass(int a, String b, double c, boolean d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	//게터,세터
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	
	
}
public class Test2 {

	public static void main(String[] args) {
		Myclass myClass = new Myclass(1, "안녕", 3.14, true);
		System.out.println("a="+ myClass.getA());
		
		myClass.setA(99);
		System.out.println("a="+myClass.getA());
	}

}
