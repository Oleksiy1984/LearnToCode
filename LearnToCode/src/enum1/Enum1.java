package enum1;

enum Numbers implements I {
	ONE, TWO, THREE, FOUR, FIVE, B("a");

	private Numbers() {
	}

	Numbers(String y) {
	}
}

interface I {
}
// class B extends A{} error
// abstract enum S{} erro

public class Enum1 {
	public static final String SdR = "";

	Enum1() {
		final String SR = "";
	}

	public static void main(String[] args) {
String g=SdR;
		Numbers n1 = Numbers.ONE;
		Numbers n2 = Numbers.ONE;
		if (n1 == n2) {
			System.out.println(true);
		} // true
		else {
			System.out.println(false);
		}
		System.out.println(Numbers.FIVE.ordinal());// 4
		System.out.println(Numbers.ONE.ordinal());// 0
	}
}

enum Main {
	X {

		{
			System.out.println("Init-999");
		}

		private void f() {
			System.out.println("method f() 3");
		}

		@Override
		public void m() {
			f();
		}
	};
	
	public void m() {
		System.out.println(2);
	}

	static {
		System.out.println("Main enum");
	}

	public static void main(String[] args) {
		X.m();
	}
	
	
}

/*
 * A constructor in an enum class can only be specified as private.
 * Enums are implicitly declared public, static, and final, which means you cannot 
extend them.
•	 When you define an enumeration, it implicitly inherits from java.lang.Enum. 
Internally, enumerations are converted to classes. Further, enumeration constants 
are instances of the enumeration class for which the constant is declared as a 
member.
•	 You can apply the valueOf() and name() methods to the enum element to return the 
name of the enum element.
•	 If you declare an enum within a class, then it is by default static.
 You cannot use the new operator on enum data types, even inside the enum class.
•	 You can compare two enumerations for equality using == operator.
•	 If enumeration constants are from two different enumerations, the equals() method 
does not return true.
•	 When an enumeration constant’s toString() method is invoked, it prints the name 
of the enumeration constant.
•	 The static values() method in the Enum class returns an array of the enumeration 
constants when called on an enumeration type.
 */