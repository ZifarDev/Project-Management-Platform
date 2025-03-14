package Mini_Projet;

import java.util.ArrayList;

public class Utilisateur {
	//Attributs 
	private int id;
	private String nom;
	private String email;
	private String role;
	private ArrayList<Tache> tachesAssignees;
	
	//Constructeur
	public Utilisateur(int id, String nom, String email, String role) {
		this.id= id;
		this.nom= nom;
		this.email= email;
		this.role= role;
		this.tachesAssignees= new ArrayList<>();// Initialisation de la liste des tâches assignées
	}
	// Getters et Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom= nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role= role;
	}
	public ArrayList<Tache> getTachesAssignees() {
        return new ArrayList<>(tachesAssignees);
    }
	
	// Méthode pour assigner une tâche à l'utilisateur
    public void assignerTache(Tache tache) {
        if (tache != null) {
            tachesAssignees.add(tache);
            tache.setResponsable(nom);
            System.out.println("Tâche '" + tache.getNom() + "' assignée à " + nom);
        } else {
            System.out.println("Tâche invalide. Impossible de l'assigner.");
        }
    }
    
    // Méthode pour retirer une tâche assignée
    public void retirerTache(Tache tache) {
        if (tachesAssignees.remove(tache)) {
            tache.setResponsable(null);
            System.out.println("Tâche '" + tache.getNom() + "' retirée de l'utilisateur " + nom);
        } else {
            System.out.println("La tâche n'est pas assignée à cet utilisateur.");
        }
    }
    
    // Méthode pour afficher les tâches assignées
    public void afficherTachesAssignees() {
        System.out.println("Tâches assignées à " + nom + " :");
        if (tachesAssignees.isEmpty()) {
            System.out.println("Aucune tâche assignée.");
        } else {
            for (Tache tache : tachesAssignees) {
                System.out.println("- " + tache.getNom() + " (Statut: " + tache.getStatut() + ")");
            }
        }
    }
    
    // Méthode toString pour afficher un résumé de l'utilisateur
    @Override
    public String toString() {
        return "Utilisateur[ID=" + id 
                + ", Nom='" + nom + '\''
                + ", Email='" + email + '\''
                + ", Role='" + role + '\''
                + ", Tâches assignées=" + tachesAssignees.size() + "]";
    }
}