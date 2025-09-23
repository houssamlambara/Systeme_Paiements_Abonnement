package controller;

import service.AbonnementService;
import model.Abonnement;
import DAO.AbonnementDAO;
import DAO.AbonnementDAOImpl;
import model.AbonnementAvecEngagement;
import model.AbonnementSansEngagement;

import java.util.UUID;
import java.util.Date;
import java.util.List;

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

    public void afficherTousLesAbonnements() {
        try {
            AbonnementDAO abonnementDAO = new AbonnementDAOImpl();
            List<Abonnement> abonnements = abonnementDAO.findAll();

            if (abonnements.isEmpty()) {
                System.out.println("Aucun abonnement trouvé.");
            } else {
                System.out.println("===== Liste des abonnements =====");
                for (Abonnement ab : abonnements) {
                    System.out.println(
                            "ID: " + ab.getId() +
                                    " | Service: " + ab.getNomService() +
                                    " | Montant: " + ab.getMontantMensuel() +
                                    " | Date Fin: " + ab.getDateFin() +
                                    " | Type: " + ab.getTypeAbonnement()
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'affichage : " + e.getMessage());
        }
    }

    public void modifierAbonnement(String id, String nouveauNomService, Double nouveauMontant) throws Exception {
        AbonnementSansEngagement abonnement = new AbonnementSansEngagement(nouveauNomService, nouveauMontant);
        abonnement.setId(UUID.fromString(id));
        abonnementService.modifierAbonnement(abonnement);
    }

    public void supprimerAbonnement(String id) throws Exception {
        abonnementService.supprimerAbonnement(id);
    }


}
