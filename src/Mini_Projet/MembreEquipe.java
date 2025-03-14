package Mini_Projet;


public class MembreEquipe {
	    private String nom;
	    private String email;
	    private String role; 

	    public MembreEquipe(String nom, String email, String role) {
	        this.nom = nom;
	        this.email = email;
	        this.role = role;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void afficherDetails() {
	        System.out.println("Nom: " + nom);
	        System.out.println("Email: " + email);
	        System.out.println("Rôle: " + role);
	    }
	}
