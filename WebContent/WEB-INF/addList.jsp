<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="com.javaex.dao.GuestDao"%>
<%@ page import="com.javaex.vo.GuestVo"%>
<%

	List<GuestVo> gList= (List<GuestVo>)request.getAttribute("gList");
	//컨트롤 에서 포워드한 plist를 꺼내라
	System.out.println("-----list.jsp------");
	System.out.println(gList);
	
	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/guestbook2/gcr" method="get">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
					<td>비밀번호</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td colspan="4"> <textarea name="content"> </textarea> </td>
				</tr>
				<tr>
					<td colspan="4"> <button type="submit" >확인</button></td>
				</tr>
				1:<input type="text" name="action"value="add"><br>
			</table>
		</form>
		<br>
		<% for(int i=0; i<gList.size();i++) { %>
			<table border="1">
				<tr>
					<td><%= gList.get(i).getNo() %></td>
					<td><%= gList.get(i).getName() %></td>
					<td><%= gList.get(i).getRegdate() %></td>
					<td><a href="/guestbook2/gcr?action=delete&no=<%=gList.get(i).getNo()%>">삭제</a></td>
				</tr>
				<tr>
					<td colspan="4"> <%= gList.get(i).getContent() %> </td>
				</tr>
			</table>
			<br>
		<%} %>
		
		
</body>
</html>