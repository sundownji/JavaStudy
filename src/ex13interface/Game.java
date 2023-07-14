package ex13interface;

//default인 애를 하나의 파일로 만들었음
//default가 아닌 public으로 만들어서 확장성이 넓어짐
//자바 하나의 파일안에 하나의 클래스 권장
//클래스 함수 재사용을 하기위해서 그런거임

/* Java에서 하나의 Java파일에 하나의 public클래스만 선언할 수 있다. 따라서 아무리 간단한
  프로그램이라도 확장성을 위해 이와같이 하나의 Java파일에 하나의 public클래스 혹은 인터페이스를
  선언하는 것을 권장한다. */
public interface Game{
	int SCISSORS=1, ROCK=2, PAPER=3;
}