interface MoveState {
    void action();
}

class Jumper implements MoveState {
    @Override
    public void action() {
        System.out.println("I am Jumping!");
    }
}

class Walk implements MoveState {
    @Override
    public void action() {
        System.out.println("I am Walking!");
    }
}

class Stop implements MoveState {
    @Override
    public void action() {
        System.out.println("I am Stopping!");
    }
}

public class Player {
    public MoveState moveState;

    public Player(MoveState moveState) {
        this.moveState = moveState;
    }
    public void setMoveState(MoveState moveState) { this.moveState = moveState; }
    public void move() {
        moveState.action();
    }
    public static void main(String[] args) {
        Player player = new Player(new Jumper());
        player.move(); // 顯示 I am Jumping!
        player.setMoveState(new Walk());
        player.move(); // 顯示 I am Walking!
        player.setMoveState(new Stop());
        player.move(); // 顯示 I am Stopping!
    }
}
