package common;

import java.util.Objects;

public class Student extends Person{
	//자식에서 확장한 멤버변수
	private String stNumber;

	//생성자
	public Student(String name, int age, String stNumber) {
		//자색 객체 생성하기 전 부모생성자를 먼저 호출
		super(name, age);
		this.stNumber = stNumber;
	}
		//객체에 저장된 정보를 문자열 형태로 반환
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString()+", 학번:"+stNumber;
		}

}
