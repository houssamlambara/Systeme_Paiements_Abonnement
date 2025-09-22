package DAO;


public interface AbonnementDAO {

    public void create();

    public void findById();

    public void findAll();

    public void update();

    public void delete();

    public void findActiveSubscriptions();

    public void findByType();
}
