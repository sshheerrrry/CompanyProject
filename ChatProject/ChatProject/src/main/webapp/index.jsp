<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Chat"
    import="java.util.List"
    import="dao.impl.ChatDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<Chat> l=new ChatDaoImpl().selectAll();
Integer n=l.size();
Chat[] chat=l.toArray(new Chat[n]);

request.setAttribute("N", n);
request.setAttribute("CHAT", chat);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=500 align=center>
	<tr align=center>
		<td><a href="addChat.jsp"><h3>我要留言</h3></a>
	<tr>
		<td><hr>
</table>
<br>
<c:forEach var="i" begin="0" end="${N-1 }">
<table width=500 align=center border=1>
	<tr>
		<td colspan=2 align=center>第${CHAT[i].getId() }筆
	<tr>
		<td width=100>留言者
		<td>${CHAT[i].getName() }
	<tr>
		<td width=100>主題
		<td>${CHAT[i].getSubject() }
	<tr>
		<td width=100>內容
		<td>${CHAT[i].getContent() }
</table>
<br>
</c:forEach>
</body>
</html>