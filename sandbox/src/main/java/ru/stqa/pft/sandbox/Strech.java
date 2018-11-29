package ru.stqa.pft.sandbox;

public class Strech {
    Point p1, p2;
    Strech (Point point1, Point point2) {
        this.p1 = point1;
        this.p2 = point2;
    }

    public double abstand() {
       return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
    }
}
