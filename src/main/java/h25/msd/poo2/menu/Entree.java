package h25.msd.poo2.menu;
//Lucas Blondeau

public class Entree extends Plat{
    public static final double RABAIS_POUR_SEUIL = 0.05;
    public static final double RABAIS_DINER = 0.02;

    private PeriodeJournee periodeJournee;
    private double seuilRabais;

    public Entree(String nom, double prix, PeriodeJournee periodeJournee, double seuilRabais, double temperature) {
        super(nom, prix, temperature);
        this.periodeJournee = periodeJournee;
        this.seuilRabais = seuilRabais;
    }

    @Override
    public double calculeRabais(double montantTotal) {
        double rabaisEntree = 0;

        //rabais météo
        RabaisMeteo.rabaisMeteo(rabaisEntree, temperature, prix);

        // rabais de volume
        if (montantTotal > seuilRabais) {
            rabaisEntree += prix * RABAIS_POUR_SEUIL;
        }

        // rabais moment du jour
        if (periodeJournee.equals(PeriodeJournee.DINER)) {
            rabaisEntree += prix * RABAIS_DINER;
        }
        return limiteRabais(rabaisEntree);
    }
}
