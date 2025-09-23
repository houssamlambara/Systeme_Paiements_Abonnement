package service;

import DAO.AbonnementDAO;
import DAO.AbonnementDAOImpl;
import model.Abonnement;
import model.AbonnementAvecEngagement;
import model.AbonnementSansEngagement;

import java.util.Date;

public class AbonnementService {

    AbonnementDAOImpl abonnementDAO = new AbonnementDAOImpl();

    public void creerAbonnement(String nomService,Double montantMensuel,
                                Date dateFin,
                                Integer dureeEngagementMois){

    AbonnementAvecEngagement abonnementAvecEngagement = new AbonnementAvecEngagement(nomService,montantMensuel, dateFin, dureeEngagementMois);
    abonnementDAO.create(abonnementAvecEngagement);

    };

    public void creeAbonnementSansEngagement(String nomService, Double montantMensuel) throws Exception {
        AbonnementSansEngagement abonnementSansEngagement = new AbonnementSansEngagement(nomService,montantMensuel);
        abonnementDAO.create(abonnementSansEngagement);

    }

    public void modifierAbonnement(){

    };

    public void supprimerAbonnement(){

    };

    public void resilierAbonnement(){

    };

    public void listerTous(){

    };

    public void listerActifs(){

    };

    public void genererEcheances(){

    };
}
