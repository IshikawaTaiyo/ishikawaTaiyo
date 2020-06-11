<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <p>
    検索したいユーザーネーム情報を入力してください<br>※曖昧検索
  </p>

  <p class="error">${fn:escapeXml(notUser)}</p>

  <form action="SelectServlet2" method="post">
    <fieldset>
      <div>
        <label>名前</label>
        <input type="text" name="userName">
      </div>
    </fieldset>
    <button class="btn-stitch"type="submit">検索</button>
  </form>
  <div>
    <a href="index.jsp"class="btn-stitch">TOP画面に戻る</a>
  </div>
</body>
</html>
