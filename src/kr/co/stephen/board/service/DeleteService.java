package kr.co.stephen.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.stephen.board.model.BoardDAO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDAO.GetInstance().deleteBoard(request.getParameter("bId"));
		

	}

}
