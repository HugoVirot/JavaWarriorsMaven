package warriors.client.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Connect;
import warriors.engine.Guerrier;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_QUITTER = "2";

    public static void main(String[] args) {
        Connect c = new Connect();
        try {
            Scanner sc = new Scanner(System.in);
            int saisie = 0;
            while (saisie != 6) {
                System.out.println("Que voulez-vous faire ? 1 : liste héros / 2 : afficher un héros / 3 : créer héros / 4 : modifier nom héros / 5 : supprimer héros / 6 : commencer une partie");
                saisie = sc.nextInt();
                if (saisie == 1) {
                    List<Hero> heroes = c.getHeroes();
                    int i = 0;
                    for (i = 0; i < heroes.size(); i++) {
                        System.out.println(heroes.get(i));
                        System.out.println("\n********************************");
                    }
                } else if (saisie == 2) {
                    System.out.println("saisissez l'id du héros choisi");
                    int id = sc.nextInt();
                    Hero h = c.getHero(id);
                    System.out.println(h);
                } else if (saisie == 3) {
                    System.out.println("Tapez les caractéristiques du nouveau héros");
                    System.out.println("id ?");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("type ?");
                    String type = sc.nextLine();
                    System.out.println("nom ?");
                    String nom = sc.nextLine();
                    sc.nextLine();
                    System.out.println("image ?");
                    String image = sc.nextLine();
                    System.out.println("niveau de vie ?");
                    int niveauDeVie = sc.nextInt();
                    System.out.println("force d'attaque ?");
                    int forceAttaque = sc.nextInt();
                    sc.nextLine();
                    System.out.println("moyen d'attaque ?");
                    String moyenAttaque = sc.nextLine();
                    System.out.println("moyen de défense ?");
                    String moyenDefense = sc.nextLine();

                    System.out.println("Votre héros : type : " + type + ", nom : " + nom + ", niveau de vie : " + niveauDeVie + ", attaque :" + forceAttaque + ", moyen d'attaque : " + moyenAttaque + ", moyen de défense : " + moyenDefense);
                    Guerrier nouveauGuerrier = new Guerrier(nom, image, niveauDeVie, forceAttaque, type, moyenAttaque, moyenDefense, id);
                    c.createHero(nouveauGuerrier);
                } else if (saisie == 4) {
                    sc.nextLine();
                    System.out.println("Tapez l'id du héros à modifier");
                    int id = sc.nextInt();
                    Guerrier h = c.getHero(id);
                    sc.nextLine();
                    System.out.println("Tapez le nouveau nom de ce héros");
                    String nouveauNom = sc.nextLine();
                    h.setNom(nouveauNom);
                    c.updateHero(h);
                } else if (saisie == 5) {
                    System.out.println("Tapez l'id du héros à supprimer");
                    int id = sc.nextInt();
                    Guerrier g = c.getHero(id);
                    System.out.println(g);
                    c.deleteHero(g);
                } else if (saisie == 6) {
                } else {
                    System.out.println("Saisie incorrecte !");
                }
            }
        } catch (
                Exception e) {
            System.err.println("Erreur \n" + e.getMessage());
        }

        WarriorsAPI warriors = new Warriors();
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("A bientot");
    }

    private static void startGame(WarriorsAPI warriors, Scanner sc) {
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

