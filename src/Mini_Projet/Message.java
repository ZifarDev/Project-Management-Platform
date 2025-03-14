package Mini_Projet;

import java.util.List;
import java.util.ArrayList;

	// Classe Message pour gérer les messages dans un forum
	class Message {
	    private MenbreEquipe auteur;//Cet attribut de type MembreEquipe représente l'auteur du message.
	    private String contenu;
	    private List<Message> reponses;//Il s'agit d'une liste (List<Message>) qui contient des objets de type Message
	                                   //  un message peut avoir plusieurs réponses
	    public Message(MenbreEquipe auteur, String contenu) {
	        this.auteur = auteur;
	        this.contenu = contenu;
	        this.reponses = new ArrayList<>();//crée une nouvelle ArrayList vide pour reponses, car au début, le message n'a pas de réponses.
	    }
	    
	    public void ajouterReponse(Message reponse) {
	        reponses.add(reponse);
	    }
	    
	    public void afficherMessage() {
	        System.out.println("- " + auteur.getNom() + " : " + contenu);
	        if (!reponses.isEmpty()) {  // La méthode isEmpty() de la liste reponses vérifie si cette liste contient des éléments ou non. Si reponses est vide, cela signifie qu'il n'y a pas de réponses à ce message.
	            System.out.println("  Réponses:");
	            for (Message reponse : reponses) {
	                reponse.afficherMessage();
	            }
	        }
	    }
	}