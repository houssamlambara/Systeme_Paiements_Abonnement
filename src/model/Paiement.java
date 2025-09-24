package model;

import enums.StatutPaiement;
import enums.TypePaiement;

import java.util.Date;
import java.util.UUID;

public class Paiement {
    private UUID idPaiement;
    private String idAbonnement;
    private Date dateEcheance;
    private Date datePaiement;
    private TypePaiement typePaiement;
    private StatutPaiement statut;

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Paiement(String idAbonnement, Date dateEcheance, TypePaiement typePaiement){
        this.idPaiement = UUID.randomUUID();
        this.idAbonnement = idAbonnement;
        this.dateEcheance = dateEcheance;
        this.typePaiement = typePaiement;
        this.statut = StatutPaiement.PAYE;
        this.datePaiement = null;
    }

    public Paiement( String idAbonnement, Date dateEcheance, Date datePaiement, TypePaiement typePaiement, StatutPaiement statut) {
        this.idPaiement = UUID.randomUUID();
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

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public StatutPaiement getStatut() {
        return statut;
    }

    public void setStatut(StatutPaiement statut) {
        this.statut = statut;
    }
}
