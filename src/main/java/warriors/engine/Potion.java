package warriors.engine;

public class Potion extends Surprise{

    public Potion (String name, int pointsDeVie){
    this.name=name;
    this.pointsDeVie = pointsDeVie;
    this.type = "potion";
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
        return "C'est une " + name + " elle vous remet sur pieds ! + " + pointsDeVie + " points de vie" ;
    }
}