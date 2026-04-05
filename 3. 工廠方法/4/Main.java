enum TransportType {
    SHIP, TRUCK;
}

interface Transportation {
    void delivering(Object object);
}

class Ship implements Transportation {
    @Override
    public void delivering(Object object) {
        System.out.println("用貨櫃輪運送中..." + object);
    }
}

class Truck implements Transportation {
    @Override
    public void delivering(Object object) {
        System.out.println("用卡車運送中..." + object);
    }
}

abstract class LogisticService {
    protected Transportation transportation;

    public LogisticService(Transportation transportation) {
        this.transportation = transportation;
    }

    public final void deliver(Object object) {
        transportation.delivering(object);
    }
}

class ShipService extends LogisticService {
    public ShipService() {
        super(new Ship());
    }
}

class TruckService extends LogisticService {
    public TruckService() {
        super(new Truck());
    }
}

class LogisticFactory {
    public LogisticService getTransportType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("TransportationType should not be a null value");
        }
        try {
            TransportType transportType = TransportType.valueOf(type.toUpperCase());
            return switch (transportType) {
                case SHIP -> new ShipService();
                case TRUCK -> new TruckService();
            };
        } catch (Exception e) {
            throw new IllegalArgumentException(type + " is not supported!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LogisticFactory logisticFactory = new LogisticFactory();
        LogisticService service = logisticFactory.getTransportType("truck"); // 新增一個卡車運送服務的物流系統
        service.deliver(new Object()); // 顯示: 用卡車運送中。。。java.lang.Object@XXXXX
        service = logisticFactory.getTransportType("Ship"); // 新增一個海運運送服務的物流系統
        service.deliver(new Object()); // 顯示: 用貨櫃輪運送中。。。java.lang.Object@YYYYY
    }
}