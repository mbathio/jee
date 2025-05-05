<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier Utilisateur</title>
    <style>
        label, input, span {
            display: block;
            margin: 10px;
        }
        .error {
            color: tomato;
        }
    </style>
</head>
<body>
    <h1>Modifier Utilisateur</h1>

    <form method="post" >
        <input type="hidden" name="id" value="${utilisateur.id}">

        <label for="nom">Nom</label>
        <input type="text" id="nom" name="nom" value="${utilisateur.nom}">
        <c:if test="${!empty erreurs.nom}">
            <span class="error">${erreurs.nom}</span>
        </c:if>

        <label for="prenom">Prénom</label>
        <input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}">
        <c:if test="${!empty erreurs.prenom}">
            <span class="error">${erreurs.prenom}</span>
        </c:if>

        <label for="login">Login</label>
        <input type="text" id="login" name="login" value="${utilisateur.login}">
        <c:if test="${!empty erreurs.login}">
            <span class="error">${erreurs.login}</span>
        </c:if>

        <label for="password">password</label>
        <input type="password" id="password" name="password">
        <c:if test="${!empty erreurs.password}">
            <span class="error">${erreurs.password}</span>
        </c:if>

        <label for="passwordBis">PasswordBis</label>
        <input type="password" id="passwordBis" name="passwordBis">
        <c:if test="${!empty erreurs.password}">
            <span class="error">${erreurs.password}</span>
        </c:if>

        <input type="submit" value="Modifier">
    </form>
</body>
</html>
