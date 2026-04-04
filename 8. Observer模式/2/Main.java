import java.util.ArrayList;

interface ISubject {
    void registerObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyDisplays();
}

interface IObserver {
    void update();
}

class WeatherStation implements ISubject {
    private ArrayList<IObserver> iObservers = new ArrayList<>();
    private String weather;

    public String getWeather() { return weather; }
    public void setWeather(String weather) {
        this.weather = weather;
        notifyDisplays();
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
    public void notifyDisplays() {
        for (IObserver observer : iObservers) {
            observer.update();
        }
    }
}

class WeatherDisplay implements IObserver {
    private WeatherStation weatherStation;
    private String name;

    public WeatherDisplay(String name, WeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {
        System.out.println(name + " received WeatherStation update. New weather: " + weatherStation.getWeather());
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation subject = new WeatherStation();
        IObserver obs = new WeatherDisplay("Taipei", subject);
        subject.registerObserver(obs);
        subject.setWeather("Cold"); // 顯示 "Taipei received WeatherStation update. New weather: Cold "
        subject.removeObserver(obs);
    }
}