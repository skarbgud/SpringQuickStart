<%@page import="com.springbook.biz.user.impl.UserDAO" %>
<%@page import="com.springbook.biz.user.UserVO" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	// 1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게이션
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	// 포워드(Forward)와 리다이렉트(Redirect) 차이
	/*
		- 포워드
		포워드 방식은 RequestDispatcher를 이용하여 응답으로 사용할 JSP 화면으로 
		넘겨서, 포워드된 화면이 클라이언트에게 전송되는 방식이다. 이 방식은 한 번의 요청과
		응답으로 처리되므로 실행 속도는 빠르지만, 클라이언트 브라우저에서 URL이 바뀌지 않아
		응답이 어디에서 들어왔는지 확인할 수 없다.
		- 리다이렉트
		리다이렉트는 요청된 JSP에서 일단 브라우저로 응답 메시지를 보냈다가 다시 서버로 
		재요청하는 방식이다. 즉, 포워드 방식과 다르게 일단 응답이 브라우저로
		들어간 다음, 재요청하는 방식이다. 따라서 응답이 들어온 파일로 브라우저의 URL이 변경
		되지만, 두 번의 요청과 응답으로 처리되므로 실행 속도는 포워드 방식보다 느리다.
	*/
%>