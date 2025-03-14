package Mini_Projet;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Suivi {
    private List<AbstractTache> taches;  // Association: Suivi is linked to AbstractTache

    public Suivi(List<AbstractTache> taches) {
        this.taches = taches;
    }

    // Méthode pour vérifier l'avancement des tâches
    public void verifierAvancement() {
        System.out.println("\n=== Vérification de l'avancement ===");
        for (AbstractTache tache : taches) {
            if (tache.getStatut().equals("en cours") && LocalDate.now().isAfter(tache.getFin())) {
                System.out.printf("⚠️ Retard détecté pour la tâche: %s (Fin prévue: %s)\n", tache.getNom(), tache.getFin());
            } else {
                System.out.printf("%s - Statut: %s - Fin prévue: %s\n", tache.getDetails(), tache.getStatut(), tache.getFin());
            }
        }
    }

 // Méthode pour mettre à jour l'état de la tâche
    public void mettreAJourTache() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Mise à jour des tâches ===");
        System.out.println("Choisissez une tâche à mettre à jour:");

        for (int i = 0; i < taches.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, taches.get(i).getNom());
        }

        int choix = scanner.nextInt();
        scanner.nextLine(); 

        if (choix > 0 && choix <= taches.size()) {
            AbstractTache tache = taches.get(choix - 1);
            System.out.println("Entrez le nouveau statut (en cours, terminée, non démarrée):");
            String nouveauStatut = scanner.nextLine();
            tache.setStatut(nouveauStatut);
            System.out.printf("Statut de la tâche '%s' mis à jour à '%s'.\n", tache.getNom(), nouveauStatut);
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
