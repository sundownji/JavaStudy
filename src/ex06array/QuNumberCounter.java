package ex06array;

public class QuNumberCounter {

	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];
//		for(int i=0; i<answer.length; i++) {
//			counter[i] += answer[i];
		
//		counter[0]=answer[1];
		counter[0]=3;
		counter[1]=2;
		counter[2]=2;
		counter[3]=4;
		System.out.println("counter[0] => "+counter[0]);
		System.out.println("counter[1] => "+counter[1]);
		System.out.println("counter[2] => "+counter[2]);
		System.out.println("counter[3] => "+counter[3]);

	}

}
