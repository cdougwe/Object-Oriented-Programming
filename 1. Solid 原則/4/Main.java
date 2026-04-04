interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public int getArea() { return width * height; }
}

class Square implements Shape {
    private int side;

    public Square() {
    }

    public Square(int side) {
        this.side = side;
    }

    public void setWidth(int side) { this.side = side; }

    @Override
    public int getArea() { return side * side; }
}

class Main {
    public static void main(String[] args) {
        Rectangle rt = new Rectangle(5, 4);
        System.out.println("Rectangle area: " + rt.getArea());
        Square sq = new Square(5);
        System.out.println("Square area: " + sq.getArea());
    }
}