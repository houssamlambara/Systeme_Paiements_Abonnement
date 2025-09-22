package model;

import enums.StatutPaiement;

import java.util.Date;
import java.util.UUID;

public class Paiement {
    private UUID idPaiement;
    private UUID idAbonnement;
    private Date dateEcheance;
    private Date datePaiement;
    private String typePaiement;
    private StatutPaiement statut = null;

    public Paiement(UUID idAbonnement, Date datePaiement, Date dateEcheance, String typePaiement,StatutPaiement statut){
        this.idAbonnement = idAbonnement;
        this.dateEcheance = dateEcheance;
        this.datePaiement = datePaiement;
        this.typePaiement = typePaiement;
        this.statut = statut;
    }

    public UUID getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(UUID idPaiement) {
        this.idPaiement = idPaiement;
    }

    public UUID getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(UUID idAbonnement) {
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
