<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>${sessionScope.uds.getParcoursFromUser(cookie['pseudo'].value).getChoixCourant().getNom()}</title>
</head>
<body class="${sessionScope.uds.getParcoursFromUser(cookie['pseudo'].value).getChoixCourant().getTypeEnv()}">
    <h2 class="center-align pixel">${sessionScope.uds.getParcoursFromUser(cookie['pseudo'].value).getChoixCourant().getDescription()}</h2>
    <div class="container">
        <div class="row">
            <div class="col s3">
                <div class="card">
                    <div class="card-image">
                        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom(sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom())}" width="250" height="250"/>
                        <span class="card-title black-text pixel">${sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom()}</span>
                    </div>
                    <div class="card-content">
                        <p>PV : ${sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getPV()}</p>
                    </div>
                    <div class="card-action">
                        <c:forEach items="${sessionScope.plds.getAttaquesByNom(sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom())}" var="item">
                            <a class="pixel" href="#">${item.getNom()} (${item.getDegats()})</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col s6"></div>

            <div class="col s3">
                <div class="card">
                    <div class="card-image">
                        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom(sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom())}" width="250" height="250"/>
                        <span class="card-title black-text pixel">${sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom()}</span>
                    </div>
                    <div class="card-content">
                        <p>PV : ${sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getPV()}</p>
                    </div>
                    <div class="card-action">
                        <c:forEach items="${sessionScope.plds.getAttaquesByNom(sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom())}" var="item">
                            <a class="pixel" href="#">${item.getNom()} (${item.getDegats()})</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
