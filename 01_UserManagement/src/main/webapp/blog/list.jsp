<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/2/2021
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Blog</title>
</head>
<body>
<c:forEach items="${listBlog}" var="blog">
    <h2>${blog.title}</h2>
    <h4>${blog.content}</h4>
    <hr>
</c:forEach>
</body>
</html>
