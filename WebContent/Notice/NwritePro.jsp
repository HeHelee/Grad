<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>   
<%@ page import = "ch12.*" %> 
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>공지사항</title>
<link rel ="stylesheet" href = "../Login/Member.css" type = "text/css">
</head>
<body>
<center>
<hr>
<h1>공지사항 필독!!</h1>

<hr>
<table>
<tr>
<td><label for="title">제목 </label></td>
<td><input type="text" name="title" id="title" required></td>
</tr>
<tr>
<td><label for="name">이름 </label></td>
<td><input type="text" name="name" id="name" required></td>
</tr>
<tr>
<td><label for="passwd">비밀번호 </label></td>
<td><input type="text" name="passwd" id="passwd" required></td>
</tr>
<tr>
</table>
<textarea name="content" id="content" cols="42.9" rows="10" placeholder='내용을 입력하세요.' 
required style=overflow-x:hidden; overflow-y:scroll; resize: none;﻿"></textarea><br>
<div id="button" style="padding-center:100px; padding-top:10px;">
<input class="bdbtn" type="submit" value="등록" onclick="location.href='NSuccess.jsp'">
<input class="bdbtn" type="button" value="목록" onclick="location.href='NoticeForm.jsp'">
</div>
</center>
<body>
</html>