package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class IsMemberProcCall extends IConnectImpl {
	
	public IsMemberProcCall() {
			super("education","1234");
	}
	
	public void execute(){
		try {
			//callable 객체 생성
			csmt = con.prepareCall("{call MyMemberAuth(?,?,?)}");
			//인파라미터 2개 설정
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원 패스워드"));
			//아웃파라미터 1개 설정 - 반환값이므로 타입을 설정한다.
			csmt.registerOutParameter(3, Types.NUMERIC);;
			//프로시저 실행
			csmt.execute();
			//회원인증 결과를 out파라미터를 통해 반환받는다.
			int outParamResult = csmt.getInt(3);
			//회원인증상태에 따라 메세지를 출력한다.
			switch(outParamResult) {
			case 0:
				System.out.println("회원 아이디가 없어요. 회원 가입 ㄱ");
				break;
			case 1:
				System.out.println("패스워드가 일치하지 않아요. 비밀번호 찾기 ㄱ");
				break;
			case 2:
				System.out.println("회원님");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		IsMemberProcCall mapc = new IsMemberProcCall();
		mapc.execute();
	}

}
