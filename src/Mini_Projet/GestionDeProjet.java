package Mini_Projet;

//Exemple d'utilisation pour tester les nouvelles fonctionnalités
public class GestionDeProjet {
    public static void main(String[] args) {
        // Création du projet
        Projet1 projet = new Projet1("Développement Plateforme", "Développer une plateforme", "Plateforme fonctionnelle", "31/12/2025");
        
        // Création des membres de l'équipe
        MenbreEquipe membre1 = new MenbreEquipe("Ahmed", "Développeur");
        MenbreEquipe membre2 = new MenbreEquipe("Ali", "Testeur");
        
        // Ajout des membres au projet
        projet.ajouterMembre(membre1);
        projet.ajouterMembre(membre2);
        
        // Création d'un forum de discussion
        Forum forum = new Forum("Problème de performance sur la plateforme");
        
        // Création de messages
        Message message1 = new Message(membre1, "Nous rencontrons des problèmes de performance sur la plateforme.");
        Message message2 = new Message(membre2, "Je pense que cela vient des requêtes sur la base de données.");
        
        // Ajout des réponses
        message1.ajouterReponse(message2);
        
        // Ajouter les messages au forum
        forum.ajouterMessage(message1);
        
        // Ajouter le forum au projet
        projet.ajouterForum(forum);
        
        // Création et ajout de fichiers partagés
        Fichier fichier1 = new Fichier("Documentation_Plateforme", "PDF", "/path/to/documents/documentation.pdf");
        Fichier fichier2 = new Fichier("CodeSource", "ZIP", "/path/to/code/source.zip");
        
        projet.ajouterFichier(fichier1);
        projet.ajouterFichier(fichier2);
        
        // Affichage des détails du projet
        projet.afficherDetails();
    }
}