<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.javaex.vo.GuestVo"%>
    <%
    int no = Integer.parseInt(request.getParameter("no"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>비밀번호가 틀렸습니다.</p>

	<br>

	<a href="/guestbook2/pbc?action=deleteForm&no=<%=no%>">뒤로</a>
</body>
</html>