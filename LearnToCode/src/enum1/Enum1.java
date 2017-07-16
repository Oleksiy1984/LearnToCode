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
