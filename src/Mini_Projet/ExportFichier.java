package Mini_Projet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportFichier {

    // Méthode pour exporter en format CSV
    public static void exportToCSV(String fileName, List<Tache> taches) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Ajouter les en-têtes du fichier CSV
            writer.append("ID,Nom,Description,Responsable,Statut,Date Limite\n");

            // Ajouter les données de chaque tâche
            for (Tache tache : taches) {
                writer.append(tache.getId() + ",")
                      .append(tache.getNom() + ",")
                      .append(tache.getDescription() + ",")
                      .append(tache.getResponsable() + ",")
                      .append(tache.getStatut() + ",")
                      .append(tache.getDateLimite().toString() + "\n");
            }
            System.out.println("Export CSV réussi dans le fichier : " + fileName);
            System.out.println("Chemin absolu du fichier : " + new java.io.File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'export CSV : " + e.getMessage());
        }
    }

    // Méthode pour exporter en format JSON
    public static void exportToJSON(String fileName, List<Tache> taches) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n"); // Début du tableau JSON

        for (int i = 0; i < taches.size(); i++) {
            Tache tache = taches.get(i);

            // Ajouter les données d'une tâche
            jsonBuilder.append("  {\n")
                       .append("    \"id\": ").append(tache.getId()).append(",\n")
                       .append("    \"nom\": \"").append(tache.getNom()).append("\",\n")
                       .append("    \"description\": \"").append(tache.getDescription()).append("\",\n")
                       .append("    \"responsable\": \"").append(tache.getResponsable()).append("\",\n")
                       .append("    \"statut\": \"").append(tache.getStatut()).append("\",\n")
                       .append("    \"dateLimite\": \"").append(tache.getDateLimite().toString()).append("\"\n")
                       .append("  }");

            // Ajouter une virgule après chaque tâche sauf la dernière
            if (i < taches.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]"); // Fin du tableau JSON

        // Écrire le contenu dans un fichier
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(jsonBuilder.toString());
            System.out.println("Export JSON réussi dans le fichier : " + fileName);
            System.out.println("Chemin absolu du fichier : " + new java.io.File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'export JSON : " + e.getMessage());
        }
    }

    // Méthode pour exporter en format TXT
    public static void exportToTXT(String fileName, List<Tache> taches) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Tache tache : taches) {
                writer.append("ID : ").append(String.valueOf(tache.getId())).append("\n")
                      .append("Nom : ").append(tache.getNom()).append("\n")
                      .append("Description : ").append(tache.getDescription()).append("\n")
                      .append("Responsable : ").append(tache.getResponsable()).append("\n")
                      .append("Statut : ").append(tache.getStatut()).append("\n")
                      .append("Date Limite : ").append(tache.getDateLimite().toString()).append("\n")
                      .append("-------------------------------\n");
            }
            System.out.println("Export TXT réussi dans le fichier : " + fileName);
            System.out.println("Chemin absolu du fichier : " + new java.io.File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erreur lors de l'export TXT : " + e.getMessage());
        }
    }
}
