package model;

import enums.StatutPaiement;

import java.util.Date;
import java.util.UUID;

public class Paiement {
    private String idPaiement;
    private String idAbonnement;
    private Date dateEcheance;
    private Date datePaiement;
    private String typePaiement;
    private StatutPaiement statut = null;

    public Paiement(String idAbonnement, Date dateEcheance, String typePaiement){
        this.idPaiement = UUID.randomUUID().toString();
        this.idAbonnement = idAbonnement;
        this.dateEcheance = dateEcheance;
        this.typePaiement = typePaiement;
        this.statut = StatutPaiement.NON_PAYE;
    }

    public Paiement(String idPaiement, String idAbonnement, Date dateEcheance, Date datePaiement, String typePaiement, StatutPaiement statut) {
        this.idPaiement = idPaiement;
        this.idAbonnement = idAbonnement;
        this.dateEcheance = dateEcheance;
        this.datePaiement = datePaiement;
        this.typePaiement = typePaiement;
        this.statut = statut;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(String idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    public StatutPaiement getStatut() {
        return statut;
    }

    public void setStatut(StatutPaiement statut) {
        this.statut = statut;
    }
}
