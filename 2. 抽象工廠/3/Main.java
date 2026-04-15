interface Chair {
    void sitOn();
}

class GamingChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on Gaming Chair");
    }
}

class OfficeChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on Office Chair");
    }
}

interface ChairFactory {
    Chair createChair();
}

class OfficeChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new OfficeChair();
    }
}

class GamingChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new GamingChair();
    }
}

class ChairClient {
    private Chair chair;

    public ChairClient(ChairFactory chairFactory) {
        this.chair = chairFactory.createChair();
    }

    public void useChair() {
        chair.sitOn();
    }
}

public class Main {
    public static void main(String[] args) {
        ChairClient os = new ChairClient(new OfficeChairFactory());
        os.useChair();
        os = new ChairClient(new GamingChairFactory());
        os.useChair();
    }
}