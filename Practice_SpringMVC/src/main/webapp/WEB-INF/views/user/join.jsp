<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h3># 연습문제</h3>
<ul>
	<li>다양한 회원정보를 입력받는다(생일포함)</li>
	<li>POST방식으로 회원정보와 함께 요청하면 서버의 
		/data/user에 파일 형태로 저장한다</li>
	<li>파일 이름은 중복이 생기지 않도록 조심해야한다</li>
	<li>누락된 정보가 있는경우 회원가입 실패 페이지로 넘어가야 한다</li>
	<li>회원가입에 성공하면 회원가입 성공페이지를 5초간 보여준 후 다시 홈으로 이동한다</li>
</ul>


<form action="/practice/sign/file" method="POST">
	<input type="text" name="name" value="이름"/>
	<input type="text" name="phoneNumber" value="전화번호"/>
	<input type="text" name="birthday" value="생년월일"/>
	<input type="submit" value="가입"/>
</form>

<h5>선생님 풀이 폼</h5>
<form action="/practice/hello/join" method="POST">
	ID : <input type="text" name="id" /><br>
	PW : <input type="password" name="password"/><br>
	이름 : <input type="text" name="name"/><br>
	나이 : <input type="number" name="age"/><br>
	생일 : <input type="date" name="birthday"/><br>
	<input type="submit" value="회원가입"/>
</form>

</body>
</html>