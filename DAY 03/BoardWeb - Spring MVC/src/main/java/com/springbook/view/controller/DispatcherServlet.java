package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	/*
	 	MVC 프레임워크의 구조
	 	클래스 			 		기능
	 	DispatcherServlet 	-  유일한 서블릿 클래스로서 모든 클라이언트의 요청을 가장 먼저 처리하는 Front Controller
	 	HandlerMapping		-  클라이언트의 요청을 처리할 Controller 매핑
	 	Controller 			-  실직적인 클라이언트의 요청 처리
	 	ViewResolver		-  Controller가 리턴한 View 이름으로 실행될 JSP 경로 완성
	 */
	
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver  viewResolver;
    
    public void init() throws ServletException{
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다.
		String viewName = ctrl.hadleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
	}
	
	/*
		기능의 처리 순서
		1. 클라이언트가 로그인 버튼을 클릭하여 "/login.do" 요청을 전송하면 DispatcherServlet이 요청을 받는다.
		2. DispatcherServlet은 HandlerMapping 객체를 통해 로그인 요청을 처리할 LoginController를 검색하고,
		3. 검색된 LoginController의 handleRequest() 메소드를 호출하면 로그인 로직이 처리된다.
		4. 로그인 처리 후에 이동할 화면 정보가 리턴되면
		5. DispatcherServlet은 ViewResolver를 통해 접두사와 접미사가 붙은 JSP 파일의 이름과 경로를 리턴받는다.
		6. 그리고 최종적으로 JSP를 실행하고 실행 결과가 브라우저에 응답한다.
		
	 */
}