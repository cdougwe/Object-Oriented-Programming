import java.util.ArrayList;

interface ISubject {
    void registerObserver(IObserver io);
    void removeObserver(IObserver io);
    void notifyShoppers();
    String getCommodity();
    double getPrice();
}

interface IObserver {
    void update(ISubject is);
}

interface IDisplayElement {
    void display();
}

class PriceTracker implements ISubject {
    private ArrayList<IObserver> iObservers = new ArrayList<>();
    private String commodity;
    private double price;

    public PriceTracker(String commodity) {
        this.commodity = commodity;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyShoppers();
    }

    @Override
    public String getCommodity() { return commodity; }
    @Override
    public double getPrice() { return price; }
    @Override
    public void registerObserver(IObserver io) {
        iObservers.add(io);
    }
    @Override
    public void removeObserver(IObserver io) {
        iObservers.remove(io);
    }
    @Override
    public void notifyShoppers() {
        for (IObserver io : iObservers) {
            io.update(this);
        }
    }
}

class Shopper implements IObserver, IDisplayElement {
    private String name, currentItem, className;
    private double currentPrice;

    public Shopper(String name) {
        this.name = name;
    }

    @Override
    public void update(ISubject is) {
        this.currentPrice = is.getPrice();
        this.currentItem = is.getCommodity();
        this.className = is.getClass().getSimpleName();
        this.display();
    }
    @Override
    public void display() {
        System.out.println(name + " received update from " + className + ". New " + currentItem + " price:" + (int) currentPrice);
    }

}

public class Main {
    public static void main(String[] args) {
        PriceTracker watermelonTracker = new PriceTracker("Watermelon");
        Shopper mary = new Shopper("Mary");

        watermelonTracker.registerObserver(mary);
        watermelonTracker.setPrice(25); // 預期輸出：Mary received update... New Watermelon price: 25.0

        PriceTracker appleTracker = new PriceTracker("Apple");
        appleTracker.registerObserver(mary);
        appleTracker.setPrice(15); // 預期輸出：Mary received update... New Apple price: 15.0
    }
}