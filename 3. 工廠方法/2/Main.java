
abstract class Sender {
    Tool tool;

    final void send(String msg) {
        tool = genSender();
        tool.sendMessage(msg);
    }

    abstract Tool genSender();
}

abstract class Tool {
    abstract void sendMessage(String msg);
}

class Email extends Tool {
    void sendMessage(String msg) {
        System.out.println("發送 Email: " + msg);
    }
}

class SMS extends Tool {
    void sendMessage(String msg) {
        System.out.println("發送 SMS: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Sender sender = new EmailSender();
        sender.send("Hello");
        sender = new SMSSender();
        sender.send("Hello");

    }
}