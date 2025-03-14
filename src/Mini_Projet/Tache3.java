package Mini_Projet;

import java.util.ArrayList;
import java.util.List;

public class Tache3 {
    private int idTache;
    private String nom; 
    private String statut; 
    private List<Ressource> ressources; 

    public Tache3(int idTache, String nom) {
        this.idTache = idTache;
        this.nom = nom;
        this.statut = "En attente"; 
        this.ressources = new ArrayList<>(); 
    }

    // Méthode pour affecter une ressource à la tâche
    public void affecterRessource(Ressource ressource) {
        if (ressource.isDisponibilite()) {
            ressources.add(ressource);
            ressource.allouerRessource(); 
            System.out.println("Ressource " + ressource.getType() + " affectée à la tâche : " + nom);
        } else {
            System.out.println("Ressource " + ressource.getType() + " déjà occupée.");
        }
    }

    // Méthode pour libérer une ressource
    public void libererRessource(Ressource ressource) {
        if (ressources.contains(ressource)) {
            ressources.remove(ressource);
            ressource.libererRessource();
            System.out.println("Ressource " + ressource.getType() + " libérée de la tâche : " + nom);
        } else {
            System.out.println("Cette ressource n'est pas affectée à la tâche.");
        }
    }

    // Méthode pour afficher les détails de la tâche
    public void afficherDetails() {
        System.out.println("Tâche : " + nom + " [ID: " + idTache + "] - Statut: " + statut);
        System.out.println("Ressources affectées : ");
        for (Ressource ressource : ressources) {
            System.out.println("  - " + ressource.getType());
        }
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

  

}