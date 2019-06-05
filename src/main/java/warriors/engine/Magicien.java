package warriors.engine;

public class Magicien extends LocalHero {
    public static final int MAXLIFE = 6;
    public static final int MAXATTACK = 15;
    public Magicien(String nom, String image, int niveauDeVie, int forceAttaque) {
        super(nom,image,niveauDeVie,forceAttaque);
    }
    @Override
    public int getMaxLife() {
        return MAXLIFE;
    }

    @Override
    public int getMaxAttack() {
        return MAXATTACK;
    }
}
