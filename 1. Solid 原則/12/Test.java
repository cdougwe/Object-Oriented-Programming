interface OrderProcessingStrategy {
    void processOrder(Order order);
}

class StandardOrderProcessingStrategy implements OrderProcessingStrategy {
    @Override
    public void processOrder(Order order) {
        System.out.println("處理標準訂單 " + order.getOrder());
    }
}

class UrgentOrderProcessingStrategy implements OrderProcessingStrategy {
    @Override
    public void processOrder(Order order) {
        System.out.println("處理優先訂單 " + order.getOrder());
    }
}

class Order {
    private String order;

    public Order(String order) {
        this.order = order;
    }

    public String getOrder() { return order; }
}

class OrderProcessor {
    private OrderProcessingStrategy orderProcessingStrategy;

    public OrderProcessor(OrderProcessingStrategy orderProcessingStrategy) {
        this.orderProcessingStrategy = orderProcessingStrategy;
    }
    public void processOrder(Order order) {
        orderProcessingStrategy.processOrder(order);
    }
}

public class Test {
    public void testOrderProcessingWithStandardOrder() {
        OrderProcessor processor = new OrderProcessor(new StandardOrderProcessingStrategy());
        Order order = new Order("Standard101");
        processor.processOrder(order); // 顯示處理標準訂單Standard101
    }
    public void testOrderProcessingWithUrgentOrder() {
        OrderProcessor processor = new OrderProcessor(new UrgentOrderProcessingStrategy());
        Order order = new Order("Urgent202");
        processor.processOrder(order); // 顯示處理優先訂單Urgent202
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.testOrderProcessingWithStandardOrder();
        test.testOrderProcessingWithUrgentOrder();
    }
}