package Mini_Projet;

import java.util.List;
import java.util.ArrayList;


// Classe Forum pour gérer les discussions
	class Forum {
	    private String sujet;//C'est un attribut de type String qui représente le sujet du forum de discussion.
	    private List<Message> messages;//C'est une liste de type List<Message>. Elle contient tous les messages échangés dans le forum
	    //constructeur
	    public Forum(String sujet) {
	    this.sujet = sujet;
	    this.messages = new ArrayList<>();
	    }
	    
	    public void ajouterMessage(Message message) {
	        messages.add(message);
	    }
	    
	    public void afficherForum() {
	        System.out.println("Forum de discussion: " + sujet);
	        for (Message element : messages ) {
	            element.afficherMessage();
	        }
	    }
	}