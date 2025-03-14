package Mini_Projet;

import java.time.LocalDate;

public class Tache2 extends AbstractTache {
    public Tache2(String nom, LocalDate debut, LocalDate fin, String statut, int dureeEstimee) {
        super(nom, debut, fin, statut, dureeEstimee);
    }

    @Override
    public String getDetails() {
        return String.format("Tâche: %s, Durée estimée: %d jours", getNom(), getDureeEstimee());
    }
}

