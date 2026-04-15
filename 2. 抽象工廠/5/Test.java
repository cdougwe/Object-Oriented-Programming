interface AttackEquipment {
    void show();
}

interface DefenseEquipment {
    void show();
}

class HighEfficientAttackEquipment implements AttackEquipment {
    private String equipment;

    public HighEfficientAttackEquipment(String equipment) {
        this.equipment = equipment;
    }
    @Override
    public void show() {
        System.out.println("Using High Efficient Attack Equipment" + equipment);
    }
}

class LowEfficientAttackEquipment implements AttackEquipment {
    private String equipment;

    public LowEfficientAttackEquipment(String equipment) {
        this.equipment = equipment;
    }
    @Override
    public void show() {
        System.out.println("Using Low Efficient Attack Equipment" + equipment);
    }
}

class HighEfficientDefenseEquipment implements DefenseEquipment {
    private String equipment;

    public HighEfficientDefenseEquipment(String equipment) {
        this.equipment = equipment;
    }
    @Override
    public void show() {
        System.out.println("Using High Efficient Defense Equipment" + equipment);
    }
}

class LowEfficientDefenseEquipment implements DefenseEquipment {
    private String equipment;

    public LowEfficientDefenseEquipment(String equipment) {
        this.equipment = equipment;
    }
    @Override
    public void show() {
        System.out.println("Using Low Efficient Defense Equipment" + equipment);
    }
}

interface EquipmentFactory {
    AttackEquipment createAttackEquipment(Warrior w);
    DefenseEquipment createDefenseEquipment(Warrior w);
}

class AttackEquipmentFactory implements EquipmentFactory {
    @Override
    public AttackEquipment createAttackEquipment(Warrior w) {
        return (w.getBodyStrength() > 60) ? new HighEfficientAttackEquipment("Gun") : new LowEfficientAttackEquipment("Sword");
    }
    @Override
    public DefenseEquipment createDefenseEquipment(Warrior w) {
        return (w.getLifeValue() > 40) ? new LowEfficientDefenseEquipment("Shield") : new HighEfficientDefenseEquipment("Missile");
    }
}

class DefensiveEquipmentFactory implements EquipmentFactory {
    @Override
    public AttackEquipment createAttackEquipment(Warrior w) {
        return (w.getBodyStrength() > 90) ? new HighEfficientAttackEquipment("Gun") : new LowEfficientAttackEquipment("Sword");
    }
    @Override
    public DefenseEquipment createDefenseEquipment(Warrior w) {
        return (w.getLifeValue() > 80) ? new LowEfficientDefenseEquipment("Shield") : new HighEfficientDefenseEquipment("Missile");
    }
}

class Warrior {
    private int BodyStrength = 70;
    private int LifeValue = 50;
    EquipmentFactory equipmentFactory;

    public Warrior(EquipmentFactory equipmentFactory) {
        this.equipmentFactory = equipmentFactory;
    }
    public int getBodyStrength() { return BodyStrength; }
    public int getLifeValue() { return LifeValue; }

    public void attack() {
        equipmentFactory.createAttackEquipment(this).show();
    }
    public void defense() {
        equipmentFactory.createDefenseEquipment(this).show();
    }

}

public class Test {
    public static void main(String[] args) {
        Warrior w = new Warrior(new DefensiveEquipmentFactory());
        w.attack();
        w.defense();
    }
}