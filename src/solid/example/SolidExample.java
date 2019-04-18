package solid.example;

public class SolidExample {

	public static void main(String[] args) {
		Object[] shapes = new Object[] {
			new Circle(2.0),
			new Square(5.1),
			new Square(6)
		};
		
		AreaCalculator aCalc = new AreaCalculator(shapes);
		
		System.out.println(aCalc.output());
	}
}

class Circle {
	double radius;
	
	Circle(double radius) {
		this.radius = radius;
	}
}

class Square {
	double length;
	
	Square(double length) {
		this.length = length;
	}
}

class AreaCalculator {
	protected Object[] shapes;
	
	AreaCalculator(Object[] shapes) {
		this.shapes = shapes;
	}
	
	//logic to sum areas
	private double[] sum() {
		double[] sums = new double[shapes.length];
		
		for(int i = 0; i < shapes.length; i++) {
			Object shape = shapes[i];
			if(shape instanceof Square) {
				
				sums[i] = Math.pow(((Square) shape).length, 2);
				
			} else if(shape instanceof Circle) {
				
				sums[i] = Math.pow(((Circle) shape).radius, 2)* Math.PI;
						
			} else {
				
				sums[i] = -1;
			}
		}
		
		return sums;
	}
	
	public String output() {
		return "Sums of the areas: " + sum(); 
	}
	
}