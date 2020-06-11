<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
<link href="css/c.css" rel="stylesheet">
</head>
<body>
  <p>現在のパスワードと新しいパスワードを入力してください</p>
  <p class="error">${fn:escapeXml(notPassword)}</p>

  <form action="ChangePasswordServlet" method="post">
    <fieldset>
      <div>
      現在のパスワード
		 <label></label>
        <input type="password" name="pass">
        <span class="error"></span>
      </div>
      <div>
      新しいパスワード
        <label></label>
        <input type="password" name="newPass">
        <span class="error"></span>
      </div>
    </fieldset>
    <button class="btn-stitch"type="submit">変更</button>
  </form>
  <div>
    <a href="menu.jsp"class="btn-stitch">メニューに戻る</a>
  </div>
</body>
</html>
