package DAO;

public interface PaiementDAO {

    public void create();

    public void findById();

    public void findByAbonnement();

    public void findAll();

    public void update();

    public void delete();

    public void findUnpaidByAbonnement();

    public void findLastPayments();
}
