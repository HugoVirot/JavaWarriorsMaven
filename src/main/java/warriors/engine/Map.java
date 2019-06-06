package warriors.engine;

import java.util.ArrayList;
import java.util.List;

public class Map implements warriors.contracts.Map {
    private String name;
    private int numberOfCase;
    private List<Case> casesPlateau;

    public Map(String name, int numberOfCase) {
        this.name = name;
        this.numberOfCase = numberOfCase;
        this.casesPlateau = new ArrayList<>();
    }

    public void addToPlateau(Case uneCase, int index) {
        casesPlateau.add(index, uneCase);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Case> getPlateau() {
        return casesPlateau;
    }

    public Case getCasePlateau(int index) {
        return casesPlateau.get(index);
    }

    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    public Case getNameCase(int i) {
        return casesPlateau.get(i);
    }

}


