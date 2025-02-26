package h25.msd.poo2;
//Lucas Blondeau

import h25.msd.poo2.client.Client;
import h25.msd.poo2.client.Commande;
import h25.msd.poo2.menu.Plat;

public class Restaurant {
    public final static double TAUX_TAXE = 0.15;


    private Commande[] commandes = new Commande[10]; //max 10 comandes à la fois


    public boolean commande(Plat[] items, Client client) { //msd vous pouvez changer cette signature
        for (int i = 0; i < commandes.length; i++) {
            if (commandes[i] == null) { // Ajoute la commande
                commandes[i] = new Commande(client);
                for (Plat item : items) {
                    commandes[i].ajouteItem(item); // Ajouter les items à la commande
                }
                return true;
            }
        }
        return false;
    }

    public void livreCommande(){
        //extraire les commandes, calculer les montants et les porter au compte du client.
        for (int i = 0; i < commandes.length; i++) {
            if (commandes[i] != null){
                Commande commande = commandes[i];
                double montant = commande.calculeMontantBrut();
                double rabais = commande.calculeRabais(montant);
                double taxes = (montant - rabais) * TAUX_TAXE;
                double montantFacture = montant - rabais + taxes;
                // ajoute le montant de facture au compte du client
                commande.factureMontantFinal(montantFacture);
            }
            commandes[i] = null;
        }
    }
}
