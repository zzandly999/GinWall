<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/4/1
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>搜索详情</title>
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
        #s {
            font-family: 微软雅黑;
            font-size: large;
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="s">
                以下是搜索的结果：
            </div>
        </div>
    </div>
    <p></p>
    <!--    动态展示发布的帖子-->
    <div class="row" id="comments_body">
        <c:forEach items="${sessionScope.searchDetails.listIterator()}" var="searchDetails" begin="0" end="${sessionScope.searchDetails.size()}">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <div class="media-body">
                        <img src="${searchDetails.userRegisters.avatar}" width="30px" height="30px">
                        <font color="#191970" size="3px">
                                ${searchDetails.userRegisters.nickName}
                        </font>
                        <p>发表于${searchDetails.updateTime}</p>
                    </div>
                        <%--                    <c:if test="${whoComment.dynamicInformations.cover} == '/images/images'">--%>
                    <a href="${searchDetails.cover}">
                        <img src="${searchDetails.cover}" alt="文章作者没有上传任何图片" style="width: 658px; height: 110px; border: 0px;">
                    </a>
                        <%--                    </c:if>--%>
                    <div class="caption">
                        <h3>${searchDetails.type}</h3>
                        <p>${searchDetails.comment}</p>
                        <p><a class="btn btn-primary" role="button" onclick="showSearchDetails(${searchDetails.id})">详情</a> <a
                                href="" class="btn btn-default" role="button" onclick="toShare()">分享</a>
                            <button onclick="searchLike(${searchDetails.id})">👍</button>
                            <span>${searchDetails.like}</span>
                            <button>👎</button>
                            <span>${searchDetails.unLike}</span>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<script type="text/javascript">

    function showSearchDetails(id) {
        $.post(
            "http://localhost:8080/toShowDetails",
            "id="+id,
            function (result) {
                location.href="show.jsp";
            }
        )
    }
    function searchLike(id) {
        $.post(
            "http://localhost:8080/like",
            "id="+id,
            function (result) {
                location.reload();
            }
        )
    }

</script>

</body>
</html>
