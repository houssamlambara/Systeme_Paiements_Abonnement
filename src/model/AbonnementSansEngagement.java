package model;

import enums.StatutAbonnement;
import java.util.Date;
import java.util.UUID;

public class AbonnementSansEngagement extends Abonnement {

    public AbonnementSansEngagement(String nomService, Double montantMensuel) {
        super(nomService, montantMensuel);
        this.setDateDebut(new Date());
        this.setDateFin(new Date());
    }

    @Override
    public String getTypeAbonnement() {
        return "SansEngagement";
    }
}
