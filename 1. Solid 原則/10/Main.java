interface Data {
    void whoAmI();
    void move();
}

class Penguin implements Data {
    @Override
    public void whoAmI() {
        System.out.println("我是企鵝");
    }

    @Override
    public void move() {
        System.out.println("企鵝走路");
    }
}

class Sparrow implements Data {
    @Override
    public void whoAmI() {
        System.out.println("我是鳥");
    }

    @Override
    public void move() {
        System.out.println("麻雀飛行");
    }

}

class Main {
    public static void main(String[] args) {
        Data p = new Sparrow();
        p.whoAmI();
        p.move();

        p = new Penguin();
        p.whoAmI();
        p.move();
    }
}
