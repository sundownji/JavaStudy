package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

public class QuArrayList {

	public static void main(String[] args) {
		
		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
			
		//1.검색할 이름을 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 이름:");
		String searchName =scanner.nextLine();
			
		//2.확장for문으로 컬렉션 전체를 접근
		//list 인덱스는 0부터 시작이므로 초기값은 -1로 설
		int index = -1;
		for(Student st : list) {
			if(st.getName().equals(searchName)) {
				index = list.indexOf(st);
				System.out.println("찾은 인덱스:"+index);
			}
		}
		
		if(index==-1) {
			System.out.println("검색 결과가 없습니다. ");
		}
		else {
			Student stu = list.remove(index);
			System.out.println("다음 정보가 삭제되었습니다.");
			System.out.println(stu);
		}
		
		System.out.println("전체정보를 출력합니다.");
		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			System.out.println(s);
		}
		//3.검색결과 유/무에 따라 
		//검색결과 있을때…검색된 데이터 삭제
		//검색결과 없을때...검색결과가 없다고 출력

		//4.전체정보 출력
	}


}
