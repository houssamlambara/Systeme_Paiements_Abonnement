package model;

import enums.StatutAbonnement;

import java.util.Date;
import java.util.UUID;

public abstract class Abonnement {
    private UUID id;
    private String nomService;
    private Double montantMensuel;
    private Date dateDebut;
    private Date dateFin;
    private StatutAbonnement statut = null;

    public Abonnement(String nomService, Double montantMensuel){
        this.nomService = nomService;
        this.montantMensuel = montantMensuel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public Double getMontantMensuel() {
        return montantMensuel;
    }

    public void setMontantMensuel(Double montantMensuel) {
        this.montantMensuel = montantMensuel;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
