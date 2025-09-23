package controller;

import service.AbonnementService;

import java.util.Date;

public class AbonnementController {

    AbonnementService abonnementService = new AbonnementService();

    public void creeAbonnement(String nomService,Double montantMensuel,
                               Date dateFin,
                               Integer dureeEngagementMois ){

    abonnementService.creerAbonnement(nomService,montantMensuel, dateFin,
             dureeEngagementMois);
    }

    public void creeAbonnementSansEngagement(String nomService, Double montantMensuel) throws Exception {
        abonnementService.creeAbonnementSansEngagement(nomService, montantMensuel);
    }

}
