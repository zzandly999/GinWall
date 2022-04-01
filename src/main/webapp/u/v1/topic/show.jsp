<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/4/1
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript"
            src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        #showA {
            font-family: 微软雅黑;
            color: cornflowerblue;
        }
        #showU {
            font-family: 微软雅黑;
            color: blue;
        }
        #showC {
            font-family: 微软雅黑;
            color: gray;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a href="${sessionScope.showDetails.userRegisters.avatar}">
                    <img src="${sessionScope.showDetails.userRegisters.avatar}" width="45px" height="45px">
                </a>
                <span id="showA">&nbsp;&nbsp;${sessionScope.showDetails.userRegisters.nickName}</span>
                <div id="showU">
                    ${sessionScope.showDetails.updateTime}
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="${sessionScope.showDetails.cover}">
                    <img src="${sessionScope.showDetails.cover}">
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <span id="showC">
                    ${sessionScope.showDetails.comment}
                </span>
            </div>
        </div>
    </div>

</body>
</html>
