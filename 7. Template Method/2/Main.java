abstract class Animal {
    public void performSound() {
        System.out.print("這隻動物說：");
        makeSound();
    }
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.performSound();
        Animal cat = new Cat();
        cat.performSound();
    }
}