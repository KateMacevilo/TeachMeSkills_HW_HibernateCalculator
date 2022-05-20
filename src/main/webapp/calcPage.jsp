<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 28.03.2022
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

<div class="container-fluid d-flex justify-content-md-center">
    <div class="row col-6 mt-3 mx-3">
        <div class="col-10">
            <h1>Calculation</h1>
            <form action="/calculate" method="get">

                <div class="mb-3">
                    <label for="num1" class="form-label">Number 1</label>
                    <input type="number" class="form-control" name="num1" id="num1">
                </div>
                <div class="mb-3">
                    <label for="num2" class="form-label">Number 2</label>
                    <input type="number" class="form-control" name="num2" id="num2">
                </div>

                <select class="form-select mb-3" aria-label="Default select example" name="operand">
                    <option selected>Open this select menu</option>
                    <option value="sum">Sum</option>
                    <option value="diff">Diff</option>
                    <option value="mult">Mult</option>
                    <option value="div">Div</option>
                </select>

                <button type="submit" class="btn btn-primary">Submit</button>

                <div class="mt-3">
                    <p class="h4"> Result: <%= request.getAttribute("result") %></p>
                </div>


            </form>
        </div>
    </div>
</div>

<div class="container-fluid d-flex justify-content-md-center border">
    <div class="row col-6">
        <div class="col mt-3">
            <h3> History: </h3>
            <c:forEach var="operation" items="${historyList}">
                <ul class="list-group list-group-flush" style="margin-top: 15px">
                    <input class="list-group-item">
                    <p class="text-left"> Operation: ${operation.toString()}</p>
                </ul>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
