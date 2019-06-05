package warriors.engine;

public class Ennemi extends Events {
    public Ennemi(String name, int pointsAttaque, int pointsDeVie) {
        super(name, pointsAttaque, pointsDeVie);
        this.type = "ennemi";
    }

    @Override
    public int getPointsAttaque() {
        return super.getPointsAttaque();
    }

    @Override
    public int getPointsDeVie() {
        return super.getPointsDeVie();
    }



    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "C'est un " + name + " il a " + pointsAttaque + " points d'attaque et " + pointsDeVie + " points de vie";
    }
}
