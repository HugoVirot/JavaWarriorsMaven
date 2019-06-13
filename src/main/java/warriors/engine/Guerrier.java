package warriors.engine;

public class Guerrier extends LocalHero {
    public static final int MAXLIFE = 10;
    public static final int MAXATTACK = 10;

    public Guerrier(String nom, String image, int niveauDeVie, int forceAttaque, int id) {
        super(nom, image, niveauDeVie, forceAttaque, id);
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
