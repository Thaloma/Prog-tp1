package h25.msd.poo2.menu;

public class RabaisMeteo {

    public static double rabaisMeteo(double rabaisRepas, double temperature, double prix){
        rabaisRepas += temperature < 0 ? -Math.max(-30, Math.min(temperature, 0)) * prix / 100.0f: 0;

        return rabaisRepas;
    }
}
