<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des utilisateurs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="container">
        <h1>Liste des utilisateurs</h1>

        <c:choose>
            <c:when test="${empty utilisateurs}">
                <div class="empty-message">
                    <p>Désolé, la liste des utilisateurs est vide.</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Login</th>
                                <th>Password</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="utilisateur" items="${utilisateurs}">
                                <tr>
                                    <td><c:out value="${utilisateur.id}"/></td>
                                    <td><c:out value="${utilisateur.nom}"/></td>
                                    <td><c:out value="${utilisateur.prenom}"/></td>
                                    <td><c:out value="${utilisateur.login}"/></td>
                                    <td><c:out value="${utilisateur.password}"/></td>
                                    <td class="actions">
                                        <a href="update?id=<c:out value='${utilisateur.id}'/>" class="btn btn-edit">Modifier</a>
                                        <a href="delete?id=<c:out value='${utilisateur.id}'/>" class="btn btn-delete" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?');">Supprimer</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="pagination">
                    <!-- Pagination à implémenter si nécessaire -->
                </div>
            </c:otherwise>
        </c:choose>
        
        <div class="actions-container">
            <a href="add" class="btn btn-add">Ajouter un utilisateur</a>
        </div>
    </div>
</body>
</html>