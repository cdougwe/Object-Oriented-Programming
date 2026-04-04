interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}

public class Test {
    public void testDrawingRectangle() {
        Shape shape = new Rectangle();
        shape.draw(); // 顯示 Drawing rectangle
    }

    public void testDrawingSquare() {
        Shape shape = new Square();
        shape.draw(); // 顯示 Drawing square
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testDrawingRectangle();
        test.testDrawingSquare();
    }
}