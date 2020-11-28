<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%
    Random rand = new Random();
    int x = rand.nextInt(950) + 50;
    int y = rand.nextInt(950) + 50;
%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <br/>
    <h1>Hello world</h1>
    <a href="/Projet-1.0/session">Using sessions</a>
    <br/>
    <a href="/Projet-1.0/cookie">Using cookies</a>
    <br/>
    <a href="/Projet-1.0/login">Connexion</a>
    <br/>
    <c:set var="x"><%=x %></c:set>
    <c:set var="y"><%=y %></c:set>
    <c:if test="${x < 500 && y < 500}">
        <c:out value="Petit chat"/>
    </c:if>
    <c:if test="${x > 500 && y > 500}">
        <c:out value="Grand chat"/>
    </c:if>


    <br/>
    <p>
        ${Hello.sayHello}<!-- Ne fonctionne pas (encore) parce que Léo est trop nul-->
    </p>
<img src="https://placekitten.com/<%=x%>/<%=y%>" alt="trop cool le chat" title="chat trop mignon"></img>

</body>
</html>
