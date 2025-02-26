package h25.msd.poo2.menu;
//Lucas Blondeau

public class RepasPrincipal extends Plat{
    public static final double RABAIS_POUR_SEUIL = 0.05;
    public static final double RABAIS_JOURNALIER = 0.03;

    private JoursSemaine joursSemaine;
    private double seuilRabais;

    public RepasPrincipal(String nom, double prix, JoursSemaine joursSemaine, double seuilRabais, double temperature) {
        super(nom, prix, temperature);
        this.joursSemaine = joursSemaine;
        this.seuilRabais = seuilRabais;
    }

    @Override
    public double calculeRabais(double montantTotal) {
        double rabaisRepas = 0;

        //rabais météo
        RabaisMeteo.rabaisMeteo(rabaisRepas, temperature, prix);

        // rabais de volume
        if (montantTotal > seuilRabais) {
            rabaisRepas += prix * RABAIS_POUR_SEUIL;
        }

        // rabais journalier
        if (joursSemaine.equals(JoursSemaine.JEUDI)
                || joursSemaine.equals(JoursSemaine.VENDREDI)) {
            rabaisRepas += prix * RABAIS_JOURNALIER;
        }
        return limiteRabais(rabaisRepas);
    }

}
