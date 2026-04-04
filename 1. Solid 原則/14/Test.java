interface CreditCardPayment {
    boolean payWithCreditCard(String type);
}

interface PaypalPayment {
    boolean payWithPaypal(String type);
}

class CreditCardPaymentProcessor implements CreditCardPayment {
    @Override
    public boolean payWithCreditCard(String type) {
        System.out.print("信用卡付款 ");
        return true;
    }
}

class PaypalPaymentProcessor implements PaypalPayment {

    @Override
    public boolean payWithPaypal(String type) {
        System.out.print("PayPal付款 ");
        return true;
    }
}

public class Test {
    public void testCreditCardPayment() {
        CreditCardPayment processor = new CreditCardPaymentProcessor();
        boolean result = processor.payWithCreditCard("creditCardData"); // 顯示信用卡付款，傳回成功或失敗
        System.out.println(result ? "- 付款成功" : "- 付款失敗");
    }

    public void testPaypalPayment() {
        PaypalPayment processor = new PaypalPaymentProcessor();
        boolean result = processor.payWithPaypal("paypalData"); // 顯示PayPal付款，傳回成功或失敗
        System.out.println(result ? "- 付款成功" : "- 付款失敗");

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testCreditCardPayment();
        test.testPaypalPayment();
    }
}