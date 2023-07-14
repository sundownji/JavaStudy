package ex06array;

public class QuArray1To10 {

	public static void main(String[] args) {
		System.out.println("초기화된 배열 요소");
		
		int[] numarr = new int[10];
		//0~9까지 +1 하면 1~10
		for(int i=0; i<=numarr.length; i++ ) {
			numarr[i]= i+1;}
		
		int sum =0;
		//배열전체를 기준으로 해서 왼쪽에 참조형태로 원소를 꺼내주는 방법 인덱스가 필요 없음
		//표기 하지 않아도 변수를 순수하게 사용해서 원소를 순차적으로 꺼내서 왼쪽 변수에 담아 사용가능
		for(int e : numarr) {
			System.out.print(e+" ");
			sum += e;
		}
		System.out.println("배열전체의 요소 합:"+sum);

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

