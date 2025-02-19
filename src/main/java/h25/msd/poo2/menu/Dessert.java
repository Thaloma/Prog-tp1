package h25.msd.poo2.menu;
//Lucas Blondeau

public class Dessert extends Plat{
    public static final double RABAIS_JOURNALIER = 0.03;
    public static final double RABAIS_SOUPER = 0.04;

    private PeriodeJournee periodeJournee;
    private JoursSemaine joursSemaine;

    public Dessert(String nom, double prix, PeriodeJournee periodeJournee, JoursSemaine joursSemaine, double temperature) {
        super(nom, prix, temperature);
        this.periodeJournee = periodeJournee;
        this.joursSemaine = joursSemaine;
    }

    @Override
    public double calculeRabais(double montantTotal) {
        double rabaisDessert = 0;

        //rabais météo
        rabaisDessert = temperature < 0 ? -Math.max(-30, Math.min(temperature, 0)) * prix / 100.0f: 0;

        // rabais moment du jour
        if (periodeJournee.equals(PeriodeJournee.DINER)) {
            rabaisDessert += prix * RABAIS_SOUPER;
        }

        // rabais journalier
        if (joursSemaine.equals(JoursSemaine.LUNDI)
                || joursSemaine.equals(JoursSemaine.MARDI)) {
            rabaisDessert += prix * RABAIS_JOURNALIER;
        }
        return limiteRabais(rabaisDessert);
    }
}