package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	//멤버변수
	Connection con; //DB 연결을 위한 객체
	Statement stmt; //정적쿼리문 전송 및 실행을 위한 객체
	
	//생성자 (접근지정자 99% public, 반환타입없음, 클래스 이름이랑 같아야함)
	public InsertQuery() {
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
			//e.getStackTrace()
		}
	}
	//DB 자원해제
	public void close() {
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
	//쿼리 작성 후 전송, 쿼리 실행 메서드
	public void execute() {
		try {
			//Statement 객체 생성을 위한 메서드 호출
			stmt = con.createStatement();
			//정적 insert 쿼리문 작성(인파라미터가 없는 쿼리문)
			String sql = "INSERT INTO member VALUES ('test3','3333','테스터3',SYSDATE)";
			//쿼리문 전송하고 실행해서 실제전송된 값을 반환 받음
			int affected = stmt.executeUpdate(sql);
			//insert문 실행에 대한 결과 출력
			System.out.println(affected+"행이 입력되었습니다.");
			//자원반납
			close();
		}
		catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InsertQuery iSQL = new InsertQuery();
		iSQL.execute();
	}

}
