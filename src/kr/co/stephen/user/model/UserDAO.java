package kr.co.stephen.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import sun.security.jca.GetInstance;

public class UserDAO implements IUserDAO {

	DataSource ds;
	
	//싱글톤 디자인 패턴
	
	//1.스스로의 객체 생성
	private static UserDAO dao = new UserDAO();
	
	//2.외부에서 객체생성 할 수 없도록 생성자에 private 제한 붙이기.
	private UserDAO() {
		//커넥션 풀 구하기
		try {
			Context ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
			
	}
	//3. 외부에서 객체 요구시 공개된 메서드를 통해 가지고 있던 DAO객체의 주소값 반환.
	public static UserDAO GetInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	
	
	
	
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean confirmId(String id) {
		boolean flag = false;
		
		String sql = "SELECT * FROM user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) flag=true;//아이디가 존재함
			else flag=false;//아이디가 존재하지 않음
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return flag;
	}

	@Override
	public boolean insertMember(UserVO vo) {
		boolean flag = false;
		
		String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			
			if(pstmt.executeUpdate() == 1) flag = true;
			else flag=false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public int userCheck(String id, String pw) {
		String sql = "SELECT * FROM user WHERE user_id=?";
		int check = 0;
		
		
		
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) { //아이디가 존재함.
				String dbPw = rs.getString("user_pw"); //DB에 저장된 비밀번호를 얻음
				
				if(dbPw.equals(pw)) {
					check = 1;
				}else {//비밀번호가 다를 경우.
					check=0;
				}
			}else {//아이디가 존재하지 않음.
				check = -1;
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public UserVO getMemberInfo(String id) {
		
		UserVO vo = null;
		String sql = "SELECT * FROM user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();	
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("user_id"));
				vo.setPw(rs.getString("user_pw"));
				vo.setName(rs.getString("user_name"));
				vo.setEmail(rs.getString("user_email"));
				vo.setAddress(rs.getString("user_address"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean changePassword(String id, String pw) {
		boolean flag = false;
		
		String sql = "UPDATE user SET user_pw=? WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			if(pstmt.executeUpdate() == 1) flag=true;
			else flag=false;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateUser(UserVO vo) {
		boolean flag = false;
		
		String sql = "UPDATE user SET user_name=?, user_email=?, user_address=? WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			
			if(pstmt.executeUpdate() == 1) flag=true;
			else flag=false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean deleteUser(String id) {
		boolean flag = false;
		
		String sql = "DELETE FROM user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			
			if(pstmt.executeUpdate() == 1) flag=true;
			else flag = false;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}

}









