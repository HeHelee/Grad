<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "java.sql.*" %>   
<%@ page import = "ch12.*" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!-- 공지게시판 입력 부분입니다. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel ="stylesheet" href = "../Login/Member.css" type = "text/css">
<title>Insert title here</title>
</head>
<body>
<div class="big">
<center>
<hr>
<%
String id = (String)session.getAttribute("id"); //객체값 
if(id == null || id.equals("")) 
	{
		response.sendRedirect("sessionLoginForm.jsp");
		return;
	} 
 else {}
%>

<%
//전달된 피라미터 값 저장
int number = Integer.parseInt(request.getParameter("number"));
//객체 생성
FDBBean fbs = FDBBean.getInstance();
//기존의 글 정보를 가져오기
FDataBean fb = fbs.getNbs(number);
%>
<h1><%=fb.getTitle() %></h1>
<hr>
<textarea name="content" cols="42.9" rows="10"> <%=fb.getContent() %></textarea>
<br><br>
<input class="bdbtn" class = "bdbtn" type="button" value="목록" onclick="location.href='FAQForm.jsp'">
</center>

</div>
</body>
</html>