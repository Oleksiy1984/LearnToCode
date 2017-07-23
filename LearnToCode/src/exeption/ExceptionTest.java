package exeption;

class MyExceptionn extends Throwable {
}

class MyException1 extends MyExceptionn {
}

class MyException2 extends MyExceptionn {
}

class MyException3 extends MyException2 {
}

public class ExceptionTest {
	void myMethod() throws MyExceptionn {
		throw new MyException3();
	}

	public static void main(String[] args) {
		ExceptionTest et = new ExceptionTest();
		try {
			et.myMethod();
		} catch (MyExceptionn me) {
			System.out.println("MyException thrown");
			// Unreachable catch block for MyException3.
			// It is already handled by the catch block for MyException
		}
		// catch (MyException3 me3) {
		// System.out.println("MyException3 thrown");
		// }
		finally {
			System.out.println(" Done");
		}
	}
}

/////////////////////////////
class NewException extends Exception {
}

class AnotherException extends Exception {
}

class ExceptionTest2 {
	public static void main(String[] args) throws Exception {
		try {
			m2();
		} finally {
			m3();// exeption.AnotherException
		}
	}

	public static void m2() throws NewException {
		throw new NewException();
	}

	public static void m3() throws AnotherException {
		throw new AnotherException();
	}
}
///////////////////////

class Test4 {
	static String j = "";

	public static void method(int i) {
		try {
			if (i == 2) {
				throw new Exception();
			}
			j += "1";
		} catch (Exception e) {
			j += "2";
			return;
		} finally {
			j += "3";
		}
		j += "4";
	}

	public static void main(String args[]) {
		method(1);
		method(2);
		System.out.println(j);//13423
	}
}
