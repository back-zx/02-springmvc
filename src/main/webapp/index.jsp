<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<br>
<a href="some">请求</a>

<%--
    ${pageContext.request.contextPath}动态地获取项目路径
--%>
<form action="${pageContext.request.contextPath}/some/fourth" method="post">
    <input type="submit" value="请求">
</form>
</body>
</html>
