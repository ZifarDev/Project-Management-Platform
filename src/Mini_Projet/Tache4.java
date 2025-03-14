package Mini_Projet;

import java.util.List;
import java.util.ArrayList;

	// Classe Tache (classe de base pour les tâches)
	abstract class Tache4 {
	    protected String description;//Une chaîne de caractères (type String) qui contient une description de la tâche.
	    protected int dureeEstimee;// Un entier (type int) représentant la durée estimée pour accomplir la tâche, par exemple en heures.
	    protected List<MembreEquipe> membres;// permettant d'ajouter plusieurs membres à la tâche.
	    
	    public Tache4(String description, int dureeEstimee) {
	        this.description = description;
	        this.dureeEstimee = dureeEstimee;
	        this.membres = new ArrayList<>();//Initialise une nouvelle ArrayList vide pour stocker les membres de l'équipe affectés à cette tâche
	    }
	    
	    public void ajouterMembre(MembreEquipe membre) { // MembreEquipe représentant un membre de l'équipe qui sera assigné à cette tâche.
	        membres.add(membre);
	    }
	    
	    public abstract void afficherDetails();
	}
