package warriors.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scenario {

    protected ArrayList scenario;
    protected int index;

    public Scenario() {

    }

    public Scenario(ArrayList scenario) {
        this.scenario = scenario;
        this.index = 0;
    }

    public int lancerD() {
        int valeurD = 0;
        if (scenario == null) {
            Random rand = new Random();
            valeurD = rand.nextInt(6) + 1;
        }else{
            valeurD = Integer.parseInt(String.valueOf(scenario.get(index)));
            index++;
        }
        return valeurD;
    }
}