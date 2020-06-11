<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <table>
   	<h1>ランキング</h1>
    <thead>
			<tr>
				<th>名前</th>
				<th>スコア</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${Ranking}">
				<tr>
					<td>${fn:escapeXml(user.userName)}</td>
					<td>${fn:escapeXml(user.tetrisScoreMax)}</td>
				</tr>
			</c:forEach>
		</tbody>
    </tbody>
  </table>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
