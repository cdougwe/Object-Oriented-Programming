enum CareerType {
    MAGE, WARRIOR;
}

interface Role {
    void setAttributes();
    void equipWeapon();
}

class WarriorRole implements Role {
    public void setAttributes() {
        System.out.println("設置戰士的高攻擊與防禦");
    }
    public void equipWeapon() {
        System.out.println("裝備劍");
    }
}

class MageRole implements Role {
    public void setAttributes() {
        System.out.println("設置法師的高魔力");
    }
    public void equipWeapon() {
        System.out.println("裝備魔杖");
    }
}

abstract class Character {
    Role role;

    public final void initialize() {
        role = genCharacter(); // 產生角色物件
        role.setAttributes(); // 設定角色屬性
        role.equipWeapon(); // 配置角色武器
    }
    abstract Role genCharacter();
}

class Warrior extends Character {
    @Override
    Role genCharacter() {
        return new WarriorRole();
    }
}

class Mage extends Character {
    @Override
    Role genCharacter() {
        return new MageRole();
    }
}

class CharacterFactory {
    public Character getCareer(String p) {
        if (p == null) {
            throw new IllegalArgumentException("Career can not be a null type !");
        }
        try {
            CareerType careerType = CareerType.valueOf(p.toUpperCase());
            return switch (careerType) {
                case MAGE -> new Mage();
                case WARRIOR -> new Warrior();
            };
        } catch (Exception e) {
            throw new IllegalArgumentException("This career is unacceptable !");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        Character character = characterFactory.getCareer("Warrior");
        character.initialize();
        character = characterFactory.getCareer("MAGE");
        character.initialize();
    }
}