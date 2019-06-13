package warriors.engine;

public class Guerrier extends LocalHero {
    public static final int MAXLIFE = 10;
    public static final int MAXATTACK = 10;
    public Guerrier(String nom, String image, int niveauDeVie, int forceAttaque) {
        super(nom,image,niveauDeVie,forceAttaque);
    }

    /**
     *
     * @return niveau max de la vie du héro
     */
    @Override
    public int getMaxLife() {
        return MAXLIFE;
    }

    /**
     *
     * @return niveau max de l'attaque du héro
     */
    @Override
    public int getMaxAttack() {
        return MAXATTACK;
    }
}
