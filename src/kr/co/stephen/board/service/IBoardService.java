package kr.co.stephen.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {
	
	//추상메서드
	void execute(HttpServletRequest request, HttpServletResponse response); 
	
}
