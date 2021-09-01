<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 추가하는 페이지</title>
</head>
<body>

<form action="./add" method="POST">
	이름<input name="name" /><br>
	가격<input name="price" /><br>
	카테고리<input name="category" /><br>
	<input type="submit" value="추가" />
</form>

</body>
</html>