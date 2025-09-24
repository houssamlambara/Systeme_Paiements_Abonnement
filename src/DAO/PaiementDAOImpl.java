package DAO;

import com.mysql.cj.jdbc.ConnectionImpl;
import config.Connexion;
import model.Paiement;

import java.sql.*;

public class PaiementDAOImpl {

    private Connection connection;

    public PaiementDAOImpl(){
        this.connection = Connexion.getInstance().getConnection();
    }

    // Méthode pour ajouter un paiement dans la base
    public void create(Paiement paiement) throws Exception {
        String sql = "INSERT INTO Paiement (idPaiement, idAbonnement, dateEcheance, datePaiement, typePaiement, statut) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paiement.getIdPaiement().toString());
            stmt.setString(2, paiement.getIdAbonnement());
            stmt.setDate(3, new java.sql.Date(paiement.getDateEcheance().getTime()));
            if (paiement.getDatePaiement() != null) {
                stmt.setDate(4, new java.sql.Date(paiement.getDatePaiement().getTime()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }
            stmt.setString(5, paiement.getTypePaiement().name());
            stmt.setString(6, paiement.getStatut().name());
            stmt.executeUpdate();
            System.out.println("Paiement inséré avec succès !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
