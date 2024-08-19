package part1.chap07_Test;

public class GeomTest {
    public static void main(String[] args) {
        Point p = new Point(0, 0);
        p.addPoint(10, 20);
        p.printPoint();
        System.out.println("점 길이 : " + p.getLength());
        System.out.println("점 면적 : " + p.getArea());
    }

//		Line line = new Line();
//		line.addPoint(10,20);
//		line.addPoint(20,30);
//		line.printPoint();
//		sysout
}
