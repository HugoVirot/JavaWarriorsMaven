package warriors.engine;

public class Potion extends Surprise{

    public Potion (String name, int pointsDeVie){
    this.name=name;
    this.pointsDeVie = pointsDeVie;
    this.type = "potion";
    }

    /**
     *
     * @return
     */
    @Override
    public int getPointsDeVie() {
        return super.getPointsDeVie();
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
        return "C'est une " + name + " elle vous remet sur pieds ! + " + pointsDeVie + " points de vie" ;
    }
}