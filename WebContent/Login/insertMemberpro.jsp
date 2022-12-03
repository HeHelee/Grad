<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>   
<%@ page import = "ch12.*" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!-- 회원가입 처리 게시판 -->
<!-- 빈추가 -->
<jsp:useBean id="mb" class="ch12.LogonDataBean"> 
    <jsp:setProperty name = "mb" property = "*"/> 
</jsp:useBean>
<%
   mb.setReg_date(new Timestamp(System.currentTimeMillis())); //member라는 객체에 폼에 내용이 없어서 오늘 날짜 임의적으로 집어넣어줌.
   LogonDBBean logon = LogonDBBean.getInstance(); //연결하는 거 인서트 하는거 다 들어있음. //인스턴스와 동급 logon
   logon.insertMember(mb);   //엄청 중요함 //set으로 저장하고 있는 member 넘겨줌.
   //DB에 연동시켜줄 수 있는 코드임.
%>
<script type="text/javascript">
	/*const form = document.signUpform;
	
	
	function emailAutentication(){
		if(!emailVlCheck()){
			return false;
		}
		
		var url ="confirmEmail.four?email="+document.signUpForm.email.value; //four: @webServlet("*.four") 서블렛태그
		open(url, "confirm", "toolbar=no,location-no,menubar=no,resirable=no, width=300,height=200");
		open(url,"confirm",condition);
	}
	
	function emailValCheck(){
		var emailPattern = /^[0-9a-zA-z]([-_.,])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[a-zA-Z]{2,3}$/i;
		var email = form.email.value;
		if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")){
			return false;
		}
		return true;
	}
	function check(pattern,taget,message){
		if(pattern.test(taget)){
			return true;
		}
		alert(message);
		taget.focus();
		return false;
	}*/
	alert("회원이 되신 걸 축하합니다.");
	location.href = "sessionLoginForm.jsp";
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 자바빈을 통해서 값 넘겨주고 받아오는 작업이 필요 -->
</body>
</html>