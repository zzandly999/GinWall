<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/4/1
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>主页</title>
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
        #whoImg {
            font-family: 微软雅黑;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <a href="${sessionScope.whoComment.get(0).avatar}">
                <img src="${sessionScope.whoComment.get(0).avatar}" width="45px" height="45px">
            </a>
            <span id="whoImg">&nbsp;&nbsp;${sessionScope.whoComment.get(0).nickName}</span>
        </div>
    </div>
    <p></p>
    <!--    动态展示发布的帖子-->
    <div class="row" id="comments_body">
        <c:forEach items="${sessionScope.whoComment.listIterator()}" var="whoComment" begin="0" end="${sessionScope.whoComment.size()}">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <div class="media-body">
                        <img src="${whoComment.avatar}" width="30px" height="30px">
                        <font color="#191970" size="3px">
                            ${whoComment.nickName}
                        </font>
                        <p>发表于${whoComment.dynamicInformations.updateTime}</p>
                    </div>
<%--                    <c:if test="${whoComment.dynamicInformations.cover} == '/images/images'">--%>
                        <a href="${whoComment.dynamicInformations.cover}">
                            <img src="${whoComment.dynamicInformations.cover}" alt="文章作者没有上传任何图片" style="width: 658px; height: 110px; border: 0px;">
                        </a>
<%--                    </c:if>--%>
                    <div class="caption">
                        <h3>${whoComment.dynamicInformations.type}</h3>
                        <p>${whoComment.dynamicInformations.comment}</p>
                        <p><a class="btn btn-primary" role="button" onclick="showWhoDetails(${whoComment.dynamicInformations.id})">详情</a> <a
                                href="" class="btn btn-default" role="button" onclick="toShare()">分享</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script type="text/javascript">

    function showWhoDetails(id) {
        $.post(
            "http://localhost:8080/toShowDetails",
            "id="+id,
            function (result) {
                location.href="show.jsp";
            }
        )
    }

</script>

</body>
</html>
