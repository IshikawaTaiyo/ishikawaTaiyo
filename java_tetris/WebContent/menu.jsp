<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <b class=sizu>${fn:escapeXml(name)}さん</b>

  <b class =sizu>総プレイ回数:${fn:escapeXml(plays)}回</b>
   <br>

	<b class="sizu">最高スコア：${fn:escapeXml(scoreMax)}点</b>
	<br>

  	<b class="sizu">前回のスコア：${fn:escapeXml(scoreLast)}点</b>
  	<br>
  <p>
    <a href="tetris.jsp"class="btn-stitch">ゲームを開始</a>
  </p>

  <p>
  	<a href="SelectServlet"class="btn-stitch">ランキング</a>
  </p>
  <!-- 発展課題
    <p>
      <a href="update.jsp">更新</a>
    </p>
    <p>
      <a href="delete.jsp">削除</a>
    </p>
-->
	<form action="SelectServlet3" method="post">
    <button class="btn-stitch"type="submit">PASSWORDの変更</button>
  </form>
  <br>
  <form action="LogoutServlet" method="post">
    <button class="btn-stitch"type="submit">ログアウト</button>
  </form>
</body>
</html>
