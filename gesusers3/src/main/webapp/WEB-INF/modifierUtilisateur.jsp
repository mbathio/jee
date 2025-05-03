<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier un Utilisateur</title>
       <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin: 15px 0 5px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        a {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: blue;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
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