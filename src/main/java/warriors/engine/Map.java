package warriors.engine;

import java.util.ArrayList;
import java.util.List;


public class Map implements warriors.contracts.Map {
    private String name;
    private int numberOfCase;
    private List<Case> casePlateau;

    /**
     *
     * @param name
     * @param numberOfCase
     */
    public Map(String name, int numberOfCase) {
        this.name = name;
        this.numberOfCase = numberOfCase;
        this.casePlateau = new ArrayList<>();
    }

    /**
     *
     * @param uneCase
     * @param index
     */

    public void addToPlateau(Case uneCase, int index) {
        casePlateau.add(index, uneCase);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public List<Case> getPlateau() {
        return casePlateau;
    }

    /**
     *
     * @param index
     * @return
     */
    public Case getCasePlateau(int index) {
        return casePlateau.get(index);
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    /**
     *
     * @param i
     * @return
     */
    public Case getNameCase(int i) {
        return casePlateau.get(i);
    }

}


