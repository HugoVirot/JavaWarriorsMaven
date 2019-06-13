package warriors.engine;

public class Case {
    private int numero;
    private Events event;

    public Case() {

    }

    /**
     *
     * @param event
     */
    public Case(Events event) {
        this.event = event;
    }

    /**
     *
     * @return
     */
    public Events getEvent() {
        return event;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return super.toString();
    }
}