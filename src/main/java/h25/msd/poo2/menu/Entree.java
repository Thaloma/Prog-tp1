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
        rabaisEntree = temperature < 0 ? -Math.max(-30, Math.min(temperature, 0)) * prix / 100.0f: 0;

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
