<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to the login page!</h1>
		<form method="post">
			<pre>${errorMessage}</pre>
			<!-- <pre> tag 能夠保留使用者編輯的內容文本格式 -->
			Name: <input type="text" name="name"> Password: <input
				type="password" name="password"> <input type="submit">
		</form>
	</div>
</body>
</html>