import java.util.ArrayList;

interface ISubject {
    void registerObserver(IObserver obs);
    void removeObserver(IObserver obs);
    void notifyDisplays();
}

interface IObserver {
    void update(String weather);
}

class WeatherStation implements ISubject {
    private ArrayList<IObserver> observers = new ArrayList<>();
    private String weather;

    public void setWeather(String weather) {
        this.weather = weather;
        notifyDisplays();
    }

    @Override
    public void registerObserver(IObserver obs) {
        observers.add(obs);
    }
    @Override
    public void removeObserver(IObserver obs) {
        observers.remove(obs);
    }
    @Override
    public void notifyDisplays() {
        System.out.println("Notifying displays about weather change to: " + weather);
        for (IObserver iObserver : observers) {
            iObserver.update(weather);
        }
    }
}

class WeatherDisplay implements IObserver {
    private String city;

    public WeatherDisplay(String city) {
        this.city = city;
    }
    @Override
    public void update(String weather) {
        System.out.println(city + " received WeatherStation update. New weather: " + weather);
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation subject = new WeatherStation();
        IObserver obs = new WeatherDisplay("Taipei");
        subject.registerObserver(obs);
        subject.setWeather("Cold"); // 顯示 "Taipei received WeatherStation update. New weather: Cold "
        subject.removeObserver(obs);
    }
}
// import java.util.ArrayList;

// interface ISubject {
// void registerObserver(IObserver iObserver);
// void removeObserver(IObserver iObserver);
// void notifyDisplays();
// }

// interface IObserver {
// void update();
// }

// class WeatherStation implements ISubject {
// private ArrayList<IObserver> iObservers = new ArrayList<>();
// private String weather;

// public String getWeather() { return weather; }
// public void setWeather(String weather) {
// this.weather = weather;
// notifyDisplays();
// }

// @Override
// public void registerObserver(IObserver iObserver) {
// iObservers.add(iObserver);
// }
// @Override
// public void removeObserver(IObserver iObserver) {
// iObservers.remove(iObserver);
// }
// @Override
// public void notifyDisplays() {
// for (IObserver observer : iObservers) {
// observer.update();
// }
// }
// }

// class WeatherDisplay implements IObserver {
// private WeatherStation weatherStation;
// private String name;

// public WeatherDisplay(String name, WeatherStation weatherStation) {
// this.name = name;
// this.weatherStation = weatherStation;
// }
// @Override
// public void update() {
// System.out.println(name + " received WeatherStation update. New weather: " +
// weatherStation.getWeather());
// }
// }

// public class Main {
// public static void main(String[] args) {
// WeatherStation subject = new WeatherStation();
// IObserver obs = new WeatherDisplay("Taipei", subject);
// subject.registerObserver(obs);
// subject.setWeather("Cold"); // 顯示 "Taipei received WeatherStation update. New
// weather: Cold "
// subject.removeObserver(obs);
// }
// }