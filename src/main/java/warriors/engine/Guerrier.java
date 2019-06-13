package warriors.engine;

public class Guerrier extends LocalHero {
    public static final int MAXLIFE = 10;
    public static final int MAXATTACK = 10;

    public Guerrier(String nom, String image, int niveauDeVie, int forceAttaque){
        super(nom, image, niveauDeVie, forceAttaque);
    }

    public Guerrier(String nom, String image, int niveauDeVie, int forceAttaque, String type, String moyenAttaque, String moyenDefense, int id) {
        super(nom, image, niveauDeVie, forceAttaque, type, moyenAttaque, moyenDefense, id);
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
