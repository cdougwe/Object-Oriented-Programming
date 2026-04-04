interface Drawable {
    void draw();
}

class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("畫方形");
    }
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("畫圓");
    }
}

class Main {
    public static void main(String[] args) {
        Drawable d = new Circle();
        d.draw();

        d = new Square();
        d.draw();
    }
}