package Mini_Projet;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tache {
	//Déclaration des attributs 
	
	private int id ; //identifiant unique pour chaque tâche
	private String nom; //Nom de la tâche
	private String description; //Détails sur ce sui doit etre fait
	private String responsable; //Nom de l'utilisateur assigné à la tâche
	private int duree; //Durée estimée ( en heures)
	private String priorite ; //Niveau de priorité
	private String statut; //état: en attente, en cours, terminée
	private LocalDate dateCreation; //Date de création de la tâche
	private LocalDate dateLimite; // date limite de la tâche
	private ArrayList<String> historique; //Historique des actions sur la tâche
	
	//Constructeur 
	public Tache(int id,String nom,String description,String responsable,int duree,String priorite,String statut, LocalDate dateCreation,LocalDate dateLimite) {
		this.id=id;
		this.nom=nom;
		this.description=description;
		this.responsable=responsable;
		this.duree=duree;
		this.priorite=priorite;
		this.statut=statut;
		this.dateCreation=dateCreation;
		this.dateLimite=dateLimite;
		this.historique= new ArrayList<>();// initialisation de l'historique vide 
		ajouterHistorique("Tâche créée");
	}
	
	//Les getters permettent d'accéder aux attributs, et les setters permettent de les modifier.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
		ajouterHistorique("ID modifié à " + id);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
		ajouterHistorique("Nom modifié à '" + nom + "'");
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		ajouterHistorique("Description modifiée.");
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable= responsable;
		ajouterHistorique("Responsable modifié à '" + responsable + "'");
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		if (duree > 0) {
            this.duree = duree;
            ajouterHistorique("Durée modifiée à " + duree + " heures");
        } else {
            System.out.println("Durée invalide : elle doit être positive.");
        }
	}
	public String getPriorite() {
		return priorite ;
	}
	public void setPriorite(String priorite) {
		this.priorite= priorite;
		ajouterHistorique("Priorité modifiée à '" + priorite + "'");
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut= statut;
		ajouterHistorique("Statut modifié à '" + statut + "'");
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation= dateCreation;
		ajouterHistorique("Date de création modifiée.");
	}
	public LocalDate getDateLimite() {
		return dateLimite;
	}
	public void setDateLimite(LocalDate dateLimite) {
		this.dateLimite= dateLimite;
		ajouterHistorique("Date limite modifiée à " + dateLimite);
	}
	public ArrayList<String> getHistorique(){
		return new ArrayList<>(historique);
	}
	
	// Méthode pour ajouter une entrée à l'historique
	public void ajouterHistorique(String action) {
	    // Ajouter la date actuelle et l'action dans une chaîne de texte
	    String entree = LocalDate.now() + ": " + action;

	    // Ajouter cette chaîne de texte dans la liste historique
	    historique.add(entree);
	}
	
	// Méthode pour afficher l'historique
    public void afficherHistorique() {
        System.out.println("Historique :");
        for (String entree : historique) {
            System.out.println(entree);
        }
    }
    //Méthode pur assigner un responsable à la tache 
    public void assignerResponsable(String responsable) {
        setResponsable(responsable);
    }
    
	// Méthode pour changer le statut de la tâche
    public void changerStatut(String nouveauStatut) {
        setStatut(nouveauStatut);
    }

 // Méthode pour changer la priorité de la tâche
    public void changerPriorite(String nouvellePriorite) {
        setPriorite(nouvellePriorite);
    }
    //Méthode pour vérifier si la tache est en retard
    public void verifierRetard() {
    	boolean enRetard = LocalDate.now().isAfter(dateLimite);
        String message = enRetard ? "La tâche est en retard !" : "La tâche n'est pas en retard.";
        System.out.println(message);
        ajouterHistorique("Vérification du retard : " + (enRetard ? "en retard" : "non en retard"));
    }
    // Méthode pour prolonger la date limite
    public void prolongerDateLimite(LocalDate nouvelleDateLimite) {
    	if (nouvelleDateLimite.isAfter(dateLimite)) {
            setDateLimite(nouvelleDateLimite);
            ajouterHistorique("Date limite prolongée à " + nouvelleDateLimite);
        } else {
            System.out.println("La nouvelle date limite (" + nouvelleDateLimite + ") doit être après la date actuelle (" + dateLimite + ").");
        }
    }
    
    // Méthode pour afficher les détails complets de la tache 
    public void afficherDetails() {
        System.out.println("===== Détails de la tâche =====");
        System.out.println("ID: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Responsable: " + responsable);
        System.out.println("Durée estimée: " + duree + " heures");
        System.out.println("Priorité: " + priorite);
        System.out.println("Statut: " + statut);
        System.out.println("Date de création: " + dateCreation);
        System.out.println("Date limite: " + dateLimite);
        System.out.println("Historique:");
        for (String entree : historique) {
            System.out.println(entree);
        }
        }
    
      @Override
        public String toString() {
            return "Tâche[ID=" + id + ", Nom='" + nom + '\''+ ", Responsable='" + responsable + '\''+ ", Priorité='" + priorite + '\''+ ", Statut='" + statut + '\''+ ", Date de création=" + dateCreation + ", Date limite=" + dateLimite + "]";
        }
    }
