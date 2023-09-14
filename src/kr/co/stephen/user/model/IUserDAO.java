package kr.co.stephen.user.model;

public interface IUserDAO {
	
	//중복 아이디 여부 검증 메서드
	public boolean confirmId(String id);
	
	//회원가입을 처리하는 메서드
	public boolean insertMember(UserVO vo);
	
	//로그인 유효성을 검증하는 메서드.
	public int userCheck(String id, String pw);
	
	//모든  회원 정보를 얻어오는 메서드
	public UserVO getMemberInfo(String id);
	
	//비밀번호 변경 메서드
	public boolean changePassword(String id, String pw);
	
	//회원정보를 수정하는 메서드
	public boolean updateUser(UserVO vo);
	
	//회원 탈퇴 메소드
	public boolean deleteUser(String id);
	
	
	
	
	
	
	
}
