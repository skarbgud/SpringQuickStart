package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{
	
	@RequestMapping(value = "/insertBoard.do")
	public void insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		
		// 1. 사용자 입력 정보 추출			
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		/*
		  	서블릿 객체의 service() 메소드가 호출되는 과정
		  	1. 서블릿 컨테이너는 클라이언트의 HTTP 요청이 서버에 전달되는 순간
		  	2. HttpServletRequest 객체를 생성하고 HTTP 프로토콜에 설정된 모든 정보를 추출하여 HttpServletRequest 객체에 저장한다.
		  	3. 그리고 이 HttpServletRequest 객체를 service() 메소드를 호출할 때 인자로 전달해준다.
		 */
	}
}
