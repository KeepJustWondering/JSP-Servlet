<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
	</head>
	<body>
		<form action="ST" method="post">
			이름 : <input type="text" name="s_name"></input><br>
			나이 : <input type="text" name="s_age"></input><br>
			전공 : <input type="text" name="s_major"></input><br>
			취미 : 
			<input type="checkbox" name="s_hobby" value="노래">노래
			<input type="checkbox" name="s_hobby" value="기타">기타
			<input type="checkbox" name="s_hobby" value="게임">게임
			<input type="checkbox" name="s_hobby" value="독서">독서
			<input type="checkbox" name="s_hobby" value="음악">음악
			<input type="checkbox" name="s_hobby" value="피아노">피아노
			<input type="checkbox" name="s_hobby" value="낚시">낚시
			<input type="checkbox" name="s_hobby" value="춤">춤<br>
			
			<input type="submit" value="제출">
		</form>
	</body>
</html>