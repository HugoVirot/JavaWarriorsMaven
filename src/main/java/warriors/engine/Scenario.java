package warriors.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scenario {

    private ArrayList scenario;
    private int index;
    private Random rand;


    public Scenario() {
        this.rand = new Random();
        this.scenario = null;
    }

    /**
     *
     * @param scenario
     */
    public Scenario(ArrayList scenario) {
        this.rand = new Random();
        this.scenario = scenario;
        this.index = 0;
    }

    /**
     *
     * @return
     */
    public int lancerD() {
        int valeurD = 0;
        if (scenario == null) {
            valeurD = rand.nextInt(6) + 1;
        } else {
            valeurD = Integer.parseInt(String.valueOf(scenario.get(index)));
            index++;
        }
        return valeurD;
    }
}