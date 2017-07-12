package inheritance;


class Testing {
	int x;

	void getX() {
		System.out.println(this.x);
	}
}

class A extends Testing {
	int x = 2;
	// @Override
	// void getX() {
	// System.out.println(this.x);
	// }
}

public class Test {
	public static void main(String[] args) {
		Testing t = new A();
		System.out.print(t.x);// 0
		t.getX();// 0

		A a = new A();
		System.out.print(a.x);// 2
		a.getX();// 0
	}

}

/////////////////////////////////////////////////////////////////
// Prevent inheritance: 1) final; 2) make private constructor
final class One {
}

// class Two extends One{} // cannot subclass final class One
// 2) make private constructor
class WithPrivateConstructor {
	private WithPrivateConstructor() {

	}
}

// Implicit(неявный) super constructor WithPrivateConstructor()
// is not visible for default constructor.
// Must define an explicit constructor
// class TryInherit extends WithPrivateConstructor {
// }

/////////////////////////////////////////////////////////////////
// Abstract vs Final

// The class AA can be either abstract or final, not both
// abstract final class AA{}

class AA {
	final void m() {
	}
}

class BB extends AA {
	// Cannot override the final method from AA
	// void m() {}
	// but can be overloaded
	void m(int t) {
		System.out.println(t);
	}
}

//////////////////////////////////
class A1 {
	static void m() {
		System.out.println("AA");
	}
}

class B1 extends A1 {
	// This instance method cannot override the static method from AA and vice-versa
	// void m() {
	// }

	// but can be overloaded
	void m(int t) {
		System.out.println(t);
	}

	// or can be shaded own static method
	static void m() {
		System.out.println("B1");
	}
}
//////////////////////////////////////////////////
// static vs final

// Illegal modifier for the class AA; //only public, abstract & final are
// permitted
// static class Aq{}

// static final on methods can be
class A4 {
	static final void m() {
	}
}

class B4 extends A4 {
	// can be overloading
	static final void m(int y) {
	}
	// or this
	// void m(int y) {
	// }
}

///////////////////////////////////////////

interface Inter {
	public static final int P = 0;

	public abstract void method();

	public static interface InnerInterface {
	}

	public static class InnerClass {
	}
}

interface I2 extends Inter {
}

////////////////////////////////////////////
class TestClass implements T1, T2 {

	@Override
	public void m1() {
	}

	public static void main(String[] args) {
		TestClass t = new TestClass();
		t.m1();
		// The static field T2.VALUE should be accessed in a static way (no error)
		System.out.println(((T2) t).VALUE);
		System.out.println(T1.VALUE);
	}
}

interface T1 {
	int VALUE = 1;

	void m1();
}

interface T2 {
	int VALUE = 2;

	void m1();
}
/////////////////////////////////////////////////////

class A2 {
	Object a() {
		return "A2";
	}
}

class B2 extends A2 {

	// if it was private - Cannot reduce the visibility of the inherited method from
	// AA
	@Override
	Integer a() {
		return 15;
	}

	public static void main(String[] args) {
		A2 aa = new B2();
		System.out.println(aa.a()); // 15
	}
}

//////////////////////////////////////////
class AAA {
	int a() {
		return 3;
	}
}

class BBB extends AAA {
	// The return type is incompatible with AA.a()
	// @Override
	// Integer a() {return 3;} //The return type is incompatible with AA.a()
	// ONLY int
	// @Override
	// double a() {
	// return 1.;
	// }

}
/////////////////////////////////////////////////////////
class A11{
	 void a1() {
		 System.out.println("a1 metod");
		}
	 void m() {
	}
} 
class B11 extends A11{
	 void m() {
		 System.out.println("B11");
		}
}

class See {
	public static void main(String[] args) {
		// Восходящее преобразование типов это преобразование от потомка к предку.
		// Может выполняться неявно.
		A11 a = new B11();
		
		//нисходящем преобразовании типов, 
		//которое всегда должно выполняться явно, 
		//поля и методы снова становятся доступными
		//Нисходящее преобразование типов может осуществляться от класса предка к классу, 
		//который находится в любом узле иерархии наследования от предка к потомку
		B11 b = (B11) a;
		b.m(); // B11
		b.a1(); // a1 method
	}
}
/////////////////////////////////////////
class Outer {

	class A1 {
		void a1() {
		}

		void m() {
		}
	}

	class B1 extends A1 {
		void m() {
		}
	}
	static class Stat{}

	public static void main(String[] args) {

		Outer test = new Outer();
		Outer.A1 a = test.new A1();
		Outer.B1 b = test.new B1();
		Outer.Stat ss = new Outer.Stat();
		a = b;
		b = (B1) a;
	}
}
/////////////////////////////////////////

class A3 {
}

class B3 extends A3 {
}

class C3 extends B3 {
}

class DF {

	public static void main(String[] args) {
		B3 o = new B3();
		System.out.println(o instanceof A3);//true
		System.out.println(o instanceof B3);//true
		System.out.println(o instanceof C3);//false
		
		int value=3;
		//The left operand of instanceof MUST be an object and not a primitive.
		//System.out.println(value instanceof Integer or int);//incompatible type
		
		Short k = new Short((short) 9); 
		System.out.println(k instanceof Short); //true
	}
}
////////////////////////////////
interface Animal{}
class Mammal{}
class Cat {//if final it will be error (cat instanceof Animal)
	public static void main(String[] args) {
		Cat cat = new Cat();
		System.out.println(cat instanceof Cat);//true
		System.out.println(cat instanceof Animal);//false
		//System.out.println(cat instanceof Mammal);//incompatible
		
	}
}
//////////////////////////////////////////////////////////
