package warriors.engine;

public class Sort extends Surprise {

    public Sort (String name, int pointsAttaque){
        this.name=name;
        this.pointsAttaque = pointsAttaque;
        this.type = "sort";
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
        return "Votre sort est : " + name + ", il vous fait gagner " + pointsAttaque + " points d'attaque";
    }
}