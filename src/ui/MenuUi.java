package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUi {

    Scanner scanner = new Scanner(System.in);

    public Integer menuCreationAbonnement() {
        Integer choix ;

        do {
                System.out.println("=== Créer un abonnement ===");
                System.out.println("1. Avec engagement");
                System.out.println("2. Sans engagement");
                System.out.println("3. Retour");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                System.out.println();
            return choix;
        } while (choix != 3);
    }

    public Integer menuGestionAbonnement() {
        Integer choix ;

        do {
                System.out.println("=== Gérer un abonnement ===");
                System.out.println("1. Lister les abonnement");
                System.out.println("2. Modifier un abonnement");
                System.out.println("3. Supprimer un abonnement");
                System.out.println("4. Afficher paiements d'un abonnement");
                System.out.println("5. Afficher tout les Paiement");
                System.out.println("6. Modifier un Paiement");
                System.out.println("7. Supprimer un Paiement");
                System.out.println("8. Enregistrer un paiement");
                System.out.println("9. Paiements manqués avec le montant total");
                System.out.println("10. Afiche la Somme payée d’un abonnement");
                System.out.println("11. Afficher les 5 derniers paiements");
                System.out.println("12. Rapports financiers");
                System.out.println("0. Retour");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                System.out.println();

            return choix;

        } while (choix != 0);
    }
}
