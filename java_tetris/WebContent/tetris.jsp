<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>テトリス風ゲーム</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/tetris.css">
    <link rel="stylesheet" type="text/css" href="css/b.css">
    <script type="text/javascript" src="js/tetris.js"></script>
  </head>
  <body>
    <h1>テトリス</h1>
    <p>プレイヤー：${fn:escapeXml(name)}さん</p>
    <div class="wrapper-container">
        <span class="tetris-container">
            <canvas id="stage" width="250px" height="500px" style="background-color:black;">
            </canvas>
            <span class="tetris-panel-container">
              <p>Next:</p>
                <canvas id="next" width="150px" height="150px" style="background-color:black;">
                </canvas>
              <p>スコア:<span id="lines">0</span></p>
              <p><span id="message"></span></p>
              <div class="tetris-panel-container-padding"></div>
              <table class="tetris-button-panel">
                <tr>
                  <td></td>
                  <td id="tetris-rotate-button" class="tetris-button">↻</td>
                  <td></td>
                </tr>
                <tr>
                  <td id="tetris-move-left-button"class="tetris-button">←</td>
                  <td id="tetris-fall-button"class="tetris-button">↓</td>
                  <td id="tetris-move-right-button"class="tetris-button">→</td>
                </tr>
              </table>
            </span>
        </span>
    </div>
    <script>
      var tetris = new Tetris();
      tetris.startGame();
    </script>
  </body>
</html>