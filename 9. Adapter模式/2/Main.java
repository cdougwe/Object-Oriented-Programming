interface PaymentTarget {
    void makePayment(double amount);
}

class OldPaymentProcessor {
    private OldPaymentSystem oldPaymentSystem;

    public OldPaymentProcessor(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }
    public void processPayment(double amount) {
        oldPaymentSystem.makePayment(amount);
    }
}

class OldPaymentSystem {
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using old system");
    }
}

class OldPaymentAdapter implements PaymentTarget {
    private OldPaymentSystem oldPaymentSystem = new OldPaymentSystem();

    @Override
    public void makePayment(double amount) {
        oldPaymentSystem.makePayment(amount);
    }
}

class PaymentProcessor {
    private PaymentTarget target;

    public PaymentProcessor(PaymentTarget target) {
        this.target = target;
    }
    public void pay(double amount) {
        target.makePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor(new OldPaymentAdapter());
        p.pay(10000);
    }
}
