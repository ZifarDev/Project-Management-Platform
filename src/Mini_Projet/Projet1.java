package Mini_Projet;

import java.util.List;
import java.util.ArrayList;


	// Classe Projet (ajout de la fonctionnalité de collaboration)
	class Projet1 {
	    private String nom;
	    private String objectifs;
	    private String livrables;
	    private String dateCloture;
	    private List<Tache> taches;
	    private List<MenbreEquipe> membresEquipe;
	    private List<Forum> forums;
	    private List<Fichier> fichiersPartages;
	    
	    public Projet1(String nom, String objectifs, String livrables, String dateCloture) {
	        this.nom = nom;
	        this.objectifs = objectifs;
	        this.livrables = livrables;
	        this.dateCloture = dateCloture;
	        this.taches = new ArrayList<>();
	        this.membresEquipe = new ArrayList<>();
	        this.forums = new ArrayList<>();
	        this.fichiersPartages = new ArrayList<>();
	    }
	    
	    public void ajouterTache(Tache tache) {
	        taches.add(tache);
	    }
	    
	    public void ajouterMembre(MenbreEquipe membre) {
	        membresEquipe.add(membre);
	    }
	    
	    public void ajouterForum(Forum forum) {
	        forums.add(forum);
	    }
	    
	    public void ajouterFichier(Fichier fichier) {
	        fichiersPartages.add(fichier);
	    }
	    
	    public void afficherDetails() {
	        System.out.println("Projet: " + nom);
	        System.out.println("Objectifs: " + objectifs);
	        System.out.println("Livrables: " + livrables);
	        System.out.println("Date de Clôture: " + dateCloture);
	        System.out.println("Forums de discussion:");
	        for (Forum forum : forums) {
	            forum.afficherForum();
	        }
	        System.out.println("Fichiers partagés:");
	        for (Fichier fichier : fichiersPartages) {
	            fichier.afficherFichier();
	        }
	    }
	}
