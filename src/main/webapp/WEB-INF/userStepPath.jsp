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
                        <div class="progress blue lighten-4">
                            <div class="determinate blue" style="width: ${sessionScope.uds.getCurrentPourcentagePolymonLife(sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom(),sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getPV())}%; animation: grow 2s;"></div>
                        </div>
                    </div>
                    <div class="card-action">
                        <c:choose>
                            <c:when test="${sessionScope.takeDamage != true}">
                                <c:forEach items="${sessionScope.plds.getAttaquesByNom(sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom())}" var="item">
                                    <a class="pixel" href="/Projet-1.0/parcours/step/attaque/${sessionScope.uds.numeroAttaque(cookie['pseudo'].value,item.getNom())}">${item.getNom()} (${item.getDegats()})</a>
                                </c:forEach>
                            </c:when>
                        </c:choose>
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
                        <div class="progress blue lighten-4">
                            <div class="determinate blue" style="width: ${sessionScope.uds.getCurrentPourcentagePolymonLife(sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom(),sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getPV())}%; animation: grow 2s;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col s3"></div>
            <div class="col s6">
                <c:choose>
                    <c:when test="${sessionScope.takeDamage != true}">
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">
                            <span class="card-title pixel">Que voulez-vous faire ?</span>
                            <p class="pixel">Selectionnez une des deux attaques que votre ${sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom()} va realiser sur ${sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom()}</p>
                        </div>
                    </div>
                    </c:when>
                    <c:otherwise>
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">
                            <span class="card-title pixel">${sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom()} vous attaque !</span>
                            <p class="pixel">${sessionScope.uds.getPolymonAdverseFromUser(cookie['pseudo'].value).getNom()} utilise ${sessionScope.attaqueNom} (${sessionScope.attaqueDegats}) !</p>
                        </div>
                        <div class="card-action">
                            <a class="pixel" href="/Projet-1.0/parcours/step/takedamage">Attaquer !</a>
                        </div>
                    </div>
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="col s3"></div>
        </div>
    </div>

</body>
</html>
