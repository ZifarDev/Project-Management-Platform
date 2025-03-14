package Mini_Projet;

import java.time.LocalDate;

public class MilestoneTache extends AbstractTache {
    private String objectif;

    public MilestoneTache(String nom, LocalDate debut, LocalDate fin, String statut, int dureeEstimee, String objectif) {
        super(nom, debut, fin, statut, dureeEstimee);
        this.objectif = objectif;
    }

    public String getObjectif() { return objectif; }

    @Override
    public String getDetails() {
        return String.format("Milestone: %s, Objectif: %s", getNom(), objectif);
    }
}
