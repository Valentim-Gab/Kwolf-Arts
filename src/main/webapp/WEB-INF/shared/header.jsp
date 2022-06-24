<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <img class="logo" src="resources/images/logo.png" alt="Logo da Kwolf arts" width="59" height="59" />
        <img src="resources/images/Kwolf_Arts.png" alt="Kwolf arts" width="63" height="65" />
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse ms-5" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 w-100 d-flex align-items-lg-center gap-2 gap-lg-5">
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${usuario_logado.tipo_conta != 'A'}">
                            <a href="home">
                                Página inicial
                            </a>
                        </c:when>

                        <c:otherwise>
                            <a href="indexArtista">
                                Página inicial
                            </a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <a href="#">
                        Artistas mais populares
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#">
                        Sobre nós
                    </a>
                </li>
                <li class="pesquisa">
                    <img title="pesquisar" src="resources/images/pesquisar.png" alt="pesquisar" width="33" height="33"
                         onclick="">
                </li>

                <div class="d-flex flex-lg-row flex-column ms-lg-auto gap-4">
                    <c:choose>
                        <c:when test="${usuario_logado != null}">
                            <div class="dropdown">

                                <button class="btn dropdown-toggle"
                                        id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false" style="color: #FFFFFF">
                                        ${usuario_logado.primeiro_nome}
                                </button>

                                <input type="hidden" name="id_logado" value="${usuario_logado.id_comprador}">
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                    <c:if test="${usuario_logado.tipo_conta =='A'}">
                                        <li>
                                            <a href="caminho?opcao=registrarArte">
                                                <button class="dropdown-item" type="button">
                                                    Registre sua arte
                                                </button>
                                            </a>
                                        </li>
                                    </c:if>
                                    <c:if test="${usuario_logado.tipo_conta =='C'}">
                                        <li>
                                            <a href="arte?opcao=arteComprada">
                                                <button class="dropdown-item" type="button">
                                                    Minhas compras
                                                </button>
                                            </a>
                                        </li>
                                    </c:if>
                                    <li>
                                        <a href="caminho?opcao=editar">
                                            <button class="dropdown-item" type="button">
                                                Minha conta
                                            </button>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="caminho?opcao=logout">
                                            <button class="dropdown-item" type="button">
                                                Sair
                                            </button>
                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </c:when>

                        <c:otherwise>
                            <li class="nav-item">
                                <a href="caminho?opcao=cadastro">
                                    <input class="btn btn-light" type="button" value="CADASTRE-SE" width="110" height="33"
                                           alt="Cadastre-se">
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="caminho?opcao=login">
                                    <input class="btn btn-light" type="button" value="LOGIN" width="110" height="33"
                                           alt="Login">
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </div>
            </ul>
        </div>
    </div>
</nav>