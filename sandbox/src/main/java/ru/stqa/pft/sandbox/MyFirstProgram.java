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

		Strech q = new Strech(new Point(2.0, 2.0), new Point(5.0, 6.0));
		double as = q.abstand();
		System.out.println("Length = " + as);
	}

	public static void hello(String somebody) {
		 System.out.println("Hello," + somebody + "!");
	}

}