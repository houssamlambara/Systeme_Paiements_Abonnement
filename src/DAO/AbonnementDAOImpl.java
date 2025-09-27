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
import java.util.stream.Collectors;

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
        return findAll().stream()                  // Stream pour parcourir tous les abonnements
                .filter(a -> a.getId().toString().equals(id))  // lambda pour filtrer
                .findFirst()              // Optional pour prendre le premier
                .orElse(null);            // si pas trouvé, retourne null
    }

    @Override
    public List<Abonnement> findAll() throws Exception {
        List<Abonnement> abonnements = new ArrayList<>();
        String sql = "SELECT * FROM Abonnement";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String type = rs.getString("typeAbonnement");
                Abonnement abonnement;
                if("AvecEngagement".equals(type)){
                    abonnement = new AbonnementAvecEngagement(
                            rs.getString("nomService"),
                            rs.getDouble("montantMensuel"),
                            rs.getDate("dateFin"),
                            rs.getInt("dureeEngagementMois")
                    );
                } else {
                    abonnement = new AbonnementSansEngagement(
                            rs.getString("nomService"),
                            rs.getDouble("montantMensuel")
                    );
                }
                abonnement.setId(UUID.fromString(rs.getString("id")));
                abonnement.setDateDebut(rs.getDate("dateDebut"));
                abonnement.setDateFin(rs.getDate("dateFin"));
                abonnements.add(abonnement);
            }
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
        return findAll().stream()
                .filter(a -> a.getTypeAbonnement().equals(typeAbonnement))
                .collect(Collectors.toList());
    }
}
