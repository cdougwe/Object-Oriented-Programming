interface PaymentMethod {
    void pay();
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("信用卡付款");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("PayPal付款");
    }
}

class Main {
    public static void main(String[] args) {
        PaymentMethod p = new CreditCardPayment();
        p.pay();

        p = new PayPalPayment();
        p.pay();
    }
}