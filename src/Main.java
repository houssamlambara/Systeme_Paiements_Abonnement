import controller.MainController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer choix ;

        do {
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Créer un abonnement");
                System.out.println("2. Gérer un abonnement");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                new MainController(choix);

            System.out.println();
        } while (choix != 0);

        scanner.close();
    }
}