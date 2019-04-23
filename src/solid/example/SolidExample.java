package solid.example;

public class SolidExample {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[] {
			new Circle(2.0),
			new Square(5.1),
			new Square(6)
		};
		
		AreaCalculator aCalc = new AreaCalculator(shapes);
		SumCalculatorOutputter sco = new SumCalculatorOutputter(aCalc);
		
		System.out.println(sco.getHTML());
		System.out.println(sco.getJSON());
	}
}

interface Shape {
	public double area();
}

interface SolidShape extends Shape {
	
	@Override
	public double area();
	
	public double volume();

}

class Circle implements Shape {
	double radius;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return  Math.pow(radius, 2) * Math.PI;
	}
}

class Cuboid implements SolidShape {
	private double length;
	
	Cuboid(double length) {
		this.length = length;
	}
	
	@Override
	public double area() {
		return 6.0 * length * length;
	}
	
	@Override
	public double volume() {
		return  length * length * length;
	}
}

class Rectangle implements Shape {
	private double length;
	private double width;
	
	Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double area() {
		return length * width;
	}
}

//Inheriting Rectangle no longer has problems!
class Square extends Rectangle {
	
	Square(double length) {
		super(length, length);
	}
}

class AreaCalculator {
	protected Shape[] shapes;
	
	AreaCalculator(Shape[] shapes) {
		this.shapes = shapes;
	}
	
	//logic to sum areas
	public double[] sum() {
		double[] sums = new double[shapes.length];
		
		for(int i = 0; i < shapes.length; i++) {
			Shape shape = shapes[i];
			sums[i] = shape.area();
		}
		
		return sums;
	}
	
}

class VolumeCalculator extends AreaCalculator {
	
	VolumeCalculator(SolidShape[] shapes) {
		super(shapes);
	}
	
	@Override
	public double[] sum() {
		double[] sums = new double[shapes.length];
		
		for(int i = 0; i < shapes.length; i++) {
			SolidShape shape = (SolidShape) shapes[i];
			sums[i] = shape.volume();
		}
		
		return sums;
	}
}

class SumCalculatorOutputter {
	AreaCalculator areaCalculator;
	
	public SumCalculatorOutputter(AreaCalculator areaCalculator) {
		this.areaCalculator = areaCalculator;
	}
	
	public String getHTML() {
		return "I'm an HTML with AREAS!\n" + areaCalculator.sum().toString();
	}
	
	public String getJSON() {
		return "I'm an JSON with AREAS!\n" + areaCalculator.sum().toString();
	}
}