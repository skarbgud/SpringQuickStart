package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
		/*
		  	서블릿 객체의 service() 메소드가 호출되는 과정
		  	1. 서블릿 컨테이너는 클라이언트의 HTTP 요청이 서버에 전달되는 순간
		  	2. HttpServletRequest 객체를 생성하고 HTTP 프로토콜에 설정된 모든 정보를 추출하여 HttpServletRequest 객체에 저장한다.
		  	3. 그리고 이 HttpServletRequest 객체를 service() 메소드를 호출할 때 인자로 전달해준다.
		 */
	}
}
