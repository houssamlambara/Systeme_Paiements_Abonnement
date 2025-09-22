package model;


public class AbonnementAvecEngagement extends Abonnement{
    private Integer dureeEngagementMois;

    public AbonnementAvecEngagement(String nomService, Double montantMensuel, Integer dureeEngagementMois) {
        super(nomService, montantMensuel);
        this.dureeEngagementMois = dureeEngagementMois;

    }

    public Integer getDureeEngagementMois() {
        return dureeEngagementMois;
    }

    public void setDureeEngagementMois(Integer dureeEngagementMois) {
        this.dureeEngagementMois = dureeEngagementMois;
    }
}
