interface Shape {
    void draw();
}

class Point {
    protected int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

class LegacyCircle {
    public void draw(int x, int y, double radius) {
        System.out.println("畫出圓心(" + x + " ," + y + ")，半徑" + radius + "的圓形。");
    }
}

class LegacyCircleAdapter implements Shape {
    private LegacyCircle legacyCircle = new LegacyCircle();
    private Point point;
    private double radius;

    public LegacyCircleAdapter(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public void draw() {
        legacyCircle.draw(point.getX(), point.getY(), radius);
    }
}

class LegacyRectangle {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("畫出 (" + x1 + "," + y1 + ")-(" + x2 + "," + y2 + ")的長方形。");
    }
}

class LegacyRectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle = new LegacyRectangle();
    private Point topLeft, bottomRight;

    public LegacyRectangleAdapter(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    @Override
    public void draw() {
        legacyRectangle.draw(topLeft.getX(), topLeft.getY(), bottomRight.getX(), bottomRight.getY());
    }
}

public class Main {
    public static void main(String[] args) {
        Shape p = new LegacyRectangleAdapter(new Point(0, 0), new Point(10, 10));
        p.draw(); // 顯示 "畫出(0, 0)-(10, 10)的長方形。"
        p = new LegacyCircleAdapter(new Point(0, 0), 5.0);
        p.draw(); // 顯示 "畫出圓心(0, 0)，半徑5.0的圓形。"
    }
}