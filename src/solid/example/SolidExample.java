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

interface Shape{
	public double area();
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

class Rectangle implements Shape {
	double length;
	double width;
	
	Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double area() {
		return length * width;
	}
}

//Inheriting Rectangle has a few problems:
//a) setWidth shouldn't exist - it's a wasteful and confusing method
//b) Rectangle.area() needs to know information about Square to act "correctly"
class Square extends Rectangle {
	
	Square(double length) {
		super(length, length);
	}
	
	@Override
	public void setLength(double length) {
		this.length = length;
		this.width = length;
	}

	@Override
	public void setWidth(double width) {
		this.length = width;
		this.width = width;
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