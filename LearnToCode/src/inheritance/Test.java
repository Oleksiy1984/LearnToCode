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

// Implicit super constructor WithPrivateConstructor()
// is not visible for default constructor.
// Must define an explicit constructor
//class TryInherit extends WithPrivateConstructor {
//}

/////////////////////////////////////////////////////////////////
//Abstract vs Final

//The class AA can be either abstract or final, not both 
//abstract final class AA{}

/*
class AA{
	final void m() {}
}
class BB extends AA{
	//Cannot override the final method from AA
	void m() {}
	//but can be overloaded
	void m(int t) {System.out.println(t);}
}
*/

/*
class AA{
	static void m() {
		System.out.println("AA");
	}
}
class BB extends AA{
	//This instance method cannot override the static method from AA
	void m() {}
	//but can be overloaded
	void m(int t) {System.out.println(t);}
	//or can be shaded  own static method
	static void m() {System.out.println("BB");}
}
*/

//static vs final

/*
//Illegal modifier for the class AA; 
//only public, abstract & final are permitted
static class AA{}
*/

/*
//static final on methods can be
 class AA{
	static final void m() {}
}
class BB extends AA{
	//can be overloading
	static final void m(int y) {}
	//void m(int y) {}
}
*/

///////////////////////////////////////////
/*
interface Inter{
	public static final int P=0;
	public abstract void method();
	public static interface InnerInterface{}
	public static class InnerClass{}
}
interface I2 extends Inter{}
*/
////////////////////////////////////////////
/*
class AA{
	Object a() {
		return "AA";
	}
}
class BB extends AA{
	//Cannot reduce the visibility of the inherited method from AA
	@Override
	private String a() {
		return "BB";
	}
	public static void main(String[] args) {
		AA aa = new BB();
		System.out.println(aa.a()); //BB
				
	}
}
*/

