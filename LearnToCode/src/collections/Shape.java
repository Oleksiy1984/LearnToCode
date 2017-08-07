package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shape implements Iterable<String> {

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}}
 class Rectangle extends Shape{}
 class Circle extends Shape{}

class Demo{
	public static void main(String[] args) {
		List<? extends Shape> list2 = new ArrayList<Shape>();
		List<? extends Shape> list = new ArrayList<Circle>();
		List<? extends Shape> list1 = new ArrayList<Rectangle>();
		
		List<? super Shape> list3 = new ArrayList<Object>();
		List<? super Circle> list4 = new ArrayList<Circle>();
		List<? super Circle> list44 = new ArrayList<Shape>();
		List<? super Shape> list5 = new ArrayList<Shape>();
		//List<? super Shape> list55 = new ArrayList<Circle>();//error
		
		List<? super Shape> list7 = new ArrayList<Iterable<String>>();
		List<? super Circle> list8 = new ArrayList<Iterable<String>>();
		
		Iterable<String> shape = new Shape();
		Iterable<String> circle = new Circle();
		
		List<Shape> list10 = new ArrayList<Shape>();
		list10.add(new Shape());
		list10.add(new Rectangle());
		list10.add(new Circle());
		List<? super Shape> list32 = new ArrayList<Shape>();
		list32.add(new Shape());
		list32.add(new Circle());
		list32.add(new Rectangle());
		System.out.println(list32);
		//list32.add(new Object());// compile error
		
		List<? extends Shape> list22 = new ArrayList<Shape>();
		Shape shape2 = list22.get(0);
		Object o = list22.get(0);
		//Circle c = list22.get(0);
		//list22.add(new Shape()); //compile error
		
		
		
	}
}
