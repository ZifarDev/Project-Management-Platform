package Mini_Projet;

public class Materielles extends Ressource {
	
	// attribut de materielle
	private String nomMat ;
	 // le constructeur :
	public Materielles(int idRessource,String type, String nomMat, boolean disponibilite) {
        super(idRessource,type, disponibilite );
        this.nomMat=nomMat;
    }
     @Override
     public boolean isDisponibilite() {
    	 super.isDisponibilite();
         return disponibilite;
     }
     @Override
     public void allouerRessource() {
         if (isDisponibilite()) {
             System.out.println("Ressource " + getType() + " " + nomMat+  " allouer.");
             this.disponibilite = false;  
         } else {
             System.out.println("Ressource " + getType()+  " " + nomMat+ " non disponible.");
         }
     }
     @Override
     public void libererRessource() {
         this.disponibilite = true;
         System.out.println("Ressource " + getType() + " " + nomMat+  " libérée.");
     }

}