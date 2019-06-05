package warriors.engine;

import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;

public class GameState implements warriors.contracts.GameState {
    private String playerName;
    private GameStatus gameStatus;
    private Hero hero;
    private Map map;
    private String lastLog;
    private int currentCase;


    public GameState(String playerName,Hero hero, Map map) {
    this.playerName = playerName;
    this.hero = hero;
    this.map = map;
    this.lastLog = "Debut de partie";
    this.currentCase = 1;
    this.gameStatus = GameStatus.IN_PROGRESS;
    }


    @Override
    public String getGameId() {
        return "g6df54gdf654gdf64";
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public Map getMap() {
        return map;
    }

    public void setLastLog(String lastLog){
        this.lastLog = lastLog;
    }

    @Override
    public String getLastLog() {
        return lastLog;
    }

    @Override
    public int getCurrentCase() {
        return currentCase;
    }


    public void setCurrentCase(int currentCase) {
        this.currentCase = currentCase;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
