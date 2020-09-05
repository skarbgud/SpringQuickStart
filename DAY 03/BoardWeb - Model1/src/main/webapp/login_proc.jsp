<%@page import="com.springbook.biz.user.impl.UserDAO" %>
<%@page import="com.springbook.biz.user.UserVO" %>
<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. ����� �Է� ���� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB ���� ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. ȭ�� �׺���̼�
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	// ������(Forward)�� �����̷�Ʈ(Redirect) ����
	/*
		- ������
		������ ����� RequestDispatcher�� �̿��Ͽ� �������� ����� JSP ȭ������ 
		�Ѱܼ�, ������� ȭ���� Ŭ���̾�Ʈ���� ���۵Ǵ� ����̴�. �� ����� �� ���� ��û��
		�������� ó���ǹǷ� ���� �ӵ��� ��������, Ŭ���̾�Ʈ ���������� URL�� �ٲ��� �ʾ�
		������ ��𿡼� ���Դ��� Ȯ���� �� ����.
		- �����̷�Ʈ
		�����̷�Ʈ�� ��û�� JSP���� �ϴ� �������� ���� �޽����� ���´ٰ� �ٽ� ������ 
		���û�ϴ� ����̴�. ��, ������ ��İ� �ٸ��� �ϴ� ������ ��������
		�� ����, ���û�ϴ� ����̴�. ���� ������ ���� ���Ϸ� �������� URL�� ����
		������, �� ���� ��û�� �������� ó���ǹǷ� ���� �ӵ��� ������ ��ĺ��� ������.
	*/
%>