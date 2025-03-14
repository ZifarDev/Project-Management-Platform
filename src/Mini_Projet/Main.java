package Mini_Projet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionnaireTaches gestionnaireTaches = new GestionnaireTaches();
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

        boolean continuer = true;

        while (continuer) {
            try {
                System.out.println("\n===== Gestionnaire de Projet =====");
                System.out.println("1. Gérer les tâches");
                System.out.println("2. Gérer les utilisateurs");
                System.out.println("3. Exporter les données");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option : ");
                int choix = Integer.parseInt(scanner.nextLine());

                switch (choix) {
                    case 1:
                        menuTaches(scanner, gestionnaireTaches);
                        break;
                    case 2:
                        menuUtilisateurs(scanner, utilisateurs, gestionnaireTaches);
                        break;
                    case 3:
                        menuExportation(scanner, gestionnaireTaches);
                        break;
                    case 4:
                        continuer = false;
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        scanner.close();
    }

    // Sous-menu pour gérer les tâches
    private static void menuTaches(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        boolean retour = false;
        while (!retour) {
            try {
                System.out.println("\n===== Gestion des Tâches =====");
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Modifier une tâche");
                System.out.println("3. Supprimer une tâche");
                System.out.println("4. Lister toutes les tâches");
                System.out.println("5. Rechercher les tâches en retard");
                System.out.println("6. Rechercher les tâches par responsable");
                System.out.println("7. Retour au menu principal");
                System.out.print("Choisissez une option : ");
                int choix = Integer.parseInt(scanner.nextLine());

                switch (choix) {
                    case 1:
                        ajouterTache(scanner, gestionnaireTaches);
                        break;
                    case 2:
                        modifierTache(scanner, gestionnaireTaches);
                        break;
                    case 3:
                        supprimerTache(scanner, gestionnaireTaches);
                        break;
                    case 4:
                        gestionnaireTaches.listerTaches();
                        break;
                    case 5:
                        gestionnaireTaches.afficherTachesEnRetard();
                        break;
                    case 6:
                        rechercherTachesParResponsable(scanner, gestionnaireTaches);
                        break;
                    case 7:
                        retour = true;
                        break;
                    default:
                        System.out.println("Option invalide. Réessayez !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    private static void ajouterTache(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        System.out.println("Ajout d'une nouvelle tâche :");
        try {
            System.out.print("ID : ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Description : ");
            String description = scanner.nextLine();

            System.out.print("Responsable : ");
            String responsable = scanner.nextLine();

            System.out.print("Durée (en heures) : ");
            int duree = Integer.parseInt(scanner.nextLine());

            System.out.print("Priorité (Faible/Moyenne/Élevée) : ");
            String priorite = scanner.nextLine();
            if (!Validation.isValidPriorite(priorite)) return;

            System.out.print("Statut (En attente/En cours/Terminée) : ");
            String statut = scanner.nextLine();
            if (!Validation.isValidStatut(statut)) return;

            System.out.print("Date limite (yyyy-MM-dd) : ");
            String dateLimiteStr = scanner.nextLine();
            if (!Validation.isValidDate(dateLimiteStr)) return;

            LocalDate dateLimite = LocalDate.parse(dateLimiteStr);
            Tache nouvelleTache = new Tache(id, nom, description, responsable, duree, priorite, statut, LocalDate.now(), dateLimite);

            gestionnaireTaches.ajouterTache(nouvelleTache);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'ID ou la durée.");
        }
    }

    private static void modifierTache(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        System.out.print("ID de la tâche à modifier : ");
        try {
            int idModif = Integer.parseInt(scanner.nextLine());

            System.out.print("Nouveau nom : ");
            String nouveauNom = scanner.nextLine();

            System.out.print("Nouvelle description : ");
            String nouvelleDescription = scanner.nextLine();

            gestionnaireTaches.modifierTache(idModif, nouveauNom, nouvelleDescription);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'ID.");
        }
    }

    private static void supprimerTache(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        System.out.print("ID de la tâche à supprimer : ");
        try {
            int idSupprimer = Integer.parseInt(scanner.nextLine());
            gestionnaireTaches.supprimerTache(idSupprimer);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'ID.");
        }
    }

    private static void rechercherTachesParResponsable(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        System.out.print("Nom du responsable : ");
        String responsable = scanner.nextLine();
        gestionnaireTaches.afficherTachesParResponsable(responsable);
    }

    // Sous-menu pour gérer les utilisateurs
    private static void menuUtilisateurs(Scanner scanner, ArrayList<Utilisateur> utilisateurs, GestionnaireTaches gestionnaireTaches) {
        boolean retour = false;
        while (!retour) {
            try {
                System.out.println("\n===== Gestion des Utilisateurs =====");
                System.out.println("1. Ajouter un utilisateur");
                System.out.println("2. Assigner une tâche à un utilisateur");
                System.out.println("3. Afficher les tâches d'un utilisateur");
                System.out.println("4. Retour au menu principal");
                System.out.print("Choisissez une option : ");
                int choix = Integer.parseInt(scanner.nextLine());

                switch (choix) {
                    case 1:
                        ajouterUtilisateur(scanner, utilisateurs);
                        break;
                    case 2:
                        assignerTacheAUtilisateur(scanner, utilisateurs, gestionnaireTaches);
                        break;
                    case 3:
                        afficherTachesUtilisateur(scanner, utilisateurs);
                        break;
                    case 4:
                        retour = true;
                        break;
                    default:
                        System.out.println("Option invalide. Réessayez !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    private static void ajouterUtilisateur(Scanner scanner, ArrayList<Utilisateur> utilisateurs) {
        System.out.print("ID : ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Email : ");
            String email = scanner.nextLine();
            if (!Validation.isValidEmail(email)) return;

            System.out.print("Rôle : ");
            String role = scanner.nextLine();

            Utilisateur utilisateur = new Utilisateur(id, nom, email, role);
            utilisateurs.add(utilisateur);
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'ID.");
        }
    }

    private static void assignerTacheAUtilisateur(Scanner scanner, ArrayList<Utilisateur> utilisateurs, GestionnaireTaches gestionnaireTaches) {
        System.out.print("Nom de l'utilisateur : ");
        String nomUtilisateur = scanner.nextLine();
        Utilisateur utilisateur = utilisateurs.stream().filter(u -> u.getNom().equals(nomUtilisateur)).findFirst().orElse(null);

        if (utilisateur == null) {
            System.out.println("Utilisateur introuvable !");
            return;
        }

        System.out.print("ID de la tâche à assigner : ");
        try {
            int idTache = Integer.parseInt(scanner.nextLine());
            Tache tache = gestionnaireTaches.chercherTacheParId(idTache);

            if (tache == null) {
                System.out.println("Tâche introuvable !");
                return;
            }

            utilisateur.assignerTache(tache);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide pour l'ID.");
        }
    }

    private static void afficherTachesUtilisateur(Scanner scanner, ArrayList<Utilisateur> utilisateurs) {
        System.out.print("Nom de l'utilisateur : ");
        String nomUtilisateur = scanner.nextLine();
        Utilisateur utilisateur = utilisateurs.stream().filter(u -> u.getNom().equals(nomUtilisateur)).findFirst().orElse(null);

        if (utilisateur == null) {
            System.out.println("Utilisateur introuvable !");
        } else {
            utilisateur.afficherTachesAssignees();
        }
    }

    // Sous-menu pour exporter les données
    private static void menuExportation(Scanner scanner, GestionnaireTaches gestionnaireTaches) {
        System.out.println("\n===== Exportation des Données =====");
        System.out.println("1. Exporter en CSV");
        System.out.println("2. Exporter en JSON");
        System.out.println("3. Exporter en TXT");
        System.out.print("Choisissez une option : ");
        try {
            int choix = Integer.parseInt(scanner.nextLine());

            System.out.print("Nom du fichier (avec extension) : ");
            String fileName = scanner.nextLine();

            switch (choix) {
                case 1:
                    ExportFichier.exportToCSV(fileName, gestionnaireTaches.rechercherTachesParResponsable(""));
                    break;
                case 2:
                    ExportFichier.exportToJSON(fileName, gestionnaireTaches.rechercherTachesParResponsable(""));
                    break;
                case 3:
                    ExportFichier.exportToTXT(fileName, gestionnaireTaches.rechercherTachesParResponsable(""));
                    break;
                default:
                    System.out.println("Option invalide !");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }
}

