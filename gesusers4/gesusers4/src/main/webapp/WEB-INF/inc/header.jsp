<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${param.titre != null ? param.titre : 'Gestion des utilisateurs'}</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
            <style>
                /* Styles de secours en cas de problème de chargement du CSS */
                
                 :root {
                    --primary-color: #4361ee;
                    --primary-dark: #3851d4;
                    --danger-color: #ef233c;
                    --danger-dark: #d90429;
                    --success-color: #2dc653;
                    --background-color: #f8f9fa;
                    --text-color: #2b2d42;
                    --border-color: #dee2e6;
                    --table-header-bg: #e9ecef;
                    --shadow-sm: 0 2px 4px rgba(0, 0, 0, 0.05);
                    --shadow-md: 0 4px 6px rgba(0, 0, 0, 0.1);
                    --shadow-lg: 0 10px 15px rgba(0, 0, 0, 0.1);
                    --transition-speed: 0.3s;
                }
                
                body {
                    font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                    background-color: var(--background-color);
                    color: var(--text-color);
                    line-height: 1.6;
                    min-height: 100vh;
                    display: flex;
                    flex-direction: column;
                    margin: 0;
                }
                
                header {
                    background-color: #000;
                    color: white;
                    padding: 1rem 0;
                    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                }
                
                .main-title {
                    text-align: center;
                    font-size: 2rem;
                    margin-bottom: 1rem;
                }
                
                .nav-menu {
                    display: flex;
                    justify-content: center;
                    list-style: none;
                    padding: 0;
                    margin: 0;
                    background-color: #333;
                }
                
                .nav-menu li a {
                    display: block;
                    color: white;
                    text-decoration: none;
                    padding: 1rem 2rem;
                }
                
                .nav-menu li a:hover {
                    background-color: var(--primary-color);
                }
                
                .container {
                    max-width: 1200px;
                    margin: 2rem auto;
                    padding: 0 1rem;
                    flex: 1;
                }
                
                footer {
                    background-color: #000;
                    color: white;
                    padding: 1rem 0;
                    margin-top: auto;
                    text-align: center;
                }
            </style>
        </head>

        <body>
            <header>
                <h1 class="main-title">GESTION DES UTILISATEURS</h1>
                <nav>
                    <ul class="nav-menu">
                        <li><a href="<c:url value='/'/>">Accueil</a></li>
                        <c:choose>
                            <c:when test="${empty sessionScope.utilisateur}">
                                <li><a href="<c:url value='/login'/>">Connexion</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value='/list'/>">Lister</a></li>
                                <li><a href="<c:url value='/add'/>">Ajouter</a></li>
                                <li><a href="<c:url value='/logout'/>">Déconnexion</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </header>

            <div class="container">