package Mini_Projet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Validation {
	// Méthode vérifie que l'email n'est pas vide et respecte un format valide 
	//Affiche un message d'erreur si l'email est incorrect 
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("L'email est obligatoire !");
            return false;
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.println("Format de l'email invalide !");
            return false;
        }
        return true;
    }
    // Méthode vérifie que la date est au bon format (yyyy-MM-dd) et valide 
    //Affiche un message d'erreur si le format est incorrect
    public static boolean isValidDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            System.out.println("La date est obligatoire !");
            return false;
        }
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Format de date invalide ! Utilisez 'yyyy-MM-dd'.");
            return false;
        }
    }
    // Méthode pour vérifier si une chaîne n'est pas vide ou nulle
    // Peut être utilisée pour des champs obligatoires comme le nom de la tâche ou le responsable
    public static boolean isNonEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Ce champ est obligatoire !");
            return false;
        }
        return true;
    }
    // Méthode pour vérifier si un nombre est positif
    public static boolean isPositiveNumber(int number) {
        if (number <= 0) {
            System.out.println("Le nombre doit être positif !");
            return false;
        }
        return true;
    }
    // Méthode pour valider la priorité d'une tâche
    public static boolean isValidPriorite(String priorite) {
        if (!isNonEmpty(priorite)) {
            System.out.println("La priorité est obligatoire !");
            return false;
        }
        if (!priorite.matches("(?i)Faible|Moyenne|Élevée")) {
            System.out.println("La priorité doit être 'Faible', 'Moyenne' ou 'Élevée' !");
            return false;
        }
        return true;
    }
    // Méthode pour valider le statut d'une tâche
    public static boolean isValidStatut(String statut) {
        if (!isNonEmpty(statut)) {
            System.out.println("Le statut est obligatoire !");
            return false;
        }
        // Liste des statuts acceptés
        if (!statut.matches("(?i)En attente|En cours|Terminée")) {
            System.out.println("Le statut doit être 'En attente', 'En cours' ou 'Terminée' !");
            return false;
        }
        return true;
    }
    
    // Méthode pour valider que la date limite est après la date de création
    public static boolean isValidDateRange(LocalDate dateCreation, LocalDate dateLimite) {
        if (dateCreation == null || dateLimite == null) {
            System.out.println("Les dates de création et limite sont obligatoires !");
            return false;
        }
        if (dateLimite.isBefore(dateCreation)) {
            System.out.println("La date limite ne peut pas être avant la date de création !");
            return false;
        }
        return true;
    }
    
}
