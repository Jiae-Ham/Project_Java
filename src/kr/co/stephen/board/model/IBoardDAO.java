package kr.co.stephen.board.model;

import java.util.List;

public interface IBoardDAO {
	
	//DB에 작성글을 등록하는 메서드
	public void regist(String writer, String title, String content);
	
	//모든 게시글 정보를 가져오는 메서드 (글 목록 리스트)
	public List<BoardVO> listBoard();
	
	
	//상세글 보기 메서드
	public BoardVO contentBoard(String bId);
	
	//조회수를 증가시키는 메서드.
	public void upHit(String bId);
	
	//게시글 수정 메서드
	public void updateBoard(String bId, String title, String content);
	
	//게시글 삳제
	public void deleteBoard(String bId);
	
	//게시글 검색 메서드.
	public List<BoardVO> searchList(String search);
	
	

}
