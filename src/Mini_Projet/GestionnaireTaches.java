package Mini_Projet;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GestionnaireTaches {
	//Attributs 
	private ArrayList<Tache> taches;
	//Constructeur 
	public GestionnaireTaches() {
		this.taches= new ArrayList<>();
	}
	// Ajouter une tâche
    public void ajouterTache(Tache tache) {
        taches.add(tache);
        System.out.println("Tâche ajoutée : " + tache.getNom());
    }
 // Supprimer une tâche par ID
    public void supprimerTache(int id) {
        Tache tacheASupprimer = chercherTacheParId(id);
        if (tacheASupprimer != null) {
            taches.remove(tacheASupprimer);
            System.out.println("Tâche supprimée : " + tacheASupprimer.getNom());
        } else {
            System.out.println("Aucune tâche trouvée avec l'ID : " + id);
        }
    }
    // Modifier une tâche par ID
    public void modifierTache(int id, String nouveauNom, String nouvelleDescription) {
        Tache tacheAModifier = chercherTacheParId(id);
        if (tacheAModifier != null) {
            tacheAModifier.setNom(nouveauNom);
            tacheAModifier.setDescription(nouvelleDescription);
            System.out.println("Tâche modifiée : " + tacheAModifier.getNom());
        } else {
            System.out.println("Aucune tâche trouvée avec l'ID : " + id);
        }
    }
    // Chercher une tâche par ID
    public Tache chercherTacheParId(int id) {
        for (Tache tache : taches) {
            if (tache.getId() == id) {
                return tache;
            }
        }
        return null;
    }
    // Lister toutes les tâches
    public void listerTaches() {
        if (taches.isEmpty()) {
            System.out.println("Aucune tâche à afficher.");
        } else {
            System.out.println("===== Liste des tâches =====");
            for (Tache tache : taches) {
                tache.afficherDetails();
                System.out.println("--------------------------");
            }
        }
    }
    // Rechercher les tâches en retard
    public List<Tache> rechercherTachesEnRetard() {
        List<Tache> tachesEnRetard = new ArrayList<>();
        LocalDate aujourdHui = LocalDate.now();
        for (Tache tache : taches) {
            if (tache.getDateLimite().isBefore(aujourdHui) && !tache.getStatut().equalsIgnoreCase("Terminée")) {
                tachesEnRetard.add(tache);
            }
        }
        return tachesEnRetard;
    }
 // Afficher les tâches en retard
    public void afficherTachesEnRetard() {
        List<Tache> tachesEnRetard = rechercherTachesEnRetard();
        if (tachesEnRetard.isEmpty()) {
            System.out.println("Aucune tâche en retard.");
        } else {
            System.out.println("===== Tâches en retard =====");
            for (Tache tache : tachesEnRetard) {
                tache.afficherDetails();
            }
        }
    }
 // Rechercher des tâches par responsable
    public List<Tache> rechercherTachesParResponsable(String responsable) {
        List<Tache> resultats = new ArrayList<>();
        for (Tache tache : taches) {
            if (tache.getResponsable().equalsIgnoreCase(responsable)) {
                resultats.add(tache);
            }
        }
        return resultats;
    }
 // Afficher les tâches d'un responsable
    public void afficherTachesParResponsable(String responsable) {
        List<Tache> tachesParResponsable = rechercherTachesParResponsable(responsable);
        if (tachesParResponsable.isEmpty()) {
            System.out.println("Aucune tâche trouvée pour le responsable : " + responsable);
        } else {
            System.out.println("===== Tâches de " + responsable + " =====");
            for (Tache tache : tachesParResponsable) {
                tache.afficherDetails();
            }
        }
    }
    

}

