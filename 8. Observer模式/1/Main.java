import java.util.ArrayList;

interface ISubject {
    void register(IObserver iObserver);
    void remove(IObserver iObserver);
    void notifyInvestors();
}

interface IObserver {
    void update(double price);
}

class StockMarket implements ISubject {
    private ArrayList<IObserver> observers = new ArrayList<>();
    private double price;

    public double getPrice() { return price; }
    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }
    @Override
    public void register(IObserver iObserver) {
        observers.add(iObserver);
    }
    @Override
    public void remove(IObserver iObserver) {
        observers.remove(iObserver);
    }
    public void notifyInvestors() {
        System.out.println("Notifying investors about stock price change to: " + price);
        for (IObserver iObserver : observers) {
            iObserver.update(price);
        }
    }
}

class Investor implements IObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }
    public void update(double price) {
        System.out.println("Investor : " + name + " received update. New stock price: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        IObserver Tom = new Investor("Tom");
        stock.register(Tom);
        stock.setPrice(100);
        stock.remove(Tom);
    }
}