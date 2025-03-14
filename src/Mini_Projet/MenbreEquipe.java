package Mini_Projet;

//Classe MembreEquipe pour définir un membre de l'équipe
	class MenbreEquipe {
	    private String nom;
	    private String role;
	    
	    public MenbreEquipe(String nom, String role) {
	        this.nom = nom;
	        this.role = role;
	    }
	    
	    public String getNom() {
	        return nom;
	    }
	    
	    public String getRole() {
	        return role;
	    }
	}
