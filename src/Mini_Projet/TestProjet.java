package Mini_Projet;

public class TestProjet {

    public static void main(String[] args) {

        // Création des membres de l'équipe avec des rôles spécifiques
        MembreEquipe membre1 = new MembreEquipe("Hadyle", "hadyle@example.com", "Chef de projet");
        MembreEquipe membre2 = new MembreEquipe("Zifar", "zifar@example.com", "Développeur");
        MembreEquipe membre3 = new MembreEquipe("Donia", "donia@example.com", "Testeur");
        MembreEquipe membre4 = new MembreEquipe("Mohamed", "Mohamed@example.com", "UI/UX Designer");

        // Créer un projet avec des limites pour les objectifs, livrables et membres
        Projet projet = new Projet("Plateforme de Gestion de Projet", "Développer une plateforme complète de gestion de projets",
                                   "2023-06-20", "2024-11-31", 10, 10, 5);

        // Ajouter des objectifs et des livrables au projet
        projet.ajouterObjectif("Développer une interface utilisateur intuitive.");
        projet.ajouterObjectif("Intégrer des fonctionnalités de collaboration.");
        projet.ajouterObjectif("Mettre en place un système de gestion des tâches.");
        projet.ajouterObjectif("Assurer la sécurité des données des utilisateurs.");

        projet.ajouterLivrable("Version initiale de la plateforme déployée.");
        projet.ajouterLivrable("Documentation technique complète.");
        projet.ajouterLivrable("Manuel utilisateur.");
        projet.ajouterLivrable("Tests de performance et de sécurité.");

        // Ajouter des membres au projet
        projet.ajouterMembre(membre1);
        projet.ajouterMembre(membre2);
        projet.ajouterMembre(membre3);
        projet.ajouterMembre(membre4);

        // Afficher les détails du projet
        projet.afficherDetails();
    }
}
