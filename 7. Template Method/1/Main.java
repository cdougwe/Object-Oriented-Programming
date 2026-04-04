abstract class BeverageTemplate {
    public void prepareBeverage() {
        boilWater();
        addMainIngredient();
        stir();
    }

    abstract void addMainIngredient();

    abstract void stir();

    abstract void boilWater();
}

class Tea extends BeverageTemplate {
    @Override
    void boilWater() {
        System.out.println("煮沸水");
    }
    @Override
    void addMainIngredient() {
        System.out.println("加茶葉");
    }
    @Override
    void stir() {
        System.out.println("攪拌茶水");
    }

}

class Coffee extends BeverageTemplate {
    @Override
    void addMainIngredient() {
        System.out.println("加咖啡粉");
    }
    @Override
    void stir() {
        System.out.println("攪拌咖啡");
    }
    @Override
    void boilWater() {
        System.out.println("煮沸水");
    }
}

public class Main {
    public static void main(String[] args) {
        BeverageTemplate beverage = new Tea();
        beverage.prepareBeverage();
        beverage = new Coffee();
        beverage.prepareBeverage();
    }
}