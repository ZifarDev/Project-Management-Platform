package Mini_Projet;

//Classe Fichier pour gérer les fichiers partagés
class Fichier {
private String nom;
private String type;  // Par exemple : PDF, DOCX, etc.
private String chemin; // Le chemin d'accès au fichier

public Fichier(String nom, String type, String chemin) {
   this.nom = nom;
   this.type = type;
   this.chemin = chemin;
}

public void afficherFichier() {
   System.out.println("Fichier: " + nom + "." + type + " (chemin: " + chemin + ")");
}
}