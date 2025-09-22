package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            try {
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Créer un abonnement");
                System.out.println("2. Gérer un abonnement");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        menuCreationAbonnement(scanner);
                        break;
                    case 2:
                        menuGestionAbonnement(scanner);
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, Ressayez !");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrez un nombre valide !");
                scanner.nextLine();
            }
            System.out.println();
        } while (choix != 0);

        scanner.close();
    }

    private static void menuCreationAbonnement(Scanner scanner) {
        int choix = -1;

        do {
            try {
                System.out.println("=== Créer un abonnement ===");
                System.out.println("1. Avec engagement");
                System.out.println("2. Sans engagement");
                System.out.println("3. Retour");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
//                        abonnementService.creeAbonnement();
                        System.out.println("Création abonnement avec engagement...");
                        break;
                    case 2:
//                        abonnementService.creeabonnement();
                        System.out.println("Création abonnement sans engagement...");
                        break;
                    case 3:
                        System.out.println("Retour au menu principal...");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrez un nombre valide !");
                scanner.nextLine();
            }
            System.out.println();
        } while (choix != 3);
    }

    private static void menuGestionAbonnement(Scanner scanner) {
        int choix = 1;

        do {
            try {
                System.out.println("=== Gérer un abonnement ===");
                System.out.println("1. Lister les abonnement");
                System.out.println("2. Modifier un abonnement");
                System.out.println("3. Supprimer un abonnement");
                System.out.println("4. Afficher paiements d'un abonnement");
                System.out.println("5. Enregistrer un paiement");
                System.out.println("6. Paiements manqués avec le montant total");
                System.out.println("7. Afiche la Somme payée d’un abonnement");
                System.out.println("8. Afficher les 5 derniers paiements");
                System.out.println("9. Rapports financiers");
                System.out.println("0. Retour");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Liste des abonnements...");
                        break;
                    case 2:
                        System.out.println("Modification d’un abonnement...");
                        break;
                    case 3:
                        System.out.println("Suppression d’un abonnement...");
                        break;
                    case 4:
                        System.out.println("Affichage des paiements...");
                        break;
                    case 5:
                        System.out.println("Enregistrement d’un paiement...");
                        break;
                    case 6:
                        System.out.println("Paiements manqués + total impayé...");
                        break;
                    case 7:
                        System.out.println("Somme payée de l’abonnement...");
                        break;
                    case 8:
                        System.out.println("Affichage des 5 derniers paiements...");
                        break;
                    case 9:
                        System.out.println("Rapports financiers...");
                        break;
                    case 0:
                        System.out.println("Retour au menu principal...");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrez un nombre valide !");
                scanner.nextLine();
            }
            System.out.println();
        } while (choix != 0);
    }
}
