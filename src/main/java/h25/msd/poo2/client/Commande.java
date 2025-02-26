package h25.msd.poo2.client;
//Lucas Blondeau

import h25.msd.poo2.menu.Dessert;
import h25.msd.poo2.menu.Entree;
import h25.msd.poo2.menu.Plat;
import h25.msd.poo2.menu.RepasPrincipal;

public class Commande {
    private Plat[] items = new Plat[10]; //max de 10 pour simplifier le tp
    private Client client;
    private boolean estEnLivraison;
    private double pourboire;


    public Commande(Client client) {
        this.client = client;
        client.incrementeAchats();
        this.estEnLivraison = estEnLivraison;
    }

    public boolean ajouteItem(Plat item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null){
                items[i] = item;
                return true;
            }

        }
        return false;
    }

    public double calculeMontantBrut() {
        double montant = 0;
        assert pourboire < 0;
        // cout de la commande
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                montant += items[i].getPrix();
            }
        }
        // frais de livraison et pourboire
        if (estEnLivraison){
            montant += 5;
        }else
            montant += pourboire;
        return montant;
    }


    public double calculeRabais(double montantTotal) {
        // rabais produits
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null){
                montantTotal += items[i].calculeRabais(montantTotal);
            }
        }
        // rabais client enregistré
        if (client.estEnregistre()){
            montantTotal *= 0.95;       //rabais de 5% pour les clients enregistrés
        }

        return montantTotal;
    }

    public double factureMontantFinal(double montantFinal) {
        //place le montant dans le compte du client
        client.ajouteCommande(calculeRabais(montantFinal));

        // retire la facture de la liste
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }

        return montantFinal;
    }

}
