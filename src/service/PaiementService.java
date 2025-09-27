package service;

import DAO.PaiementDAO;
import DAO.PaiementDAOImpl;
import enums.TypePaiement;
import enums.StatutPaiement;
import model.Paiement;

import java.util.Date;
import java.util.List;

public class PaiementService {

    PaiementDAOImpl paiementDAO = new PaiementDAOImpl();

    public void enregistrerPaiement(String idAbonnement, Date dateEcheance, TypePaiement typePaiement) {
        Paiement paiement = new Paiement(idAbonnement, dateEcheance, typePaiement);
        try {
            paiementDAO.create(paiement);
            System.out.println("Paiement créé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement du paiement : " + e.getMessage());
        }
    }

    public void modifierPaiement(String idPaiement, Date datePaiement, TypePaiement typePaiement, StatutPaiement statut) {
        try {
            Paiement paiement = paiementDAO.findById(idPaiement);
            paiement.setDatePaiement(datePaiement);
            paiement.setTypePaiement(typePaiement);
            paiement.setStatut(statut);
            paiementDAO.update(paiement);
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification : " + e.getMessage());
        }
    }

    public void supprimerPaiement(String idPaiement) {
        try {
            paiementDAO.delete(idPaiement);
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    public void obtenirPaiementsParAbonnement(String idAbonnement) {
        try {
            List<Paiement> paiements = paiementDAO.findByAbonnement(idAbonnement);
            for (Paiement p : paiements) {
                System.out.println("Paiement : " + p.getIdPaiement() +
                        " | Échéance : " + p.getDateEcheance() +
                        " | Statut : " + p.getStatut());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l’affichage : " + e.getMessage());
        }
    }

    public void afficherTousLesPaiements() {
        try {
            List<Paiement> paiements = paiementDAO.findAll(); // récupère tous les paiements depuis la DB

            if (paiements.isEmpty()) {
                System.out.println("Aucun paiement trouvé.");
                return;
            }

            // Utilisation de Stream API pour parcourir et afficher
            paiements.stream()
                    .forEach(p -> System.out.println(
                            "ID Paiement: " + p.getIdPaiement() +
                                    " | ID Abonnement: " + p.getIdAbonnement() +
                                    " | Échéance: " + p.getDateEcheance() +
                                    " | Paiement: " + p.getDatePaiement() +
                                    " | Type: " + p.getTypePaiement() +
                                    " | Statut: " + p.getStatut()
                    ));

        } catch (Exception e) {
            System.out.println("Erreur lors de l'affichage de tous les paiements : " + e.getMessage());
        }
    }

    public void detecterImpayes(){

    };

    public void montantTotalImpayes(){

    };

    public void genererRapportsFinanciers(){

    };

}
