<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:set var="titre" value="Accueil - Gestion des Utilisateurs" scope="request" />
        <%@ include file="/WEB-INF/inc/header.jsp" %>

            <main class="home-page">
                <section class="hero-section">
                    <h1>Bienvenue dans votre Application de Gestion des Utilisateurs</h1>
                    <p class="lead">Une solution simple et efficace pour gérer vos utilisateurs</p>
                </section>

                <section class="features-section">
                    <div class="feature-card">
                        <h3>Ajouter des Utilisateurs</h3>
                        <p>Créez facilement de nouveaux comptes utilisateurs avec tous les détails nécessaires.</p>
                        <a href="${pageContext.request.contextPath}/ajouter" class="btn btn-primary">Ajouter un Utilisateur</a>
                    </div>

                    <div class="feature-card">
                        <h3>Liste des Utilisateurs</h3>
                        <p>Consultez et gérez tous vos utilisateurs en un seul endroit.</p>
                        <a href="${pageContext.request.contextPath}/lister" class="btn btn-primary">Voir la Liste</a>
                    </div>

                    <div class="feature-card">
                        <h3>Gestion des Comptes</h3>
                        <p>Modifiez ou supprimez les comptes utilisateurs selon vos besoins.</p>
                        <a href="${pageContext.request.contextPath}/lister" class="btn btn-primary">Gérer les Comptes</a>
                    </div>
                </section>
            </main>

            <style>
                .home-page {
                    padding: 2rem;
                }
                
                .hero-section {
                    text-align: center;
                    padding: 3rem 1rem;
                    background: linear-gradient(135deg, var(--primary-color), var(--primary-dark));
                    color: white;
                    border-radius: 10px;
                    margin-bottom: 3rem;
                    box-shadow: var(--shadow-lg);
                }
                
                .hero-section h1 {
                    font-size: 2.5rem;
                    margin-bottom: 1rem;
                }
                
                .lead {
                    font-size: 1.25rem;
                    opacity: 0.9;
                }
                
                .features-section {
                    display: grid;
                    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                    gap: 2rem;
                    padding: 1rem;
                }
                
                .feature-card {
                    background: white;
                    padding: 2rem;
                    border-radius: 8px;
                    box-shadow: var(--shadow-md);
                    text-align: center;
                    transition: transform var(--transition-speed);
                }
                
                .feature-card:hover {
                    transform: translateY(-5px);
                }
                
                .feature-card h3 {
                    color: var(--primary-color);
                    margin-bottom: 1rem;
                }
                
                .feature-card p {
                    margin-bottom: 1.5rem;
                    color: var(--text-color);
                }
                
                .btn {
                    display: inline-block;
                    padding: 0.75rem 1.5rem;
                    border-radius: 5px;
                    text-decoration: none;
                    transition: background-color var(--transition-speed);
                }
                
                .btn-primary {
                    background-color: var(--primary-color);
                    color: white;
                }
                
                .btn-primary:hover {
                    background-color: var(--primary-dark);
                }
                
                @media (max-width: 768px) {
                    .hero-section h1 {
                        font-size: 2rem;
                    }
                    .features-section {
                        grid-template-columns: 1fr;
                    }
                }
            </style>

            <%@ include file="/WEB-INF/inc/footer.jsp" %>