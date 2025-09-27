package controller;

import service.PaiementService;
import model.Paiement;
import enums.TypePaiement;
import enums.StatutPaiement;

import java.util.Date;

public class PaiementController {

    PaiementService paiementService = new PaiementService();

    public void modifierPaiement(String idPaiement, Date datePaiement, TypePaiement typePaiement, StatutPaiement statut) {
        paiementService.modifierPaiement(idPaiement, datePaiement, typePaiement, statut);
    }

    public void supprimerPaiement(String idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }

    public void afficherPaiementsParAbonnement(String idAbonnement) {
        paiementService.obtenirPaiementsParAbonnement(idAbonnement);
    }

    public void enregistrerPaiement(String idAbonnement, Date dateEcheance) {
        paiementService.enregistrerPaiement(idAbonnement, dateEcheance, TypePaiement.CARTE_BANCAIRE);
    }
}
