package service;

public interface PaiementService {

    public void enregistrerPaiement();

    public void modifierPaiement();

    public void supprimerPaiement();

    public void obtenirPaiementsParAbonnement();

    public void detecterImpayes();

    public void montantTotalImpayes();

    public void genererRapportsFinanciers();

}
