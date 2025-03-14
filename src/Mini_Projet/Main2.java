package Mini_Projet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AbstractTache> taches = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Ajouter une milestone");
            System.out.println("3. Vérifier l'avancement");
            System.out.println("4. Mettre à jour une tâche");
            System.out.println("5. Afficher le diagramme de Gantt");
            System.out.println("6. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); //Consommez newline

            switch (choix) {
                case 1:
                	// Ajout d'une tâche de base
                    System.out.print("Nom de la tâche: ");
                    String nom = scanner.nextLine();
                    System.out.print("Date de début (YYYY-MM-DD): ");
                    LocalDate debut = LocalDate.parse(scanner.nextLine());
                    System.out.print("Date de fin (YYYY-MM-DD): ");
                    LocalDate fin = LocalDate.parse(scanner.nextLine());
                    System.out.print("Statut (en cours, terminée, non démarrée): ");
                    String statut = scanner.nextLine();
                    System.out.print("Durée estimée (jours): ");
                    int duree = scanner.nextInt();
                    scanner.nextLine(); //Consommez newline
                    try {
                        AbstractTache nouvelleTache = new Tache2(nom, debut, fin, statut, duree);
                        taches.add(nouvelleTache);
                        System.out.println("Tâche ajoutée avec succès.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;

                case 2:
                	// Ajout d'un jalon
                    System.out.print("Nom de la milestone: ");
                    String nomMilestone = scanner.nextLine();
                    System.out.print("Date de début (YYYY-MM-DD): ");
                    debut = LocalDate.parse(scanner.nextLine());
                    System.out.print("Date de fin (YYYY-MM-DD): ");
                    fin = LocalDate.parse(scanner.nextLine());
                    System.out.print("Statut (en cours, terminée, non démarrée): ");
                    statut = scanner.nextLine();
                    System.out.print("Durée estimée (jours): ");
                    duree = scanner.nextInt();
                    scanner.nextLine(); //Consommez newline
                    System.out.print("Objectif de la milestone: ");
                    String objectif = scanner.nextLine();
                    try {
                        AbstractTache milestone = new MilestoneTache(nomMilestone, debut, fin, statut, duree, objectif);
                        taches.add(milestone);
                        System.out.println("Milestone ajoutée avec succès.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;

                case 3:
                	// Vérifier les progrès
                    Suivi suivi = new Suivi(taches);
                    suivi.verifierAvancement();
                    break;

                case 4:
                	// Mettre à jour une tâche
                    suivi = new Suivi(taches);
                    suivi.mettreAJourTache();
                    break;

                case 5:
                    if (taches.isEmpty()) {
                        System.out.println("Aucune tâche à afficher sur le diagramme.");
                    } else {
                        ProgressTrackingGanttChart chart = new ProgressTrackingGanttChart("Project Tasks Gantt Chart", taches);
                        chart.pack();
                        chart.setVisible(true);
                    }
                    break;

                case 6:
                    System.out.println("Au revoir!");
                    return;

                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }
}

