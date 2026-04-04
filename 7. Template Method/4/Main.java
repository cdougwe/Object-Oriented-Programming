abstract class PaymentProcessor {
    public final void processPayment() {
        validatePaymentMethod();
        executePayment();
        sendNotification();
    }

    abstract void validatePaymentMethod();

    abstract void executePayment();

    void sendNotification() {
        System.out.println("發送支付通知");
    }
}

class PayPalPayment extends PaymentProcessor {
    @Override
    void validatePaymentMethod() {
        System.out.println("驗證 PayPal 賬戶");
    }
    @Override
    void executePayment() {
        System.out.println("執行 PayPal 支付");
    }
}

class CreditCardPayment extends PaymentProcessor {
    @Override
    void validatePaymentMethod() {
        System.out.println("驗證信用卡");
    }
    @Override
    void executePayment() {
        System.out.println("執行信用卡支付");
    }

}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor payment = new CreditCardPayment();
        payment.processPayment();
        System.out.println("———");
        PaymentProcessor paypal = new PayPalPayment();
        paypal.processPayment();
    }
}
