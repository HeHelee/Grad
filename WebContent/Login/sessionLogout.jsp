<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- �α׾ƿ� ������ -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate(); //session�� ���� ������.
%>
<!--  ��ũ��Ʈ�� �˾� â ����� (�α׾ƿ�â) -->
<script>
alert("�α׾ƿ�");
location.href("sessionMain.jsp"); 
</script>
</body>
</html>