import java.util.ArrayList;

interface ISubject {
    void registerObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyPlayers();
}

interface IObserver {
    void update();
}

class Game implements ISubject {
    private ArrayList<IObserver> iObservers = new ArrayList<>();
    private String achievement;

    public String getAchievement() { return achievement; }
    public void setAchievement(String achievement) {
        this.achievement = achievement;
        notifyPlayers();
    }

    @Override
    public void registerObserver(IObserver iObserver) {
        iObservers.add(iObserver);
    }
    @Override
    public void removeObserver(IObserver iObserver) {
        iObservers.remove(iObserver);
    }
    @Override
    public void notifyPlayers() {
        for (IObserver io : iObservers) {
            io.update();
        }
    }
}

class Player implements IObserver {
    private Game game;
    private String name;

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Player received update. New Tutorial Completed achievement: " + game.getAchievement());
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        IObserver obs = new Player(game, "Mary");
        game.registerObserver(obs);
        game.setAchievement("Level 2"); // Player received update from Game New Completed achievement: Level 2
        game.removeObserver(obs);
    }
}