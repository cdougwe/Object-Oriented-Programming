interface Notice {
    void sendEmailConfirmation();
}

interface Order {
    void processOrder();
}

interface Invoice {
    void printInvoice();
}

class OrderProcess implements Order {
    public void processOrder() {
        System.out.println("處理訂單");
    }
}

class InvoicePrinter implements Invoice {
    public void printInvoice() {
        System.out.println("列印發票");
    }
}

class EmailNotifier implements Notice {
    public void sendEmailConfirmation() {
        System.out.println("發送確認郵件");
    }
}

class Main {
    public static void main(String[] args) {
        OrderProcess p = new OrderProcess();
        p.processOrder();
        InvoicePrinter i = new InvoicePrinter();
        i.printInvoice();
        EmailNotifier e = new EmailNotifier();
        e.sendEmailConfirmation();
    }
}
