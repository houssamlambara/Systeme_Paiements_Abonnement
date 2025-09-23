package DAO;

import config.Connexion;
import model.Abonnement;
import model.AbonnementAvecEngagement;
import model.AbonnementSansEngagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            stmt.setDate(5, abonnement.getDateFin() != null ? new java.sql.Date(abonnement.getDateFin().getTime()) : null);
            stmt.setString(6, abonnement.getStatut().name());
            stmt.setString(7, abonnement.getTypeAbonnement());
            stmt.setInt(8, 0);
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
    public List<Abonnement> findAll() throws Exception{
        return new ArrayList<>();
    }

    @Override
    public void update(Abonnement abonnement) throws Exception{

    }

    @Override
    public void delete(String id) throws Exception{

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
