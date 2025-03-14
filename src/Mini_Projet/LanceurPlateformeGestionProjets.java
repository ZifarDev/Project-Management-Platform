package Mini_Projet;

import java.util.Scanner;

public class LanceurPlateformeGestionProjets {

    public static void main(String[] args) {
        // Création d'un scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affichage du message de bienvenue
        System.out.println("Bienvenue dans la Plateforme de Gestion de Projets !");
        System.out.println("Cette plateforme permet de gérer les projets, les tâches, les ressources, et la collaboration des équipes.");
        System.out.println("------------------------------------------------------------");
        
        // Affichage du menu pour choisir une section
        System.out.println("Veuillez choisir une option pour accéder à une partie de la plateforme:");
        System.out.println("1. Création de projets");
        System.out.println("2. Gestion des tâches");
        System.out.println("3. Suivi de l'avancement");
        System.out.println("4. Gestion des ressources");
        System.out.println("5. Collaboration");
        
        // Lecture de l'option choisie par l'utilisateur
        int choix = scanner.nextInt();
        
        // Exécution de la méthode correspondant à l'option choisie
        switch (choix) {
            case 1:
                System.out.println("Lancement de la partie 'Création de projets'...");
                TestProjet.main(args);
                break;
                
            case 2:
                System.out.println("Lancement de la partie 'Gestion des tâches'...");
                Main.main(args);
                break;
                
            case 3:
                System.out.println("Lancement de la partie 'Suivi de l'avancement'...");
                Main2.main(args);
                break;
                
            case 4:
                System.out.println("Lancement de la partie 'Gestion des ressources'...");
                Main3.main(args);
                break;
                
            case 5:
                System.out.println("Lancement de la partie 'Collaboration'...");
                GestionDeProjet.main(args);
                break;
                
            default:
                System.out.println("Option invalide. Veuillez choisir une option entre 1 et 5.");
                break;
        }

        // Fermeture du scanner après utilisation
        scanner.close();
        
        System.out.println("------------------------------------------------------------");
        System.out.println("Fin de l'exécution de la Plateforme de Gestion de Projets.");
    }
}

