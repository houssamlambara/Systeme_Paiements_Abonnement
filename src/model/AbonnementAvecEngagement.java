package model;

import enums.StatutAbonnement;
import java.util.Date;

public class AbonnementAvecEngagement extends Abonnement {
    private Integer dureeEngagementMois;

    public AbonnementAvecEngagement(String nomService, Double montantMensuel,
                                    Date dateDebut, Date dateFin, StatutAbonnement statut,
                                    Integer dureeEngagementMois) {
        super(nomService, montantMensuel, dateDebut, dateFin, statut);
        this.dureeEngagementMois = dureeEngagementMois;
    }

    public Integer getDureeEngagementMois() {
        return dureeEngagementMois;
    }

    public void setDureeEngagementMois(Integer dureeEngagementMois) {
        this.dureeEngagementMois = dureeEngagementMois;
    }

    @Override
    public String getTypeAbonnement() {
        return "AvecEngagement";
    }
}
