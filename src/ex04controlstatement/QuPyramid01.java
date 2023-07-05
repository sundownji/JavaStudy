package ex04controlstatement;

public class QuPyramid01 {

	public static void main(String[] args) {
		int a = 1;
		while(a<=5) {
			int b = 1;
			while(b<=5) {
				if(a<b) {
					System.out.print(" ");
				}
				else {
					System.out.print("* ");
				}b++;
			}System.out.println("");
			a++;
		}

	}

}
