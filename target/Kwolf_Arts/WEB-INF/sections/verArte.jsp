<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 04/05/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html lang="pt-Br">

<head>
    <jsp:include page="../shared/head.jsp"></jsp:include>
    <title>Modelo de Exercício</title>
</head>

<body style="background: black;">
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container">
        <a href="arte?opcao=arteComprada" class="btn btn-light">VOLTAR</a>
        <img src="${arte.imagem}" alt="..." width="100%">
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>

</html>