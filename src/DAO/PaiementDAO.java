package DAO;

import model.Paiement;
import java.util.List;

public interface PaiementDAO {

    void create(Paiement paiement) throws Exception;

    Paiement findById(String id) throws Exception;

    List<Paiement> findByAbonnement(String idAbonnement) throws Exception;

    List<Paiement> findAll() throws Exception;

    void update(Paiement paiement) throws Exception;

    void delete(String id) throws Exception;

    List<Paiement> findUnpaidByAbonnement(String idAbonnement) throws Exception;

    List<Paiement> findLastPayments(int n) throws Exception;
}
