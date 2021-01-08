<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int on = Integer.parseInt(request.getParameter("no"));	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook2/pbc" method="post">
			비밀번호 <input type="text" name="password">
			<button type="submit">확인</button><br>
			<input type="hidden" name="no" value=<%=on%>>
			<input type="hidden" name="action"value="delete1"><br>
			<a href="/guestbook2/gcr?action=list">메인으로 돌아가기</a>
</body>
</html>