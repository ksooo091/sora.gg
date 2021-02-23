<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td><a href="soHwanSearchC">소환사 정보</a></td>
			<td><a href="jeonjeokC">게임 전적</a></td>
			<td><a href="inGameInfoC">인게임 정보</a></td>
			<td>듀오 찾기 게시판</td>
			<td>자유 게시판</td>
		</tr>

	</table>

	<jsp:include page="${contentPage }" />

</body>
</html>