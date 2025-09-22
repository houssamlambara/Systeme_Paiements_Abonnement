package model;

import enums.StatutAbonnement;
import java.util.Date;
import java.util.UUID;

public class AbonnementSansEngagement extends Abonnement {

    public AbonnementSansEngagement(String nomService, Double montantMensuel,
                                    Date dateDebut, Date dateFin, StatutAbonnement statut) {
        super(nomService, montantMensuel, dateDebut, dateFin, statut);
    }

    @Override
    public String getTypeAbonnement() {
        return "SansEngagement";
    }
}
