<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp" />

<div id="corps">
    <c:if test="${ !empty param.error }">
        <div id="statusMessageBox" class="alert alert-danger">
            <span id="control" onclick="hideMessageBox()" title="Fermer">✖</span>
            Echec de L'authentification : login et/ ou mot de passe incorrect
        </div>
    </c:if>

    <h1 id="titre-principal">Authentification</h1>

    <div class="form-container">
        <form method="post" action="login">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" id="login" name="login" value="${param.user}">
                <c:if test="${!empty erreurs.login}">
                    <span class="error">${erreurs.login}</span>
                </c:if>
            </div>
            
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password">
                <c:if test="${!empty erreurs.password}">
                    <span class="error">${erreurs.password}</span>
                </c:if>
            </div>
            
            <div class="form-actions">
                <button type="submit" class="btn btn-login">Se connecter</button>
               
            </div>
        </form>
    </div>
</div>

<jsp:include page="inc/footer.jsp" />
  