package CodePtit;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint) {
        double deltaX = this.x - secondPoint.x;
        double deltaY = this.y - secondPoint.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double distance(Point p1, Point p2) {
        double deltaX = p1.x - p2.x;
        double deltaY = p1.y - p2.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testC = sc.nextInt();

        while (testC-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();

            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x2, y2);
            Point point3 = new Point(x3, y3);

            double a = point1.distance(point2);
            double b = point2.distance(point3);
            double c = point3.distance(point1);

            if (a + b > c && a + c > b && b + c > a) {
                double p = a + b + c;
                System.out.printf("%.3f\n", p);
            } else {
                System.out.println("INVALID");
            }
        }
        sc.close();
    }
}
