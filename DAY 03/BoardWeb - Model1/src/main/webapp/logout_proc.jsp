<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
	session.invalidate();
	
	// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
	response.sendRedirect("login.jsp");
	
 %>