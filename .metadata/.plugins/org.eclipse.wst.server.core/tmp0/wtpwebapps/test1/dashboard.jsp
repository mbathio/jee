<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <%
        // Vérifier si l'utilisateur est connecté
        String user = (String) session.getAttribute("user");
        if (user == null) {
            // Rediriger vers la page de connexion si non connecté
            response.sendRedirect(request.getContextPath() + "/connexion");
            return;
        }
    %>
    <div class="sidebar">
        <div class="logo">
            <span>Mon Application</span>
        </div>
        <ul class="nav-links">
            <li><a href="<%=request.getContextPath()%>/dashboard.jsp">Accueil</a></li>
            <li><a href="<%=request.getContextPath()%>/table">Tables de multiplication</a></li>
            <li><a href="<%=request.getContextPath()%>/hello?name=<%=user%>">Dire bonjour</a></li>
            <li><a href="<%=request.getContextPath()%>/logout">Déconnexion</a></li>
        </ul>
    </div>
    
    <div class="main-content">
        <h1>Bienvenue, <%= user %> !</h1>
        <p>Vous êtes maintenant connecté à votre tableau de bord.</p>
        
        <div class="dashboard-widgets">
            <div class="widget">
                <h3>Tables de multiplication</h3>
                <p>Consultez les tables de multiplication.</p>
                <a href="<%=request.getContextPath()%>/table" class="login-btn">Accéder</a>
            </div>
            
            <div class="widget">
                <h3>Dire bonjour</h3>
                <p>Dites bonjour à l'application.</p>
                <a href="<%=request.getContextPath()%>/hello?name=<%=user%>" class="login-btn">Accéder</a>
            </div>
        </div>
    </div>
</body>
</html>