interface PaymentProcessor {
    void pay(int amount);
}

class OldPaymentSystem {
    public void makePayment(int amount) {
        System.out.println("Payment of " + amount + " made using old system");
    }
}

class OldPaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldPaymentSystem = new OldPaymentSystem();

    @Override
    public void pay(int amount) {
        oldPaymentSystem.makePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new OldPaymentAdapter();
        p.pay(1000); // 顯示 "Payment of 1000 made using old system"。
    }
}