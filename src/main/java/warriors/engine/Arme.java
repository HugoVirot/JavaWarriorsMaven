package warriors.engine;

public class Arme extends Surprise {

    public Arme (String name, int pointsAttaque){
        this.name=name;
        this.pointsAttaque = pointsAttaque;
        this.type = "arme";
    }

    @Override
    public int getPointsAttaque() {
        return super.getPointsAttaque();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Votre arme est : " + name + ", elle t'apporte " + pointsAttaque + " points d'attaque";
    }
}
