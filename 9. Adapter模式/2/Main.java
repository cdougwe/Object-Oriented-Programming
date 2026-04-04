interface PaymentProcessor {
    void pay(double amount);
}

class OldPaymentSystem {
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using old system");
    }
}

class OldPaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldPaymentSystem = new OldPaymentSystem();

    public void pay(double amount) {
        oldPaymentSystem.makePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new OldPaymentAdapter();
        p.pay(10000); // 顯示 "Payment of 1000 made using old system"。
    }
}