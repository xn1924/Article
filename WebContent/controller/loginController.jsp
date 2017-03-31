<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(username);
	System.out.println(password);
%>