interface Worker {
    void work();
}

interface Eating {
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("機器人工作");
    }
}

class Human implements Worker, Eating {

    public void work() {
        System.out.println("人類工作");
    }
    public void eat() {
        System.out.println("人類吃飯");
    }
}

public class Main {
    public static void main(String[] args) {
        Robot rt = new Robot();
        rt.work();

        Human wk = new Human();
        wk.work();
        wk.eat();
    }

}