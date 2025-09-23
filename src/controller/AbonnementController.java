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

}
