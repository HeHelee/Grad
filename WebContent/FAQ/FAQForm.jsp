<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "ch12.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!-- 질문 게시판 -->
<%
String id = (String) session.getAttribute("id");
FDBBean fbs = FDBBean.getInstance();
List<FDataBean> MyList = null;
MyList = fbs.getNotice();
if (id == null) {
	response.sendRedirect("../Login/sessionLoginForm.jsp");
	return;
}

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질문 게시판</title>
<link rel ="stylesheet" href = "../Login/Member.css" type = "text/css">
</head>

<body>
<div class="big">
<form method = "POST" action = "form">
<center>
<hr>
<h1>질문게시판
<input type = "submit" class = "bdbtn" value = "글쓰기" onclick="javascript: form.action = 'FAQPro.jsp';">
</h1>
<hr>
<br>
<table border="1">
<tr>
<td id="no"> <h3>번호</h3> </td>
<td id="title"> <h3>제목</h3> </td>
<td id="name"><h3>이름</h3> </td>
<td id="date"><h3>날짜</h3> </td>

</tr>
<%
System.out.println(MyList);
if(MyList.size()>0) {
	for(int i = 0; i < MyList.size(); i++) {
		//한 행씩 출력
		FDataBean fb = MyList.get(i);
	%>
	<tr>
	<td><%=fb.getNumber() %></td>
	<td><a href="FView.jsp?number=<%=fb.getNumber()%>"><%=fb.getTitle() %></a></td>
	<td><%=fb.getName() %></td>
	<td><%=fb.getDate() %></td>
  
	</tr>
	<% 
	}
} else {//list.size() == 0
		%>
		<tr>
		<td colspan = "5"> 글이 없습니다... </td>
		</tr>
		<% }





%>
</table>
<br>
<input type = "button" class="bdbtn" value = "메인" onclick = "location.href='../Login/sessionMain.jsp'">
</center>
</form>
</div>
</body>