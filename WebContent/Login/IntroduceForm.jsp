<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- ����Ʈ �Ұ� ������ -->
<%/*
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("sessionLoginForm.jsp");
	return;}
*/
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����Ʈ �Ұ�</title>
<link rel ="stylesheet" href = "Member.css" type = "text/css">
</head>

<body>
<div class="big">
<form method = "POST" action = "form">

<center>
<hr>
<h1>����Ʈ �Ұ� </h1>
<hr>


<br>
�Ȥ��礷���̫ѤĿ褱������ <br>
 90�� ��������l �� �� �ߤ����ä����� <br>
��r ��վ� 2n���ε�  <br>
�ճ� ���ۤ�r �ë�LI ���� �����ȱ� ��̫�l���ȷ�~-_-^  <br>
 <br>
��� PC��� ����... <br>
�̡�l���� ü�誡���� �� �ִ� ��r��lƮ��F(��l���� ���߫�lϢ��...=_=) <br>
ä�á�l��r ���� �˻�Ϣ�� ��r�ɩ̫� <br>
���ȿ�ε������ �޵� �� �嫺l..  <br>
 <br>
����LI ���������� <br>
�帧 �������..S2 <br>
(P.S R=V�� ��� a+�ޤ�r) <br>
<hr>
<input type = "button" class="bdbtn" value = "����" onclick = "location.href='../Login/sessionMain.jsp'">
</center>
</form>
</body>
</html>