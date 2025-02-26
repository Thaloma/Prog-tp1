package h25.msd.poo2.client;
//Lucas Blondeau

public class Client {
    private String nom;
    private double montantAchat;
    private int nombreAchats;
    private boolean estEnregistre;

    public Client(String nom) {
        this.nom = nom;
        this.montantAchat = 0.0;
        this.estEnregistre = false;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMontantAchat() {
        return montantAchat;
    }


    public void ajouteCommande(double montant) {
        montantAchat += montant;
    }

    public boolean estEnregistre() {
        return estEnregistre;
    }

    public void incrementeAchats(){
        nombreAchats++;
        if (nombreAchats >= 5){
            estEnregistre = true;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", montantAchat=" + montantAchat +
                '}';
    }
}
