package exeption;

import java.util.List;

public class Test {
	

	public static void doIt(String String) { // 1
		int i = 10;
		i: for (int k = 0; k < 10; k++) { // 2
			System.out.println(String + i); // 3
			if (k * k > 10)
				continue i; // 4
		}
	}

	public static void main(String[] args) {
		Float f1 = new Float(Float.NaN);
		Float f2 = new Float(Float.NaN);
		// false true false
		System.out.println("" + (f1 == f2) + " " + f1.equals(f2) + " " + (Float.NaN == Float.NaN));

		//////////////////////
		Integer a = 120;
		Integer b = 120;
		Integer c = 130;
		Integer d = 130;
		System.out.println(a == b);// true
		System.out.println(c == d);// false
		////////////////////////
		// doIt("S"); //S10 10 times
		///////////////
		
	}

}

class Overload {
	public void method(Object o) {
		System.out.println("Object");
	}

	public void method(java.io.FileNotFoundException f) {
		System.out.println("FileNotFoundException");
	}

	public void method(java.io.IOException i) {
		System.out.println("IOException");
	}

	public static void main(String args[]) {
		Overload test = new Overload();
		test.method(null);// FileNotFoundException
	}
}

class Mountain {
	static String name = "Himalaya";

	static Mountain getMountain() {
		System.out.println("Getting Name ");
		return null;
	}

	public static void main(String[] args) {
		// Getting Name
		// Himalaya
		System.out.println(getMountain().name);
	}
}

class Main {
	static void method(int... a) {
		System.out.println("inside int...");
	}

	static void method(long a, long b) {
		System.out.println("inside long");
	}

	static void method(Integer a, Integer b) {
		System.out.println("inside INTEGER");
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		method(a, b);//inside long
	}
}

class Super { static String ID = "QBANK"; }
class Sub extends Super{
  static { System.out.print("In Sub"); }
}
class Test2{
  public static void main(String[] args) {
    System.out.println(Sub.ID);//QBANK
  }
}
