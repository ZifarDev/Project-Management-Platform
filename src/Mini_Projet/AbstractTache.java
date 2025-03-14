package Mini_Projet;

import java.time.LocalDate;

public abstract class AbstractTache {
    private String nom;           // Nom de la tâche
    private LocalDate debut;      // Date de début
    private LocalDate fin;        // Date de fin
    private String statut;        // Statut de la tâche
    private int dureeEstimee;     // Durée estimée en jours

  //Constructeur pour initialiser la tâche
    public AbstractTache(String nom, LocalDate debut, LocalDate fin, String statut, int dureeEstimee) {
        if (fin.isBefore(debut)) {
            throw new IllegalArgumentException("La date de fin ne peut pas être avant la date de début.");
        }
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
        this.statut = statut;
        this.dureeEstimee = dureeEstimee;
    }

 // Getters pour tous les attributs
    public String getNom() { return nom; }
    public LocalDate getDebut() { return debut; }
    public LocalDate getFin() { return fin; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public int getDureeEstimee() { return dureeEstimee; }

 // Méthode abstraite pour les détails qui seront implémentés dans les sous-classes
    public abstract String getDetails();
}
