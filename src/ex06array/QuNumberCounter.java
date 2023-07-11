package ex06array;

public class QuNumberCounter {

	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];
		for(int i=0; i<answer.length; i++) {
		counter[answer[i]-1]++;
		}
		for(int i = 0; i<counter.length; i++) {
			/*
			printf를 통해 출력문을 생성할때는 항상 완성된 출력문을 먼저 작성한 후
			서식문자와 변수를 이용해서 하나씩 수정해 가면서 완성한다. 
			 */
			//System.out.printf("counter[0] 1의갯수 => 3");
			System.out.printf("counter[%d] %d의 갯수 => %d\n", i ,i+1, counter[i]);
		}
//			counter[i] += answer[i];
		
//		counter[0]=answer[1];
//		counter[0]=3;
//		counter[1]=2;
//		counter[2]=2;
//		counter[3]=4;
//		System.out.println("counter[0] => "+counter[0]);
//		System.out.println("counter[1] => "+counter[1]);
//		System.out.println("counter[2] => "+counter[2]);
//		System.out.println("counter[3] => "+counter[3]);

	}

}
