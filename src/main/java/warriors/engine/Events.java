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

    public Events(String name, int pointsAttaque, int pointsDeVie) {
        this.name = name;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public String getName() {
        return name;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public String getType() {
        return type;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    @Override
    public String toString() {
        return "ya R morray, t'as cru quoi";
    }
}