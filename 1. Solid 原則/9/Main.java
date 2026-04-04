interface Loggable {
    void log(String message);
}

interface Notifiable {
    void sendNotification(String message);
}

class ConsoleLogger implements Loggable {
    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

class EmailNotifierV2 implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("發送郵件: " + message);
    }

}

class Main {
    public static void main(String[] args) {
        Loggable l = new ConsoleLogger();
        l.log("message");

        Notifiable n = new EmailNotifierV2();
        n.sendNotification("message");
    }

}