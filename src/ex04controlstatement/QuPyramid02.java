package ex04controlstatement;

public class QuPyramid02 {

	public static void main(String[] args) {
		int a = 1;
		do {
			int b =1;
			do {
				System.out.print("*");
				b++;
			}while(a+b<=6);
			a++;
			System.out.println(" ");
		}while(a<=5);
	}

}
