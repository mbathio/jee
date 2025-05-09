<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp">
    <jsp:param name="titre" value="${utilisateur.id != null ? 'Modifier un Utilisateur' : 'Ajouter un Utilisateur'}" />
</jsp:include>

<h1>${utilisateur.id != null ? "Modifier un Utilisateur" : "Ajouter un Utilisateur"}</h1>

<div class="form-container">
    <form method="post">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" id="nom" name="nom" value="${utilisateur.nom}">
            <c:if test="${!empty erreurs.nom}">
                <span class="error">${erreurs.nom}</span>
            </c:if>
        </div>
        
        <div class="form-group">
            <label for="prenom">Prénom</label>
            <input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}">
            <c:if test="${!empty erreurs.prenom}">
                <span class="error">${erreurs.prenom}</span>
            </c:if>
        </div>
        
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" id="login" name="login" value="${utilisateur.login}">
            <c:if test="${!empty erreurs.login}">
                <span class="error">${erreurs.login}</span>
            </c:if>
        </div>
        
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password">
            <c:if test="${!empty erreurs.password}">
                <span class="error">${erreurs.password}</span>
            </c:if>
        </div>
        
        <div class="form-group">
            <label for="passwordBis">Password (confirmation)</label>
            <input type="password" id="passwordBis" name="passwordBis">
        </div>
        
        <div class="form-actions">
            <button type="submit" class="btn btn-add">${utilisateur.id != null ? "Ajouter" : "Ajouter"}</button>
            <a href="list" class="btn-secondary">Annuler</a>
        </div>
    </form>
</div>

