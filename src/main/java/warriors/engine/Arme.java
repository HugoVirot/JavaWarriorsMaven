package warriors.engine;

public class Arme extends Surprise {
    /**
     *
     * @param name
     * @param pointsAttaque
     */
    public Arme (String name, int pointsAttaque){
        this.name=name;
        this.pointsAttaque = pointsAttaque;
        this.type = "arme";
    }

    /**
     *
     * @return
     */
    @Override
    public int getPointsAttaque() {
        return super.getPointsAttaque();
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Votre arme est : " + name + ", elle t'apporte " + pointsAttaque + " points d'attaque";
    }
}
