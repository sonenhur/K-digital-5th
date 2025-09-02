package part1.chap07_Test;

public class Line extends Geometry {
    Point start;
    Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        addPoint(start.x, start.y);
        addPoint(end.x, end.y);
    }

    void draw() {
        System.out.println("Line from (" + start.x + ", " + start.y + ") to (" + end.x + ", " + end.y + ")");
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
