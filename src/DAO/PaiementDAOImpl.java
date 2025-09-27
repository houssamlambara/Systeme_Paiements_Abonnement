package DAO;

import com.mysql.cj.jdbc.ConnectionImpl;
import config.Connexion;
import enums.StatutPaiement;
import enums.TypePaiement;
import model.Paiement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaiementDAOImpl {

    private Connection connection;

    public PaiementDAOImpl(){
        this.connection = Connexion.getInstance().getConnection();
    }

    // Ajouter
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Paiement paiement) throws Exception {
        String sql = "UPDATE Paiement SET dateEcheance = ?, datePaiement = ?, typePaiement = ?, statut = ? WHERE idPaiement = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(paiement.getDateEcheance().getTime()));

            if (paiement.getDatePaiement() != null) {
                stmt.setDate(2, new java.sql.Date(paiement.getDatePaiement().getTime()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setString(3, paiement.getTypePaiement().name());
            stmt.setString(4, paiement.getStatut().name());
            stmt.setString(5, paiement.getIdPaiement().toString());

            stmt.executeUpdate();
            System.out.println("Paiement modifié avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la modification du paiement : " + e.getMessage(), e);
        }
    }

    public void delete(String idPaiement) throws Exception {
        String sql = "DELETE FROM Paiement WHERE idPaiement = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idPaiement);
            stmt.executeUpdate();
            System.out.println("Paiement supprimé avec succès !");
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du paiement : " + e.getMessage(), e);
        }
    }

    public Paiement findById(String idPaiement) throws Exception {
        return findAll().stream()
                .filter(p -> p.getIdPaiement().toString().equals(idPaiement))
                .findFirst()
                .orElse(null);
    }

    public List<Paiement> findAll() throws Exception {
        List<Paiement> paiements = new ArrayList<>();
        String sql = "SELECT * FROM Paiement";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Paiement p = new Paiement(
                        rs.getString("idAbonnement"),
                        rs.getDate("dateEcheance"),
                        rs.getDate("datePaiement"),
                        TypePaiement.valueOf(rs.getString("typePaiement")),
                        StatutPaiement.valueOf(rs.getString("statut"))
                );
                p.setIdPaiement(UUID.fromString(rs.getString("idPaiement")));
                paiements.add(p);
            }
        }
        return paiements;
    }

    public List<Paiement> findByAbonnement(String idAbonnement) throws Exception {
        List<Paiement> paiements = new ArrayList<>();
        String sql = "SELECT * FROM Paiement WHERE idAbonnement = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idAbonnement);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Paiement p = new Paiement(
                        rs.getString("idAbonnement"),
                        rs.getDate("dateEcheance"),
                        rs.getDate("datePaiement"),
                        TypePaiement.valueOf(rs.getString("typePaiement")),
                        StatutPaiement.valueOf(rs.getString("statut"))
                );
                p.setIdPaiement(UUID.fromString(rs.getString("idPaiement")));
                paiements.add(p);
            }
        }
        return paiements;
    }
}
