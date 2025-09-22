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
        this.id = UUID.randomUUID();
        this.nomService = nomService;
        this.montantMensuel = montantMensuel;
        this.statut =StatutAbonnement.ACTIVE;
    }

    public Abonnement(UUID id, String nomService, Double montantMensuel, Date dateDebut, Date dateFin, StatutAbonnement statut){
        this.id = id;
        this.nomService = nomService;
        this.montantMensuel = montantMensuel;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;

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

    public StatutAbonnement getStatut() {
        return statut;
    }

    public void setStatut(StatutAbonnement statut) {
        this.statut = statut;
    }

    public abstract String getTypeAbonnement();


}
