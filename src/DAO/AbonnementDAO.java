package DAO;

import model.Abonnement;
import model.AbonnementAvecEngagement;

import java.util.List;

public interface AbonnementDAO {

    void create(AbonnementAvecEngagement abonnement) throws Exception;

    Abonnement findById(String id) throws Exception;

    List<Abonnement> findAll() throws Exception;

    void update(Abonnement abonnement) throws Exception;

    void delete(String id) throws Exception;

    List<Abonnement> findActiveAbonnement() throws Exception;

    List<Abonnement> findByType(String typeAbonnement) throws Exception;
}
