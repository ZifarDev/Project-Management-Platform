package Mini_Projet;

public class Humaines extends Ressource {
	// attribut de humaines
	private String nom;
	 // le constructeur :
    public Humaines(int idRessource,String type, String nom, boolean disponibilite) {
        super(idRessource,type, disponibilite );
        this.nom=nom;
    }
     @Override
     public boolean isDisponibilite() {
    	 super.isDisponibilite();
         return disponibilite;
     }
     @Override
     public void allouerRessource() {
         if (isDisponibilite()) {
             System.out.println("Ressource " + getType() + " " + nom+  " allouer.");
             this.disponibilite = false;  
         } else {
             System.out.println("Ressource " + getType()+  " " + nom+ " non disponible.");
         }
     }
     @Override
     public void libererRessource() {
         this.disponibilite = true;
         System.out.println("Ressource " + getType() + " " + nom+  " libérée.");
     }
}
