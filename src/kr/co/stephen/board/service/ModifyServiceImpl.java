package kr.co.stephen.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.stephen.board.model.BoardDAO;
import kr.co.stephen.board.model.BoardVO;

public class ModifyServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		
		BoardVO vo = BoardDAO.GetInstance().contentBoard(bId);
		vo.setContent(vo.getContent().replace("<br>", "\r\n"));

		request.setAttribute("modify_board", vo);
		
	}

}
