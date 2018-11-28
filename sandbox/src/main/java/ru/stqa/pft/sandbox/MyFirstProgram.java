package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Nastya");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника " + r.a + " и " + r.b + " = " + r.area());


		int x1 = 1;
		int x2 = 3;
		int y1 = 1;
		int y2 = 2;
		int x = x2 - x1;
		int y = y2 - y1;
		int p1 = x * x;
		int p2 = y * y;
		System.out.println("Расстояние между двумя точками на плоскости = " + distance(p1, p2));
	}

	public static void hello(String somebody) {
		 System.out.println("Hello," + somebody + "!");
	}

	public static double distance(double p1, double p2) {
		return Math.sqrt(p1 + p2);
	}

}