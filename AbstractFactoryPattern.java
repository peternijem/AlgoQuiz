
/**
 * Create a Shape and Color interfaces and concrete classes implementing these interfaces. 
 * Create an abstract factory class AbstractFactory as next step. 
 * Factory classes ShapeFactory and ColorFactory are defined where each factory extends AbstractFactory. 
 * A factory creator/generator class FactoryProducer is created.
 * The main method uses FactoryProducer to get a AbstractFactory object. 
 * It will pass information (CIRCLE / RECTANGLE / SQUARE for Shape) to AbstractFactory to get the type of object it needs. 
 * It also passes information (RED / GREEN / BLUE for Color) to AbstractFactory to get the type of object it needs.
 * @author Peter
 *
 */
public class AbstractFactoryPattern {

	public interface Shape {
		void draw();
	}

	public class Rectangle implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Rectangle::draw() method.");
		}
	}

	public class Square implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Square::draw() method.");
		}
	}

	public class Circle implements Shape {

		@Override
		public void draw() {
			System.out.println("Inside Circle::draw() method.");
		}
	}

	public interface Color {
		void fill();
	}

	public class Red implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Red::fill() method.");
		}
	}

	public class Green implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Green::fill() method.");
		}
	}

	public class Blue implements Color {

		@Override
		public void fill() {
			System.out.println("Inside Blue::fill() method.");
		}
	}

	public abstract class AbstractFactory {
		abstract Color getColor(String color);
		abstract Shape getShape(String shape) ;
	}

	public class ShapeFactory extends AbstractFactory {

		@Override
		public Shape getShape(String shapeType){

			if("CIRCLE".equalsIgnoreCase(shapeType)){
				return new Circle();

			}else if("RECTANGLE".equalsIgnoreCase(shapeType)){
				return new Rectangle();

			}else if("SQUARE".equalsIgnoreCase(shapeType)){
				return new Square();
			}

			return null;
		}

		@Override
		Color getColor(String color) {
			return null;
		}
	}

	public class ColorFactory extends AbstractFactory {

		@Override
		public Shape getShape(String shapeType){
			return null;
		}

		@Override
		Color getColor(String color) {

			if("RED".equalsIgnoreCase(color)){
				return new Red();

			}else if("GREEN".equalsIgnoreCase(color)){
				return new Green();

			}else if("BLUE".equalsIgnoreCase(color)){
				return new Blue();
			}

			return null;
		}
	}

	public class FactoryProducer {
		public AbstractFactory getFactory(String choice){

			if("SHAPE".equalsIgnoreCase(choice)){
				return new ShapeFactory();

			}else if("COLOR".equalsIgnoreCase(choice)){
				return new ColorFactory();
			}

			return null;
		}
	}


	public static void main(String[] args) {
		AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
		AbstractFactoryPattern.FactoryProducer factoryProducer = abstractFactoryPattern.new FactoryProducer();
		
		//get shape factory
		AbstractFactory shapeFactory = factoryProducer.getFactory("SHAPE");

		//get an object of Shape Circle
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		//call draw method of Shape Circle
		shape1.draw();

		//get an object of Shape Rectangle
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		//call draw method of Shape Rectangle
		shape2.draw();

		//get an object of Shape Square 
		Shape shape3 = shapeFactory.getShape("SQUARE");

		//call draw method of Shape Square
		shape3.draw();

		//get color factory
		AbstractFactory colorFactory = factoryProducer.getFactory("COLOR");

		//get an object of Color Red
		Color color1 = colorFactory.getColor("RED");

		//call fill method of Red
		color1.fill();

		//get an object of Color Green
		Color color2 = colorFactory.getColor("Green");

		//call fill method of Green
		color2.fill();

		//get an object of Color Blue
		Color color3 = colorFactory.getColor("BLUE");

		//call fill method of Color Blue
		color3.fill();
	}

}
