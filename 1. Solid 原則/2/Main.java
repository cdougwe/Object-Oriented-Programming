interface Discount {
    double getDiscount();
}

class RegularDiscount implements Discount {
    @Override
    public double getDiscount() { return 0.1; }
}

class VIPDiscount implements Discount {
    @Override
    public double getDiscount() { return 0.2; }
}

class Main {
    public static void main(String[] args) {

        Discount p1 = new RegularDiscount();
        Discount p2 = new VIPDiscount();

        System.out.println("Regular : " + p1.getDiscount());
        System.out.println("VIP : " + p2.getDiscount());
    }
}
