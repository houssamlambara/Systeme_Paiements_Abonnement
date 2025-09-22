package DAO;

import config.Connexion;
import model.Abonnement;
import model.AbonnementAvecEngagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbonnementDAOImpl implements AbonnementDAO {

    private Connection connection;

    public AbonnementDAOImpl() throws Exception{
        this.connection = Connexion.getInstance().getConnection();
    }

    @Override
    public void create(Abonnement abonnement) throws Exception {

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
