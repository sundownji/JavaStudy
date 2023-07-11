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
/*	foreach(개선된 for문)는 배열의 전체 원소를 참조할때 주로 사용한다. 
배열에 저장된 원소를 하나씩 꺼내서 좌측의 변수에 참조형태로 전달한다. 
원 배열의 값을 변경해야 한다면 사용하지 않는것이 좋다. 
 
for(int e : arr) {
	System.out.print(e+" ");
	sum += e;
}
System.out.println("\n배열전체 원소의 합:"+ sum);
*/

