package part1.chap07_Test;

public class Point extends Geometry {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        addPoint(x, y);
    }

    void draw() {
        System.out.println("Point at (" + x + ", " + y + ")");
    }

    @Override
    public void addPoint(int x, int y) {
        super.addPoint(x, y);
    }

    @Override
    public void printPoint() {
        super.printPoint();
    }

    @Override
    public double getLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 0;
    }

}
