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

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class LegacyCircleAdapter implements Shape {
    private Point point;
    private double radius;

    public LegacyCircleAdapter(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("畫出圓心" + point.toString() + "，半徑" + radius + "的圓形。");
    }
}

class LegacyRectangleAdapter implements Shape {
    private Point p1, p2;

    public LegacyRectangleAdapter(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void draw() {
        System.out.println("畫出" + p1.toString() + "-" + p2.toString() + "的長方形。");
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