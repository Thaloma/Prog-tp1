package h25.msd.poo2;

import h25.msd.poo2.client.Client;
import h25.msd.poo2.menu.*;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Client client = new Client("George");

        Dessert dessert = new Dessert("pouding",3.45, PeriodeJournee.DEJEUNER, JoursSemaine.MARDI,34);
        Entree entree = new Entree("soupe", 5.49,PeriodeJournee.DEJEUNER,15,45);
        Plat[] items = new Plat[]{dessert, entree};

        if(restaurant.commande(items, client)){
            System.out.println("La comande de " +client.getNom()+ " est passée");
        }

        restaurant.livreCommande();

    }
}
