package ex06array;

public class QuArray1To10 {

	public static void main(String[] args) {
		System.out.println("초기화된 배열 요소");
		int[] numarr = new int[10];
		int sum =0;
	
		for(int i=0; i<=numarr.length; i++ ) {
			numarr[i]= i;
			System.out.print((numarr[i]=i+1)+" ");
			sum += numarr[i];
			
		}
		System.out.println("배열전체의 요소 합="+sum);

	}
	
}
