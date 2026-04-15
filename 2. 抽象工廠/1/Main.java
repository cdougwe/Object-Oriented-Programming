interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

interface ShapeFactory {
    Shape createShape();
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class ShapeClient {
    private Shape shape;

    public ShapeClient(ShapeFactory shapeFactory) {
        this.shape = shapeFactory.createShape();
    }

    public void drawShape() {
        shape.draw();
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeClient sh = new ShapeClient(new CircleFactory());
        sh.drawShape();
        sh = new ShapeClient(new RectangleFactory());
        sh.drawShape();
    }
}