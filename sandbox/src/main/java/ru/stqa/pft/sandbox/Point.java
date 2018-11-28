package ru.stqa.pft.sandbox;

public class Point {

    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public double distance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
