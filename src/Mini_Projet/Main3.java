package Mini_Projet;

public class Main3 {

	public static void main(String[] args) {
		
		// Création des objets ressources
        Materielles materielle = new Materielles (1,"materielle", "Ordinateur", true);  
        Humaines humaine = new Humaines(2, "humaines","Développeur", false); 
     // Création des tâches
       
        Tache3 tache = new Tache3(2, "Test des fonctionnalités");

        // Affectation des ressources aux tâches
        tache.affecterRessource(humaine);
        tache.affecterRessource(materielle);


        // Affichage des détails des tâches
        tache.afficherDetails();
       

        // Libération des ressources après l'achèvement des tâches
        tache.libererRessource(humaine);
        tache.libererRessource(materielle);


        // Affichage des tâches après libération des ressources
        tache.afficherDetails();
        //appel la méthode de Libération des ressources
    
    }
	

}
