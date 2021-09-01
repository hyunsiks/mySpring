<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3># CRUD 연습</h3>

<ul>
	<li>java1 DB계정에 적당한 주제로 테이블을 생성(컬럼3개이상)</li>
	<li>해당 테이블에 대한 CRUD를 Mybatis로 구현</li>
	<li>각각의 페이지로 가서 작업되도록</li>
</ul>
<button type="button" onclick="location.href='./update'">추가하러가기</button><br>
<button type="button" onclick="location.href='./select'">조회하러가기</button><br>
<button type="button" onclick="location.href='./change'">수정하러가기</button><br>
<button type="button" onclick="location.href='./delete'">삭제하러가기</button><br>

<a href="./add">추가하러가기</a>
<a href="">조회하러가기</a>
<a href="">수정하러가기</a>
<a href="">삭제하러가기</a>

</body>
</html>