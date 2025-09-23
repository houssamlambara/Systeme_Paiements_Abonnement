package controller;

import ui.MenuUi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;


public class MainController {

    Scanner scanner = new Scanner(System.in);

    MenuUi menu = new MenuUi();
    AbonnementController abonnementController = new AbonnementController();

    public MainController(Integer choix) throws Exception {

        traitementOption(choix);
    }


    public void traitementOption(Integer choix) throws Exception {
        switch (choix) {
            case 1:
                menuCreationAbonnement();
                break;
            case 2:
                menuGestionAbonnement();
            break;
            case 0:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Choix invalide, Ressayez !");
        }

    }

    private void menuCreationAbonnement() throws Exception {

        Integer choix = menu.menuCreationAbonnement();
        switch (choix) {
            case 1:
                creeAbonnementAvecEngagement();
                break;
            case 2:
                creeAbonnementSansEngagement();
                break;
            case 3:
                System.out.println("Retour au menu principal...");
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }

    private void menuGestionAbonnement() {

        Integer choix = menu.menuGestionAbonnement();

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
    }

    public void creeAbonnementAvecEngagement(){
        System.out.println("Entre le nom de service :");
        String nomService = scanner.nextLine();
        System.out.println("Entre le montant : ");
        Double montantMensuel = scanner.nextDouble();
        System.out.println("Entrer la date de fin (dd-MM-yyyy): ");
        String strDate = scanner.next();
        System.out.println("Entrer la duree dengagement :");
        Integer duree = scanner.nextInt();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(strDate);
          abonnementController.creeAbonnement(nomService,montantMensuel,date,duree);
        } catch (Exception e) {
            throw new RuntimeException(e);
        };

    };

    public void creeAbonnementSansEngagement() throws Exception {
        System.out.println("Entre le nom de service :");
        String nomService = scanner.nextLine();
        System.out.println("Entre le montant : ");
        Double montantMensuel = scanner.nextDouble();

        abonnementController.creeAbonnementSansEngagement(nomService, montantMensuel);

    }



}