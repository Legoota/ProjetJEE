<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <title>Choix parcours</title>
</head>
<body>
    <h1>Choisissez désormais votre aventure</h1>
    <c:forEach items="${sessionScope.pds.getAllNomFromParcours()}" var="item">
        <a href="/Projet-1.0/parcours/aventure/${item}">${item}</a><br>
    </c:forEach>
</body>
</html>
