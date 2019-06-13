package warriors.engine;

public class Sort extends Surprise {
    /**
     *
     * @param name
     * @param pointsAttaque
     */
    public Sort (String name, int pointsAttaque){
        this.name=name;
        this.pointsAttaque = pointsAttaque;
        this.type = "sort";
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
        return "Votre sort est : " + name + ", il vous fait gagner " + pointsAttaque + " points d'attaque";
    }
}