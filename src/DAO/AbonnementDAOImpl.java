package DAO;

import config.Connexion;
import model.Abonnement;
import model.AbonnementAvecEngagement;
import model.AbonnementSansEngagement;

import java.sql.*;
import java.util.UUID;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AbonnementDAOImpl implements AbonnementDAO {

    private Connection connection;

    public AbonnementDAOImpl(){
        this.connection = Connexion.getInstance().getConnection();
    }

    @Override
    public void create(AbonnementAvecEngagement abonnement){
        String sql = "INSERT INTO Abonnement (id, nomService, montantMensuel, dateDebut, dateFin, statut, typeAbonnement, dureeEngagementMois) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, abonnement.getId().toString());
            stmt.setString(2, abonnement.getNomService());
            stmt.setDouble(3, abonnement.getMontantMensuel());
            stmt.setDate(4, new java.sql.Date(abonnement.getDateDebut().getTime()));
            stmt.setDate(5, new java.sql.Date(abonnement.getDateFin().getTime()));
            stmt.setString(6, abonnement.getStatut().name());
            stmt.setString(7, abonnement.getTypeAbonnement());
            stmt.setInt(8, abonnement.getDureeEngagementMois());
            stmt.executeUpdate();
            System.out.println("Abonnement inséré avec succès");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(AbonnementSansEngagement abonnement) {
        String sql = "INSERT INTO Abonnement (id, nomService, montantMensuel, dateDebut, dateFin, statut, typeAbonnement, dureeEngagementMois) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            if (abonnement.getId() == null) abonnement.setId(java.util.UUID.randomUUID());
            stmt.setString(1, abonnement.getId().toString());
            stmt.setString(2, abonnement.getNomService());
            stmt.setDouble(3, abonnement.getMontantMensuel());
            stmt.setDate(4, new java.sql.Date(abonnement.getDateDebut().getTime()));
            stmt.setNull(5, java.sql.Types.DATE);
            stmt.setString(6, abonnement.getStatut().name());
            stmt.setString(7, abonnement.getTypeAbonnement());
            stmt.setNull(8, java.sql.Types.INTEGER);
            stmt.executeUpdate();
            System.out.println("Abonnement sans engagement inséré avec succès");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Abonnement findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<Abonnement> findAll() throws Exception {
        List<Abonnement> abonnements = new ArrayList<>();
        String sql = "SELECT * FROM Abonnement";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet listeAbonnements = stmt.executeQuery();
            while (listeAbonnements.next()) {
                String id = listeAbonnements.getString("id");
                String nomService = listeAbonnements.getString("nomService");
                double montant = listeAbonnements.getDouble("montantMensuel");
                String type = listeAbonnements.getString("typeAbonnement");

                Abonnement abonnement;
                if ("AvecEngagement".equals(type)) {
                    int duree = listeAbonnements.getInt("dureeEngagementMois");
                    java.sql.Date dateFinSql = listeAbonnements.getDate("dateFin");
                    java.util.Date dateFin = dateFinSql != null ? new java.util.Date(dateFinSql.getTime()) : null;
                    abonnement = new AbonnementAvecEngagement(nomService, montant, dateFin, duree);
                } else {
                    abonnement = new AbonnementSansEngagement(nomService, montant);
                }

                java.sql.Date dateDebutSql = listeAbonnements.getDate("dateDebut");
                abonnement.setDateDebut(dateDebutSql != null ? new java.util.Date(dateDebutSql.getTime()) : null);
                abonnement.setDateFin(listeAbonnements.getDate("dateFin") != null ? new java.util.Date(listeAbonnements.getDate("dateFin").getTime()) : null);
                abonnement.setId(UUID.fromString(id));

                abonnements.add(abonnement);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return abonnements;
    }


    @Override
    public void update(Abonnement abonnement) throws Exception {
        String sql = "UPDATE Abonnement SET nomService = ?, montantMensuel = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, abonnement.getNomService());
            stmt.setDouble(2, abonnement.getMontantMensuel());
            stmt.setString(3, abonnement.getId().toString());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Abonnement modifié avec succès !");
            } else {
                System.out.println("Aucun abonnement trouvé avec cet ID.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try (PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM Abonnement WHERE id = ?")) {
            stmt.setString(1, id.trim());
            stmt.executeUpdate();
            System.out.println("Opération de suppression effectuée !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Abonnement> findActiveAbonnement() throws Exception {
        return new ArrayList<>();
    }

    @Override
    public List<Abonnement> findByType(String typeAbonnement) throws Exception {
        return Collections.emptyList();
    }
}
