import java.util.*;

interface Observer {
    void update(double price);
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("Investor received update. New stock price: " + price);
    }
}

class StockMarket {
    private ArrayList<Observer> observers = new ArrayList<>();
    private double price;

    void register(Observer observer) {
        observers.add(observer);
    }

    void remove(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public void notifyInvestors() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        Investor Tom = new Investor("Tom");
        stock.register(Tom);
        stock.setPrice(100);
        stock.remove(Tom);
    }
}