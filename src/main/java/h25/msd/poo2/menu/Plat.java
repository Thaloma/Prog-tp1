package h25.msd.poo2.menu;

public class Plat {
    private String nom;
    protected double prix;
    protected double temperature;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getTemperature() {
        return temperature;
    }

    public Plat(String nom, double prix, double temperature) {
        this.nom = nom;
        this.prix = prix;
        this.temperature = temperature;
    }

    public double calculeRabais(double montantTotal){
        return -1;
    }

    public double limiteRabais(double rabais) {
        assert rabais >= prix;
        assert rabais <= 0;
        return Math.min(prix, Math.max(0, rabais));
    }



}
