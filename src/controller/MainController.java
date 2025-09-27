package controller;

import com.mysql.cj.xdevapi.SchemaImpl;
import enums.StatutPaiement;
import enums.TypePaiement;
import ui.MenuUi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;


public class MainController {

    Scanner scanner = new Scanner(System.in);

    MenuUi menu = new MenuUi();
    AbonnementController abonnementController = new AbonnementController();
    private PaiementController paiementController;


    public MainController(Integer choix) throws Exception {
        paiementController = new PaiementController();

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
                abonnementController.afficherTousLesAbonnements();
                break;
            case 2:
                modifierAbonnement();
                break;
            case 3:
                supprimerAbonnement();
            break;
            case 4:
                afficherPaiementsAbonnement();
                break;
            case 5:
                modifierPaiement();
                break;
            case 6:
                supprimerPaiement();
                break;
            case 7:
                enregistrerPaiement();
                break;
            case 8:
                System.out.println("Paiements manqués + total impayé...");
                break;
            case 9:
                System.out.println("Somme payée de l’abonnement...");
                break;
            case 10:
                System.out.println("Affichage des 5 derniers paiements...");
                break;
            case 11:
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

    private void modifierAbonnement() {
        try {
            System.out.println("Entrer l'ID de l'abonnement à modifier :");
            String id = scanner.nextLine().trim();
            System.out.println("Entrer le nouveau nom du service :");
            String nouveauNomService = scanner.nextLine();
            System.out.println("Entrer le nouveau montant :");
            Double nouveauMontant = Double.parseDouble(scanner.nextLine().trim());

            abonnementController.modifierAbonnement(id, nouveauNomService, nouveauMontant);
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification : " + e.getMessage());
        }
    }

    private void supprimerAbonnement() {
        try {
            System.out.println("Entrer l'ID de l'abonnement à supprimer :");
            String id = scanner.nextLine().trim();
            abonnementController.supprimerAbonnement(id);
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    private void afficherPaiementsAbonnement() {
        System.out.println("Entrer l'ID de l'abonnement pour voir ses paiements :");
        String idAbonnement = scanner.nextLine().trim();
        paiementController.afficherPaiementsParAbonnement(idAbonnement);
    }

    private void enregistrerPaiement() {
        System.out.println("Entrer l'ID de l'abonnement :");
        String idAbonnement = scanner.nextLine().trim();
        System.out.println("Entrer la date d'échéance (dd-MM-yyyy): ");
        String strDate = scanner.next();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateEcheance = formatter.parse(strDate);
            paiementController.enregistrerPaiement(idAbonnement, dateEcheance);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private void modifierPaiement() {
        System.out.println("Entrer l’ID du paiement à modifier :");
        String idPaiement = scanner.nextLine().trim();

        Date datePaiement = null;
        while (datePaiement == null) {
            System.out.println("Entrer la date de paiement (dd-MM-yyyy) :");
            String strDatePaiement = scanner.nextLine();
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                datePaiement = formatter.parse(strDatePaiement);
            } catch (Exception e) {
                System.out.println("Date invalide. Réessayez !");
            }
        }

        TypePaiement typePaiement = null;
        int typeChoix;
        do {
            System.out.println("Type de paiement :");
            System.out.println("1. CARTE_BANCAIRE");
            System.out.println("2. ESPECES");
            typeChoix = scanner.nextInt();
            if (typeChoix == 1) {
                typePaiement = TypePaiement.CARTE_BANCAIRE;
            } else if (typeChoix == 2) {
                typePaiement = TypePaiement.ESPECES;
            } else {
                System.out.println("Choix invalide, réessayez !");
            }
        } while (typeChoix != 1 && typeChoix != 2);

        StatutPaiement statut = null;
        int statutChoix;
        do {
            System.out.println("Statut du paiement :");
            System.out.println("1. PAYE");
            System.out.println("2. IMPAYE");
            System.out.println("3. EN RETARD");
            statutChoix = scanner.nextInt();
            if (statutChoix == 1) {
                statut = StatutPaiement.PAYE;
            } else if (statutChoix == 2) {
                statut = StatutPaiement.NON_PAYE;
            } else if (statutChoix ==3){
                statut = StatutPaiement.EN_RETARD;
            }else {
                System.out.println("Choix invalide, réessayez !");
            }
        } while (statutChoix != 1 && statutChoix != 2);

        scanner.nextLine();

        paiementController.modifierPaiement(idPaiement, datePaiement, typePaiement, statut);
    }

    private void supprimerPaiement() {
        System.out.println("Entrer l'ID du paiement à supprimer :");
        String idPaiement = scanner.nextLine().trim();

        try {
            paiementController.supprimerPaiement(idPaiement);
//            System.out.println("Paiement supprimé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}