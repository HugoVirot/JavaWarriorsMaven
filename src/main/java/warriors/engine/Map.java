package warriors.engine;

import java.util.ArrayList;
import java.util.List;

public class Map implements warriors.contracts.Map {
    private String name;
    private int numberOfCase;
    private List<Case> casePlateau;

    public Map(String name, int numberOfCase) {
        this.name = name;
        this.numberOfCase = numberOfCase;
        this.casePlateau = new ArrayList<>();
    }

    public void addToPlateau(Case uneCase, int index) {
        casePlateau.add(index, uneCase);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Case> getPlateau() {
        return casePlateau;
    }

    public Case getCasePlateau(int index) {
        return casePlateau.get(index);
    }

    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    public Case getNameCase(int i) {
        return casePlateau.get(i);
    }

}


