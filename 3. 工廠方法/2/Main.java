interface Tool {
    void sendMessage(String msg);
}

abstract class Sender {
    Tool tool;

    final void send(String msg) {
        tool = genSender();
        tool.sendMessage(msg);
    }

    abstract Tool genSender();
}

class Email implements Tool {
    @Override
    public void sendMessage(String msg) {
        System.out.println("發送 Email: " + msg);
    }
}

class SMS implements Tool {
    @Override
    public void sendMessage(String msg) {
        System.out.println("發送 SMS: " + msg);
    }
}

class EmailSender extends Sender {
    @Override
    Tool genSender() {
        return new Email();
    }
}

class SMSSender extends Sender {
    @Override
    Tool genSender() {
        return new SMS();
    }
}

class SenderFactory {
    public Sender getSender(String type) {
        if (type.equals("Email")) {
            return new EmailSender();
        } else if (type.equals("SMS")) {
            return new SMSSender();
        } else throw new IllegalArgumentException("No such sending mode");
    }
}

public class Main {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.getSender("Email");
        sender.send("Hello");
        sender = senderFactory.getSender("SMS");
        sender.send("Hello");

    }
}