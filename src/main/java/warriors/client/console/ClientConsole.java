package warriors.client.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Scenario;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_QUITTER = "2";

    public static void main(String[] args) {
        ArrayList nbreDList = new ArrayList<>();
        Scenario scenario;

        try {

            //List<ArrayList> listeScenario = new ArrayList<>();

            Scanner scanner = null;
            scanner = new Scanner(new File(args[0]));
            System.out.println("Scenario debug");
            Scanner dataScanner = null;
            ArrayList listScenar = new ArrayList();

            while (scanner.hasNextLine()) {
                String line = scanner.next();
                String[] valeurCase = line.split(",");
                for (int i = 0; i<valeurCase.length; i++){
                    listScenar.add(valeurCase);
                    System.out.println(valeurCase[i]);
                }
                System.out.println("===");
            }

            System.out.println("--------------------------------------------------------------");

           /* while (scanner.hasNextLine()) {
                dataScanner = new Scanner(scanner.nextLine());
                dataScanner.useDelimiter(",");
                while (dataScanner.hasNext()) {
                    String data = dataScanner.next();
                    nbreDList.add(data);
                }
            }
            */


            scanner.close();
            System.out.println(nbreDList);
            scenario = new Scenario(nbreDList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Jeu lancer sans scenario");

            scenario = new Scenario();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            scenario = new Scenario();
        }

        //------------------

        WarriorsAPI warriors = new Warriors();
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc, scenario);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("A bientot");
    }

    private static void startGame(WarriorsAPI warriors, Scanner sc, Scenario scenario) {
        System.out.println();
        System.out.println("Entrez votre nom:");
        String playerName = sc.nextLine();

        System.out.println("Choisissez votre hero:");
        for (int i = 0; i < warriors.getHeroes().size(); i++) {
            Hero heroe = warriors.getHeroes().get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);

        System.out.println("Choisissez votre map:");
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        //------
        ((warriors.engine.GameState) gameState).setScenario(scenario);

        String gameId = gameState.getGameId();
        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            System.out.println("\nAppuyer sur une touche pour lancer le D");

            sc.nextLine();
            gameState = warriors.nextTurn(gameId);

        }

        System.out.println(gameState.getLastLog());
    }

    private static String displayMenu(Scanner sc) {
        System.out.println();
        System.out.println("================== Java Warriors ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }

        return "";
    }
}