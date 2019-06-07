package warriors.engine;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import warriors.contracts.*;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warriors implements WarriorsAPI {
    private List<Hero> listeHeros;
    private List<Map> listeMap;
    warriors.engine.GameState gameState;
    int resultatDe;

    public Warriors() {
        //***********************************liste des héros************************************
        this.listeHeros = new ArrayList<Hero>();
        Hero nouveauHeros1 = new Guerrier("Benji", "benji.jpg", 10, 6);
        Hero nouveauHeros2 = new Guerrier("Toinou", "toinou.jpg", 8, 9);
        Hero nouveauHeros3 = new Magicien("Arthar", "arthur.jpg", 1, 1);
        Hero nouveauHeros4 = new Magicien("Hugo", "hugo.jpg", 4, 15);
        listeHeros.add(nouveauHeros1);
        listeHeros.add(nouveauHeros2);
        listeHeros.add(nouveauHeros3);
        listeHeros.add(nouveauHeros4);


        //*****************************initialisation liste maps et maps***************************************
        this.listeMap = new ArrayList<>();
        warriors.engine.Map nouvelleMap1 = new warriors.engine.Map("CampusMap", 64);


        //****************************************on définit les différents types de cases possibles**************************************
        Arme arc = new Arme("arc", 1);
        Case caseArc = new Case(arc);
        Arme massue = new Arme("massue", 3);
        Case caseMassue = new Case(massue);
        Arme epee = new Arme("épée", 5);
        Case caseEpee = new Case(epee);
        Sort eclair = new Sort("éclair", 2);
        Case caseEclair = new Case(eclair);
        Sort bouledefeu = new Sort("boule de feu", 7);
        Case caseBouleDeFeu = new Case(bouledefeu);
        Potion potionMineure = new Potion("potion mineure", 1);
        Case casePotionMineure = new Case(potionMineure);
        Potion potionStandard = new Potion("potion standard", 2);
        Case casePotionStandard = new Case(potionStandard);
        Potion potionGrande = new Potion("grande potion", 5);
        Case caseGrandePotion = new Case(potionGrande);
        Events vide = new Events();
        Case CaseVide = new Case(vide);


        //************************************récupération fichier json plateau1**********************************************

        Reader reader = null;
        try {
            reader = new FileReader("./src/main/resources/plateauJoueur.json");
            //System.out.println("fichier chargé");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g = new Gson();                                               //définit objet librairie Gson
        JsonObject plateauJoueur = g.fromJson(reader, JsonObject.class);   //récupération données json dans objet plateaujoueur
        warriors.engine.Map nouvelleMap = new warriors.engine.Map(plateauJoueur.get("name").getAsString(), plateauJoueur.get("numberOfCase").getAsInt()); //création map selon données plateau joueur

        JsonArray casesDuPlateau = plateauJoueur.get("casesPlateau").getAsJsonArray();   //récupérer tableau d'objets (jsonElement) contenant les propriétés des cases (numéro + objet)
        //System.out.println(casesDuPlateau);
        ArrayList casesDuPlateauListe = new ArrayList<>();


        //************************************récupération fichier json plateau2**********************************************

        Reader reader2 = null;
        try {
            reader2 = new FileReader("./src/main/resources/plateauJoueur2.json");
            //System.out.println("fichier chargé");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g2 = new Gson();                                               //définit objet librairie Gson
        JsonObject plateauJoueur2 = g2.fromJson(reader2, JsonObject.class);   //récupération données json dans objet plateaujoueur
        warriors.engine.Map nouvelleMap2 = new warriors.engine.Map(plateauJoueur2.get("name").getAsString(), plateauJoueur2.get("numberOfCase").getAsInt()); //création map selon données plateau joueur

        JsonArray casesDuPlateau2 = plateauJoueur2.get("casesPlateau").getAsJsonArray();   //récupérer tableau d'objets (jsonElement) contenant les propriétés des cases (numéro + objet)
        //System.out.println(casesDuPlateau);
        ArrayList casesDuPlateauListe2 = new ArrayList<>();


        //************************************récupération fichier json plateau de base**********************************************

        Reader reader3 = null;
        try {
            reader3 = new FileReader("./src/main/resources/plateauReference.json");
            //System.out.println("fichier chargé");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g3 = new Gson();                                               //définit objet librairie Gson
        JsonObject plateauJoueur3 = g3.fromJson(reader3, JsonObject.class);   //récupération données json dans objet plateaujoueur
        warriors.engine.Map nouvelleMap3 = new warriors.engine.Map(plateauJoueur3.get("name").getAsString(), plateauJoueur3.get("numberOfCase").getAsInt()); //création map selon données plateau joueur

        JsonArray casesDuPlateau3 = plateauJoueur3.get("casesPlateau").getAsJsonArray();   //récupérer tableau d'objets (jsonElement) contenant les propriétés des cases (numéro + objet)
        //System.out.println(casesDuPlateau);
        ArrayList casesDuPlateauListe3 = new ArrayList<>();




        //**********************************boucle qui remplit le plateau 1*********************************************
        for (int i = 0; i < plateauJoueur.get("numberOfCase").getAsInt(); i++) {

            JsonObject contenuCase;          //création variable qui va contenir les infos de la case
            contenuCase = (JsonObject)casesDuPlateau.get(i);        //ajout dans cette variable des infos de la case i du jsonarray
            casesDuPlateauListe.add(contenuCase);           //ajout de ces infos dans l'arraylist
            String nomEvenement = (((JsonObject)contenuCase.get("event")).get("name").getAsString());
            //System.out.println(contenuCase);
            //créer la case en fonction de l'évènement
            if (nomEvenement.equals("arc")) {
                nouvelleMap.addToPlateau(caseArc, i);
            }
            else if (nomEvenement.equals("massue")){
                nouvelleMap.addToPlateau(caseMassue, i);
            }
            else if (nomEvenement.equals("épée")){
                nouvelleMap.addToPlateau(caseEpee, i);
            }
            else if (nomEvenement.equals("éclair")) {
                nouvelleMap.addToPlateau(caseEclair, i);
            }
            else if (nomEvenement.equals("boule de feu")){
                nouvelleMap.addToPlateau(caseBouleDeFeu, i);
            }
            else if (nomEvenement.equals("potion mineure")){
                nouvelleMap.addToPlateau(casePotionMineure, i);
            }
            else if (nomEvenement.equals("potion standard")){
                nouvelleMap.addToPlateau(casePotionStandard, i);
            }
            else if (nomEvenement.equals("grande potion")) {
                nouvelleMap.addToPlateau(caseGrandePotion, i);
            }
            else if ((nomEvenement.equals("gobelin"))){
                nouvelleMap.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), i);
            }
            else if ((nomEvenement.equals("sorcier"))){
                nouvelleMap.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), i);
            }
            else if ((nomEvenement.equals("dragon"))){
                nouvelleMap.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), i);
            }
            else{
                nouvelleMap.addToPlateau(CaseVide, i);
            }
        }

        listeMap.add(nouvelleMap);

        //**********************************boucle qui remplit le plateau 2*********************************************
        for (int i = 0; i < plateauJoueur2.get("numberOfCase").getAsInt(); i++) {

            JsonObject contenuCase;          //création variable qui va contenir les infos de la case
            contenuCase = (JsonObject)casesDuPlateau2.get(i);        //ajout dans cette variable des infos de la case i du jsonarray
            casesDuPlateauListe2.add(contenuCase);           //ajout de ces infos dans l'arraylist
            String nomEvenement = (((JsonObject)contenuCase.get("event")).get("name").getAsString());
            //System.out.println(contenuCase);
            //créer la case en fonction de l'évènement
            if (nomEvenement.equals("arc")) {
                nouvelleMap2.addToPlateau(caseArc, i);
            }
            else if (nomEvenement.equals("massue")){
                nouvelleMap2.addToPlateau(caseMassue, i);
            }
            else if (nomEvenement.equals("épée")){
                nouvelleMap2.addToPlateau(caseEpee, i);
            }
            else if (nomEvenement.equals("éclair")) {
                nouvelleMap2.addToPlateau(caseEclair, i);
            }
            else if (nomEvenement.equals("boule de feu")){
                nouvelleMap2.addToPlateau(caseBouleDeFeu, i);
            }
            else if (nomEvenement.equals("potion mineure")){
                nouvelleMap2.addToPlateau(casePotionMineure, i);
            }
            else if (nomEvenement.equals("potion standard")){
                nouvelleMap2.addToPlateau(casePotionStandard, i);
            }
            else if (nomEvenement.equals("grande potion")) {
                nouvelleMap2.addToPlateau(caseGrandePotion, i);
            }
            else if ((nomEvenement.equals("gobelin"))){
                nouvelleMap2.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), i);
            }
            else if ((nomEvenement.equals("sorcier"))){
                nouvelleMap2.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), i);
            }
            else if ((nomEvenement.equals("dragon"))){
                nouvelleMap2.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), i);
            }
            else{
                nouvelleMap2.addToPlateau(CaseVide, i);
            }
        }

        listeMap.add(nouvelleMap2);

        //**********************************boucle qui remplit le plateau de base*********************************************
        for (int i = 0; i < plateauJoueur3.get("numberOfCase").getAsInt(); i++) {

            JsonObject contenuCase;          //création variable qui va contenir les infos de la case
            contenuCase = (JsonObject)casesDuPlateau3.get(i);        //ajout dans cette variable des infos de la case i du jsonarray
            casesDuPlateauListe3.add(contenuCase);           //ajout de ces infos dans l'arraylist
            String nomEvenement = (((JsonObject)contenuCase.get("event")).get("name").getAsString());
            //System.out.println(contenuCase);
            //créer la case en fonction de l'évènement
            if (nomEvenement.equals("arc")) {
                nouvelleMap3.addToPlateau(caseArc, i);
            }
            else if (nomEvenement.equals("massue")){
                nouvelleMap3.addToPlateau(caseMassue, i);
            }
            else if (nomEvenement.equals("épée")){
                nouvelleMap3.addToPlateau(caseEpee, i);
            }
            else if (nomEvenement.equals("éclair")) {
                nouvelleMap3.addToPlateau(caseEclair, i);
            }
            else if (nomEvenement.equals("boule de feu")){
                nouvelleMap3.addToPlateau(caseBouleDeFeu, i);
            }
            else if (nomEvenement.equals("potion mineure")){
                nouvelleMap3.addToPlateau(casePotionMineure, i);
            }
            else if (nomEvenement.equals("potion standard")){
                nouvelleMap3.addToPlateau(casePotionStandard, i);
            }
            else if (nomEvenement.equals("grande potion")) {
                nouvelleMap3.addToPlateau(caseGrandePotion, i);
            }
            else if ((nomEvenement.equals("gobelin"))){
                nouvelleMap3.addToPlateau(new Case(new Ennemi("gobelin", 1, 6)), i);
            }
            else if ((nomEvenement.equals("sorcier"))){
                nouvelleMap3.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), i);
            }
            else if ((nomEvenement.equals("dragon"))){
                nouvelleMap3.addToPlateau(new Case(new Ennemi("dragon", 4, 15)), i);
            }
            else{
                nouvelleMap3.addToPlateau(CaseVide, i);
            }
        }

        listeMap.add(nouvelleMap3);

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
        nouvelleMap1.addToPlateau(casePotionStandard, 31);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 32);
        nouvelleMap1.addToPlateau(casePotionMineure, 33);
        nouvelleMap1.addToPlateau(CaseVide, 34);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 35);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 36);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 37);
        nouvelleMap1.addToPlateau(caseMassue, 38);
        nouvelleMap1.addToPlateau(casePotionStandard, 39);
        nouvelleMap1.addToPlateau(new Case(new Ennemi("sorcier", 2, 9)), 40);
        nouvelleMap1.addToPlateau(caseGrandePotion, 41);
        nouvelleMap1.addToPlateau(caseEpee, 42);
        nouvelleMap1.addToPlateau(casePotionStandard, 43);
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

//        listeMap.add(nouvelleMap1);
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
        resultatDe = lancerDe();
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

            System.out.println("niveau d'attaque : " + hero.getAttackLevel() + "  --" + " niveau de vie : " + hero.getLife());

            if ("ennemi".equals(caseActuelle.getEvent().getType())) {
                Events ennemi = caseActuelle.getEvent();
                message = message + "\nVous etes sur une case ennemi : c'est un " + ennemi.getName() + " il a " + ennemi.getPointsDeVie() + " points de vie et " + ennemi.getPointsAttaque() + " points d'attaque";

                ennemi.setPointsDeVie(ennemi.getPointsDeVie() - hero.getAttackLevel());
                message = message + "\nVous frappez l'ennemi et il perd " + hero.getAttackLevel() + " points de vie";
                if (ennemi.getPointsDeVie() - hero.getAttackLevel() <= 0) {
                    message = message + "\nVous avez tue " + ennemi.getName();
                    Events vide = new Events();
                    Case caseVide = new Case(vide);
                    ((warriors.engine.Map) plateau).addToPlateau(caseVide, gameState.getCurrentCase());
                    System.out.println("point d'arret");
                } else {
                    ((LocalHero) hero).setNiveauVie(hero.getLife() - ennemi.getPointsAttaque());
                    message = message + "\nVous etes dans un sale etat ! Le " + ennemi.getName() + " vous a inflige " + ennemi.getPointsAttaque() + ", il part en courant !";
                }

            } else if ("potion".equals(caseActuelle.getEvent().getType())) {
                Events potion = caseActuelle.getEvent();
                message = message + "\nVous etes sur une case potion, c'est une " + potion.getName() + ", elle vous rend " + potion.getPointsDeVie() + " points de vie";
                ((LocalHero) hero).setNiveauVie(hero.getLife() + potion.getPointsDeVie());
                if (hero.getLife() > ((LocalHero) hero).getMaxLife()) {
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
                    if (hero.getAttackLevel() > ((LocalHero) hero).getMaxAttack()) {
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
                    if (hero.getAttackLevel() > ((LocalHero) hero).getMaxAttack()) {
                        ((LocalHero) hero).setNiveauAttaque(((LocalHero) hero).getMaxAttack());
                        message = message + "\nVotre niveau d'attaque est au maximum !";
                    }
                } else {
                    message = message + "\nVous etes sur une case sort, c'est un(e) " + sort.getName() + ", il (elle) vous est inutile";
                }
            }
            if (hero.getLife() == 0) {
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
