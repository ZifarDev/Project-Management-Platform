package Mini_Projet;

public class Ressource {
		// Les attribus de class Ressources:
		private int idRessource;
		private String type;
	    protected boolean disponibilite;
	    // le constructeur :
	    public Ressource(int idRessource, String type, boolean disponibilite) {
	        this.idRessource = idRessource;
	        this.type = type;
	        this.disponibilite = disponibilite;
	    }
	    // methode getter pour accéder à les attributs
	   
	    public String getType() {
	        return type;
	    }
	    // une méthode pour vérifier la disponibilité
	    public boolean isDisponibilite() {
	        return disponibilite;
	    }
	    // une methode pour allouer le ressources à une tache
	    public void allouerRessource() {
	        if (disponibilite) {
	            System.out.println("Ressource " + type + " allouer.");
	            this.disponibilite = false; 
	        } else {
	            System.out.println("Ressource " + type + " non disponible.");
	        }
	    }
	    // une methode pour librer les resourcres après l'allocation
	    public void libererRessource() {
	        this.disponibilite = true;
	        System.out.println("Ressource " + type + " libérée.");
	    }
}
