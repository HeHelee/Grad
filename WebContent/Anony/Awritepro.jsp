<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>   
<%@ page import = "ch12.*" %> 
<%request.setCharacterEncoding("UTF-8"); %>
<!-- 익명게시판 입력 부분입니다. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>익명게시글 작성하기</title>
<link rel ="stylesheet" href = "../Login/Member.css" type = "text/css">
</head>
<body>
<div class="big">
<center>
<hr>
<h1>글 작성하기</h1>
<hr>
<!-- 글쓰기를 처리하는 부분 : Asccess.jsp -->
<form method="POST" action = "Asuccess.jsp"> 
<table>
<tr>
<td><label for="title">제목 </label></td>
<td><input type="text" name="title" id="title" ></td>
</tr>
<tr>
<td><label for="passwd">비밀번호 </label></td>
<td><input type="text" name="passwd" id="passwd" ></td>
</tr>
<tr>
</table>
<textarea name="content" id="content" cols="42.9" rows="10" placeholder='내용을 입력하세요.' 
required style=overflow-x:hidden; overflow-y:scroll; resize: none;﻿"></textarea><br>
<div id="button" style="padding-center:100px; padding-top:10px;">
<input class="bdbtn" type="submit" value="등록" onclick="location.href='Asuccess.jsp'">
<input class="bdbtn" type="button" value="목록" onclick="location.href='AnonymouseForm.jsp'">
</div>

</center>
</form>
</body>
</html>