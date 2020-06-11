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
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <table>
   	<h1>ランキング</h1>
   <p>全ユーザー：${fn:escapeXml(userCount)}名</p>
   <b>${fn:escapeXml(name)}さんは:${fn:escapeXml(rankingUser)}位です</b>
   <span class="error">${fn:escapeXml(rankugai)}</span>
   <h3>Top10</h3>
    <thead>
			<tr>
				<th>順位</th>
				<th>名前</th>
				<th>最高スコア</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${Ranking}">
				<tr>
					<td>${fn:escapeXml(user.ranking)}位</td>
					<td>${fn:escapeXml(user.userName)}</td>
					<td>${fn:escapeXml(user.tetrisScoreMax)}点</td>
				</tr>
			</c:forEach>
		</tbody>
    </tbody>
  </table>
  <div>
    <a href="menu.jsp"class="btn-stitch">メニューに戻る</a>
  </div>
</body>
</html>
