<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 27.03.2022
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

<div class="d-grid gap-2 col-6 mx-auto m-3">

    <button class="btn btn-primary" type="button" onClick='location.href="/registration"'>Registration</button>
    <button class="btn btn-secondary" type="button" onClick='location.href="/authorization"'>Authorization</button>


</div>

</body>
</html>
