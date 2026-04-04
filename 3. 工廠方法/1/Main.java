interface Ingredient {
    void add();
}

class TeaBag implements Ingredient {
    @Override
    public void add() {
        System.out.println("加入茶葉");
    }
}

class CoffeeBag implements Ingredient {
    @Override
    public void add() {
        System.out.println("加入咖啡");
    }
}

abstract class DrinkTemplate {
    public final void prepare() {
        getType().add();
        boilWater();
        stir();
    }

    protected abstract Ingredient getType();
    protected void boilWater() {
        System.out.println("加熱水");
    };
    protected void stir() {
        System.out.println("攪拌一下");
    };
}

class Tea extends DrinkTemplate {
    @Override
    protected Ingredient getType() { return new TeaBag(); }
}

class Coffee extends DrinkTemplate {
    @Override
    protected Ingredient getType() { return new CoffeeBag(); }
}

class DrinkFactory {
    public DrinkTemplate getDrink(String type) {
        if (type.equals("茶"))
            return new Tea();
        else if (type.equals("咖啡"))
            return new Coffee();
        else throw new IllegalArgumentException("沒有" + type);
    }
}

public class Main {
    public static void main(String[] args) {
        DrinkFactory drinkFactory = new DrinkFactory();

        DrinkTemplate drink = drinkFactory.getDrink("茶");
        drink.prepare();
        System.out.println("----------------------");
        drink = drinkFactory.getDrink("咖啡");
        drink.prepare();

    }
}