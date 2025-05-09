<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Utilisateurs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
    <style>
        /* Style supplémentaire pour l'en-tête */
        header {
            background-color: #4361ee;
            color: white;
            padding: 1rem 0;
            margin-bottom: 2rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        .header-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        .logo {
            font-size: 1.5rem;
            font-weight: bold;
        }
        
        nav ul {
            display: flex;
            list-style: none;
            gap: 1.5rem;
        }
        
        nav a {
            color: white;
            text-decoration: none;
            transition: opacity 0.3s;
        }
        
        nav a:hover {
            opacity: 0.8;
        }
        
        .container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 1rem;
        }
        
        .error-message {
            background-color: #ffdddd;
            border-left: 6px solid #f44336;
            padding: 1rem;
            margin-bottom: 1rem;
            border-radius: 4px;
        }
        
        .success-message {
            background-color: #ddffdd;
            border-left: 6px solid #4CAF50;
            padding: 1rem;
            margin-bottom: 1rem;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <header>
        <div class="header-container">
            <div class="logo">Gestion des Utilisateurs</div>
            <nav>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/list">Liste des utilisateurs</a></li>
                    <li><a href="${pageContext.request.contextPath}/add">Ajouter un utilisateur</a></li>
                </ul>
            </nav>
        </div>
    </header>
    
    <div class="container">