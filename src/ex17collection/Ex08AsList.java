package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Ex08AsList {

	
	public static void listPrint(String title, List<String> list) {
		System.out.println("# "+ title);
		for(Object ob: list) {
			System.out.print(ob+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String[] strArr = new String[] {"마린","파이어뱃","메딕","마린"};
		List<String> list = Arrays.asList(strArr);
		listPrint("출력1",list);

		list.add("탱크");
		
		list = new ArrayList<String>(list);
		boolean isAdd =list.add("탱크");
		System.out.println("add결과:" + isAdd);
		listPrint("출력2", list);
		
		System.out.println("# 출력3");
		for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		HashSet<String> set = new HashSet<String>(list);
		list = new ArrayList<String>(set);
		listPrint("출력4",list);
	}

}
