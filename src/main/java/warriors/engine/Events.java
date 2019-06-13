package warriors.engine;

public class Events {
    protected String name;
    protected int pointsDeVie;
    protected int pointsAttaque;
    protected String type;


    public Events(){
        this.name = "vide";
        this.type ="vide";
    }

    /**
     *
     * @param name
     * @param pointsAttaque
     * @param pointsDeVie
     */
    public Events(String name, int pointsAttaque, int pointsDeVie) {
        this.name = name;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
    }

    /**
     *
     * @return les points d'attaques du héro
     */
    public int getPointsAttaque() {
        return pointsAttaque;
    }

    /**
     *
     * @return le nom du héro
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return les points de vie du héro
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     *
     * @return la classe du héro
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param pointsDeVie
     */
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    @Override
    public String toString() {
        return "ya R morray, t'as cru quoi";
    }
}