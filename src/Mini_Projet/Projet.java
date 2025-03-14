package Mini_Projet;

public class Projet {
    // Attributs de projet
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String[] objectifs; // Tableau des objectifs du projet
    private String[] livrables; // Tableau des livrables
    private MembreEquipe[] membresEquipe; // Tableau des membres de l'équipe (modified to MembreEquipe)
    private int nombreObjectifs; // Compteur pour le nombre d'objectifs
    private int nombreLivrables; // Compteur pour le nombre de livrables
    private int nombreMembres; // Compteur pour le nombre de membres dans l'équipe

    // Constructeur
    public Projet(String nom, String description, String dateDebut, String dateFin, int maxObjectifs, int maxLivrables, int maxMembres) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.objectifs = new String[maxObjectifs];
        this.livrables = new String[maxLivrables];
        this.membresEquipe = new MembreEquipe[maxMembres]; // Changed to MembreEquipe[]
        this.nombreObjectifs = 0;
        this.nombreLivrables = 0;
        this.nombreMembres = 0;
    }
    // Getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String[] getObjectifs() {
        return objectifs;
    }

    public String[] getLivrables() {
        return livrables;
    }

    public MembreEquipe[] getMembresEquipe() { // Return type changed to MembreEquipe[]
        return membresEquipe;
    }

    // Méthodes pour ajouter des objectifs et des livrables
    public void ajouterObjectif(String objectif) {
        if (nombreObjectifs < objectifs.length) {
            objectifs[nombreObjectifs] = objectif;
            nombreObjectifs++;
        } else {
            System.out.println("Limite des objectifs atteinte !");
        }
    }

    public void ajouterLivrable(String livrable) {
        if (nombreLivrables < livrables.length) {
            livrables[nombreLivrables] = livrable;
            nombreLivrables++;
        } else {
            System.out.println("Limite des livrables atteinte !");
        }
    }

    // Méthode pour ajouter un membre à l'équipe
    public void ajouterMembre(MembreEquipe membre) { // Parameter type changed to MembreEquipe
        if (nombreMembres < membresEquipe.length) {
            membresEquipe[nombreMembres] = membre; // Adding MembreEquipe object
            nombreMembres++;
        } else {
            System.out.println("Limite des membres atteinte !");
        }
    }

    // Méthode pour afficher les détails du projet
    public void afficherDetails() {
        System.out.println(" Détails du Projet :");
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Date de début: " + dateDebut);
        System.out.println("Date de fin: " + dateFin);

        // Affichage des objectifs
        System.out.println("\nObjectifs:");
        for (int i = 0; i < nombreObjectifs; i++) {
            System.out.println("- " + objectifs[i]);
        }

        // Affichage des livrables
        System.out.println("\nLivrables:");
        for (int i = 0; i < nombreLivrables; i++) {
            System.out.println("- " + livrables[i]);
        }

        // Affichage des membres de l'équipe
        System.out.println("\nMembres de l'équipe:");
        for (int i = 0; i < nombreMembres; i++) {
            membresEquipe[i].afficherDetails(); // Displaying MembreEquipe details
        }
    }
}
