<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>Choix du parcours</title>
</head>
<body class="background">
    <h3 class="center-align pixel">Choisissez desormais votre aventure</h3>
    <div class="row">
        <div class="col s12 m7">
            <c:forEach items="${sessionScope.pds.getAllNomFromParcours()}" var="item">
                <div class="card" style="width:30em;">
                    <div class="card-image">
                        <img src="${pageContext.request.contextPath}/img/${item}.png">
                        <span class="card-title black-text pixel">${item}</span>
                    </div>
                    <div class="card-content">
                        <p>${sessionScope.pds.getDescriptionForParcours(item)}</p>
                    </div>
                    <div class="card-action">
                        <a class="pixel" href="/Projet-1.0/parcours/aventure/${item}">${item}</a><br>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

</body>
</html>
