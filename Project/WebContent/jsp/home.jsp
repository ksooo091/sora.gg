<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>HOME</h1>

	<table>
		<tr>
			<td>로테이션</td>
			<td>탑</td>
			<td>정글</td>
			<td>미드</td>
			<td>원딜</td>
			<td>서포터</td>
		</tr>

	</table>

	<h2>금주 로테이션 목록</h2>

	<table>
		<tr>
			<c:forEach var="c" items="${champName}">

				<td><a href="champDetailC?no=${c.no }"><img id="icon"
						src="https://ddragon.leagueoflegends.com/cdn/11.4.1/img/champion/${c.getName()}.png"></a></td>


			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="c" items="${champNameKr}">

				<td align="center">${c.getName()}</td>

			</c:forEach>
		</tr>
	</table>



</body>
</html>