package warriors.engine;

public class Case {
    private int numero;
    private Events event;

    public Case() {

    }

    public Case(Events event) {
        this.event = event;
    }

    public Events getEvent() {
        return event;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}