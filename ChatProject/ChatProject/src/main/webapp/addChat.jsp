<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddChatController" method="post">
		<table width=500 align=center border=1>
			<tr>
				<td colspan=2 align=center>新增留言
			<tr>
				<td width=100>留言者
				<td><input type="text" name="name">
			<tr>
				<td width=100>主題
				<td><input type="text" name="subject">
			<tr>
				<td width=100>內容
				<td><input type="text" name="content">
			<tr>
				<td colspan=2><input type="submit" value="ok">
</table>
	
	</form>
</body>
</html>