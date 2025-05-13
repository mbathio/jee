<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur 404 - Page non trouvée</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
    <style>
        .error-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        
        .error-code {
            font-size: 72px;
            font-weight: bold;
            color: #ef233c;
            margin-bottom: 10px;
        }
        
        .error-message {
            font-size: 24px;
            margin-bottom: 20px;
            color: #2b2d42;
        }
        
        .error-description {
            margin-bottom: 30px;
            color: #6c757d;
        }
        
        .back-button {
            display: inline-block;
            background-color: #4361ee;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        
        .back-button:hover {
            background-color: #3851d4;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-code">404</div>
        <div class="error-message">Page non trouvée</div>
        <div class="error-description">
            La page que vous recherchez n'existe pas ou a été déplacée.
            <br>
            Vérifiez l'URL ou retournez à la page d'accueil.
        </div>
        <a href="${pageContext.request.contextPath}/list" class="back-button">Retour à la liste des utilisateurs</a>
    </div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur 404 - Page non trouvée</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
    <style>
        .error-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        
        .error-code {
            font-size: 72px;
            font-weight: bold;
            color: #ef233c;
            margin-bottom: 10px;
        }
        
        .error-message {
            font-size: 24px;
            margin-bottom: 20px;
            color: #2b2d42;
        }
        
        .error-description {
            margin-bottom: 30px;
            color: #6c757d;
        }
        
        .back-button {
            display: inline-block;
            background-color: #4361ee;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        
        .back-button:hover {
            background-color: #3851d4;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-code">404</div>
        <div class="error-message">Page non trouvée</div>
        <div class="error-description">
            La page que vous recherchez n'existe pas ou a été déplacée.
            <br>
            Vérifiez l'URL ou retournez à la page d'accueil.
        </div>
        <a href="${pageContext.request.contextPath}/list" class="back-button">Retour à la liste des utilisateurs</a>
    </div>
</body>
</html>