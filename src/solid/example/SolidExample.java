package solid.example;

public class SolidExample {

	public static void main(String[] args) {
		Object[] shapes = new Object[] {
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
	public double[] sum() {
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