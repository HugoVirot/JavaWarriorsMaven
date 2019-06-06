package warriors.engine;

import warriors.contracts.*;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warriors implements WarriorsAPI {
    private List<Hero> listeHeros;
    private List<Map> listeMap;
    warriors.engine.GameState gameState;
    int resultatDe;

    public Warriors() {
        this.listeHeros = new ArrayList<Hero>();
        Hero nouveauHeros1 = new Guerrier("Benji", "benji.jpg", 10, 6);
        Hero nouveauHeros2 = new Guerrier("Toinou", "toinou.jpg", 8, 9);
        Hero nouveauHeros3 = new Magicien("Arthar", "arthur.jpg", 1, 1);
        Hero nouveauHeros4 = new Magicien("Hugo", "hugo.jpg", 4, 15);
        listeHeros.add(nouveauHeros1);
        listeHeros.add(nouveauHeros2);
        listeHeros.add(nouveauHeros3);
        listeHeros.add(nouveauHeros4);


        this.listeMap = new ArrayList<>();
        warriors.engine.Map nouvelleMap1 = new warriors.engine.Map("CampusMap", 64);

        Arme arc = new Arme("arc", 1);
        Case caseArc = new Case(arc);
        Arme massue = new Arme("massue", 3);
        Case caseMassue = new Case(massue);
        Arme epee = new Arme("epee", 5);
        Case caseEpee = new Case(epee);
        Sort eclair = new Sort("eclair", 2);
        Case caseEclair = new Case(eclair);
        Sort bouledefeu = new Sort("boule de feu", 7);
        Case caseBouleDeFeu = new Case(bouledefeu);
        Potion potionMineure = new Potion("potion mineure", 1);
        Case casePotionMineure = new Case(potionMineure);
        Potion potionStandard = new Potion("potion standard", 2);
        Case casePotionstandard = new Case(potionStandard);
        Potion potionGrande = new Potion("grande potion", 5);
        Case caseGrandePotion = new Case(potionGrande);

        Events vide = new Events();
        Case CaseVide = new Case(vide);

        nouvelleMap1.addToPlateau(CaseVide, 0);
        nouvelleMap1.addToPlateau(caseEclair, 1);
        nouvelleMap1.addToPlateau(caseArc, 2);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 3);
        nouvelleMap1.addToPlateau(caseEclair, 4);
        nouvelleMap1.addToPlateau(caseMassue, 5);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 6);
        nouvelleMap1.addToPlateau(casePotionMineure, 7);
        nouvelleMap1.addToPlateau(caseEclair, 8);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 9);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 10);
        nouvelleMap1.addToPlateau(caseArc, 11);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 12);
        nouvelleMap1.addToPlateau(casePotionMineure, 13);
        nouvelleMap1.addToPlateau(caseArc, 14);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 15);
        nouvelleMap1.addToPlateau(CaseVide, 16);
        nouvelleMap1.addToPlateau(caseEclair, 17);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 18);
        nouvelleMap1.addToPlateau(caseArc, 19);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 20);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 21);
        nouvelleMap1.addToPlateau(caseMassue, 22);
        nouvelleMap1.addToPlateau(caseEclair, 23);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 24);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 25);
        nouvelleMap1.addToPlateau(caseArc, 26);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 27);
        nouvelleMap1.addToPlateau(casePotionMineure, 28);
        nouvelleMap1.addToPlateau(casePotionMineure, 29);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), 30);
        nouvelleMap1.addToPlateau(casePotionstandard, 31);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 32);
        nouvelleMap1.addToPlateau(casePotionMineure, 33);
        nouvelleMap1.addToPlateau(CaseVide, 34);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 35);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 36);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 37);
        nouvelleMap1.addToPlateau(caseMassue, 38);
        nouvelleMap1.addToPlateau(casePotionstandard, 39);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 40);
        nouvelleMap1.addToPlateau(caseGrandePotion, 41);
        nouvelleMap1.addToPlateau(caseEpee, 42);
        nouvelleMap1.addToPlateau(casePotionstandard, 43);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 44);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), 45);
        nouvelleMap1.addToPlateau(CaseVide, 46);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 47);
        nouvelleMap1.addToPlateau(caseBouleDeFeu, 48);
        nouvelleMap1.addToPlateau(caseBouleDeFeu, 49);
        nouvelleMap1.addToPlateau(CaseVide, 50);
        nouvelleMap1.addToPlateau(CaseVide, 51);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), 52);
        nouvelleMap1.addToPlateau(caseEpee, 53);
        nouvelleMap1.addToPlateau(CaseVide, 54);
        nouvelleMap1.addToPlateau(CaseVide, 55);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), 56);
        nouvelleMap1.addToPlateau(CaseVide, 57);
        nouvelleMap1.addToPlateau(CaseVide, 58);
        nouvelleMap1.addToPlateau(CaseVide, 59);
        nouvelleMap1.addToPlateau(CaseVide, 60);
        nouvelleMap1.addToPlateau(CaseVide, 61);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), 62);
        nouvelleMap1.addToPlateau(CaseVide, 63);
        nouvelleMap1.addToPlateau(CaseVide, 64);

        listeMap.add(nouvelleMap1);
    }

    @Override
    public List<Hero> getHeroes() {
        return listeHeros;
    }

    @Override
    public List<Map> getMaps() {
        return listeMap;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        gameState = new warriors.engine.GameState(playerName, hero, map);
        return gameState;
    }

    @Override
    public GameState nextTurn(String gameID) {
        Map plateau = gameState.getMap();
        String message = "";

        resultatDe = gameState.getScenario().lancerD();




        //resultatDe = lancerDe();
        // Scenario resultatDe = new Scenario();

        Hero hero = gameState.getHero();
        message = message + "Vous avez fait un " + resultatDe;

        gameState.setCurrentCase(gameState.getCurrentCase() + resultatDe);

        message = message + " et vous etes sur la case " + gameState.getCurrentCase();

        if (gameState.getCurrentCase() >= gameState.getMap().getNumberOfCase()) {
            gameState.setCurrentCase(gameState.getMap().getNumberOfCase());
            gameState.setLastLog("Vous avez fait un " + resultatDe + " et vous etes sur la case " + gameState.getCurrentCase() + ", VICTOIRE !!!");
            gameState.setGameStatus(GameStatus.FINISHED);
        } else {
            Case caseActuelle = plateau.getCasePlateau(gameState.getCurrentCase());
            //System.out.println(gameState.getHero());
            String result = " ";

            System.out.println(  "niveau d'attaque : " + hero.getAttackLevel() +"  --"+ " niveau de vie : " + hero.getLife());

            if ("ennemi".equals(caseActuelle.getEvent().getType())) {
                Events ennemi = caseActuelle.getEvent();
                message = message + "\nVous etes sur une case ennemi : c'est un " + ennemi.getName() + " il a " + ennemi.getPointsDeVie() + " points de vie et " + ennemi.getPointsAttaque() + " points d'attaque";

                ennemi.setPointsDeVie(ennemi.getPointsDeVie() - hero.getAttackLevel());
                message = message + "\nVous frappez l'ennemi et il perd " +hero.getAttackLevel() + " points de vie";
                if (ennemi.getPointsDeVie() - hero.getAttackLevel() <= 0) {
                    message = message + "\nVous avez tue " + ennemi.getName();
                    Events vide = new Events();
                    Case caseVide = new Case(vide);
                    ((warriors.engine.Map)plateau).addToPlateau(caseVide,gameState.getCurrentCase());
                    System.out.println("point d'arret");
                } else {
                    ((LocalHero) hero).setNiveauVie(hero.getLife()- ennemi.getPointsAttaque());
                    message = message + "\nVous etes dans un sale etat le " + ennemi.getName() + " vous a inflige " + ennemi.getPointsAttaque() + ", il part en courant !";
                }

            } else if ("potion".equals(caseActuelle.getEvent().getType())) {
                Events potion = caseActuelle.getEvent();
                message = message + "\nVous etes sur une case potion, c'est une " + potion.getName() + ", elle vous rend " + potion.getPointsDeVie() + " points de vie";
                ((LocalHero) hero).setNiveauVie(hero.getLife() + potion.getPointsDeVie());
                if (hero.getLife() > ((LocalHero) hero).getMaxLife()){
                    ((LocalHero) hero).setNiveauVie(((LocalHero) hero).getMaxLife());
                    message = message + "\nVotre vie est au maximum !";
                }
            } else if ("arme".equals(caseActuelle.getEvent().getType())) {
                Arme arme = new Arme(caseActuelle.getEvent().getName(), caseActuelle.getEvent().getPointsAttaque());
                if (hero instanceof Guerrier) {
                    ((LocalHero) hero).deleteArme();
                    ((LocalHero) hero).setArme(arme);
                    message = message + "\nVous etes sur une case arme, c'est une " + arme.getName() + ", elle vous octroie +" + arme.getPointsAttaque() + " points d'attaque";
                    ((LocalHero) hero).setNiveauAttaque(hero.getAttackLevel() + arme.getPointsAttaque());
                    if (hero.getAttackLevel() > ((LocalHero) hero).getMaxAttack()){
                        ((LocalHero) hero).setNiveauAttaque(((LocalHero) hero).getMaxAttack());
                        message = message + "\nVotre niveau d'attaque est au maximum !";
                    }
                } else {
                    message = message + "\nVous etes sur une case arme, c'est une " + arme.getName() + ", elle vous est inutile";
                }
            } else if ("sort".equals(caseActuelle.getEvent().getType())) {
                Sort sort = new Sort(caseActuelle.getEvent().getName(), caseActuelle.getEvent().getPointsAttaque());
                if (hero instanceof Magicien) {
                    ((LocalHero) hero).deleteSort();
                    ((LocalHero) hero).setSort(sort);
                    message = message + "\nVous etes sur une case sort, c'est un " + sort.getName() + ", il vous octroie +" + sort.getPointsAttaque() + " points d'attaque";
                    ((LocalHero) hero).setNiveauAttaque(hero.getAttackLevel() + sort.getPointsAttaque());
                    if (hero.getAttackLevel() > ((LocalHero) hero).getMaxAttack()){
                        ((LocalHero) hero).setNiveauAttaque(((LocalHero) hero).getMaxAttack());
                        message = message + "\nVotre niveau d'attaque est au maximum !";
                    }
                } else {
                    message = message + "\nVous etes sur une case sort, c'est un(e) " + sort.getName() + ", il (elle) vous est inutile";
                }
            }
            if (hero.getLife()==0){
                this.gameState.setGameStatus(GameStatus.GAME_OVER);
                message = message + "\nVous etes mort ahahahah !!!!!";
            }
            gameState.setLastLog(message);
            //caseActuelle.getEvent().getType()
        }
        return gameState;
    }

    private int lancerDe() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
