package kr.co.stephen.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.stephen.board.model.BoardDAO;
import kr.co.stephen.board.model.BoardVO;

public class SearchServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<BoardVO> articles = BoardDAO.GetInstance().searchList(request.getParameter("search"));
		
		
		request.setAttribute("boardList", articles);
	}

}
