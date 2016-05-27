<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: nkurtushin
  Date: 18.05.16
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-toggle.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-timepicker.min.css"/>
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-timepicker.min.js"></script>
    <title></title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="menu"/>
<section>
<tiles:insertAttribute name="body"/>
</section>
<section>
<tiles:insertAttribute name="footer"/>
</section>
</body>
</html>
