package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
}

////////////////////////////////////////////////////////////
class Quest7<T> {
	private T pole;

	public Quest7(T pole) {
		this.pole = pole;
	} // 1

	public void setPoleDelaull() {
		// The method setTime(int) is undefined for the type T
		// Параметризованным типам разрешено вызывать только методы класса Object
		// pole.setTime(1000);//2 ошибка
	}

	public static void main(String[] args) {
		Quest7<Date> obj = new Quest7<Date>(new Date());// 3
		// The method setPoleDefault() is undefined for the type Quest7<Date
		// obj.setPoleDefault();
	}
}

////////////////////////////////////////////////////////////
class Quest8<Tl, T2> {
	public static void main(String[] args) {
		// Укажите корректый способ создания экземпляра класса
		// public class Quest8<Tl, T2> {}? (2)

		Quest8 obj1 = new Quest8();
		// Quest8<Object> obj = new Quest8<Object> ();
		Quest8<Object, Object> obj3 = new Quest8<Object, Object>();
		Quest8<Integer, Integer> obj4 = new Quest8<>();
		// Quest8<..., Object> obj = new Quest8<..., Object> ()
		// Quest8<Object, Integer> obj3 = new Quest8<Integer, Objects ();
		// Type mismatch: cannot convert from Quest8<Integer,Integer> to
		// Quest8<Number,Integer>
		// Quest8<Number, Integer> obj = new Quest8<Integer, Integer>();
	}

}

////////////////////////////////////////////////////////////
class GenericMethods {
	public <T> T metod(T value) {
		System.out.println(value.getClass().getName());
		return value;
	}

	public <T> void metod2(T value) {
		System.out.println(value.getClass().getName());
	}

	public static void main(String[] args) {
		GenericMethods g = new GenericMethods();
		g.metod(1);// java.lang.Integer
		g.metod(1L);// java.lang.Long
		g.metod(g);// generics.GenericMethods
	}
}

////////////////////////////////////////////////////////////
// Подход Java
class One<T> {
	T obj;

	public One(T x) {
		obj = x;
	}

	void call() {
		// The method f() is undefined for the type T
		//obj.f();// ERR: f()
		//BUT
		 ((Two) obj).f();
	} 
}

class Two {
	public void f() {
		System.out.println("Two#f()BUT");
	}

	public static void main(String[] args) {
		Two two = new Two();
		One<Two> one = new One<Two>(two);
		one.call();
	}

}

////////////////////////////////////////////////////////
// Подход Java
class One1<T extends Two1> {
	T obj;

	public One1(T x) {
		obj = x;
	}

	void call() {
		obj.f();
	}
}

class Two1 {
	public void f() {
		System.out.println("Two1#f()1");
	}

	public static void main(String[] args) {
		Two1 two = new Two1();
		One1<Two1> one = new One1<Two1>(two);
		one.call();// Two1#f()
	}

}

////////////////////////
class A<T extends Number> {
	T obj;

	public A(T x) {
		obj = x;
	}

	void call() {
		System.out.println(obj.intValue());
	}
}

class B {
	public static void main(String[] args) {
		Integer v = 5;
		A<Integer> a = new A<>(v);
		a.call();// 5
	}
}

///////////////////////////////////////////////
class Erased<T> {
	private final int SIZE = 100;

	public void f(Object arg) {
		//List<Integer> list1 = new List<Integer>()); 
		List<Integer> list2 = new ArrayList<Integer>(); 
		List<? extends Number> list = new ArrayList<Integer>();
		//List<Number> list3 = new ArrayList<Integer>(); 
		//List<Integer> list4 = new ArrayList<Number>();
		// if (arg instanceof T) {} // Ошибка
		// T var = new T(); // Ошибка
		// T[] array = new T[SIZE]; // Ошибка
		T[] array = (T[]) new Object[SIZE]; // Предупр.,
		T a = (T) arg; // предупреждение:
		// Type safety: Unchecked cast from ...
	}
}

/////////////////////////////////
class ParamMethods {
	public <T extends Number> Byte name(T arg) {
		return new Byte((byte) 1);
	}

	public <T extends Number> String name2(T arg) {
		return "";
	}

	public <T extends Number> T name3(T arg) {
		arg.floatValue();
		return null;
	}
}

/////////////////////////////////////////////////////
class Course {
	Course() {
	}

	Course(int v) {
	}
}

class SimpleActionCourse {
	public <T1 extends Course> SimpleActionCourse(T1 course) { // конструктор
		// реализация
	}

	public <T2> SimpleActionCourse() { // конструктор
		// реализация
	}

	public <T3 extends Course> float calculateMark(T3 course) {
		return 0;
		// реализация
	}

	public <T4> boolean printReport(T4 course) {
		return false;
		// реализация
	}

	public <T5> void check() {
		// реализация
	}

	public static void main(String[] args) {
		SimpleActionCourse sap = new SimpleActionCourse(new Course());
		sap.printReport(new Course(7112));
		SimpleActionCourse sa = new <String>SimpleActionCourse();
		sa.<Integer>check();
	}
}
