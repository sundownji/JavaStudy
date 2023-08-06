package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
	//멤버변수
	Connection con; //DB 연결을 위한 객체
	Statement stmt; 
	
	public DeleteQuery() {
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//커넥션 url, id, pass 등의 연결정보 기술
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String id = "education";
			String pass ="1234";
			//DB연결 
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("오라클 DB 연결성공");
		}
		catch (Exception e) {
			System.out.println("연결실패");
		}
	}
	//db자원해제
	private void close() {
		try {
			//연결확인 후 자원을 해제한다.
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}
	
	public void execute() {
		try {
			//Statement 객체 생성을 위한 메서드 호출
			stmt = con.createStatement();
			String query = "DELETE FROM member WHERE id='test1'";
			/*insert, delete,update와 같이 행의 변화가 발생되는
			 쿼리문을 실행할때는 executeUpdate() 메서드를 사용한다.
			 해당 쿼리를 실행한 후 영향을 받은 레코드의 갯수가
			 int 타입으로 반환된다.*/
			int affected = stmt.executeUpdate(query);
			System.out.println(affected+"행이 삭제됨");
			
			close();
		}
		catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DeleteQuery().execute();
	}
}
/*실행부가없는메서드 추상메서드 오버라이딩하려고 만드는거임
abstract : 상속 목적
상속 받은 자식쪽에서 오버라이딩해야함
추상메서드 하나 이상 포함한 추상 클래스 만들어야함*/
