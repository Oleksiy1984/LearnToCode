package exeption;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Выберите правильные утверждения (3):
1)	Проверяемые (checked) исключения являются наследниками класса
java.lang.Exception
2)	Непроверяемые (unchecked) исключения являются наследниками класса
java.lang.Error
3)	Непроверяемые (unchecked) исключения являются наследниками класса
java.lang.Exception
4)	Проверяемые (checked) исключения обязательно обрабатываются
5)	Непроверяемые (unchecked) исключения невозможно обработать
Answers: 1, 3, 4
 */

public class Exeption1 {

	public static void main(String[] args) {
		// test2++
		try {
			FileReader frl = new FileReader("test1.txt");// available
			try {
				FileReader fr2 = new FileReader("test2.txt");
			} catch (IOException e) {
				System.out.print("test2");
			}
			System.out.print("+");
		} catch (FileNotFoundException e) {
			System.out.print("test1");
		}
		System.out.print("+");
		//////////////////////////////////////
		try {
			FileReader frl = new FileReader("test10.txt");
		}

		// Unreachable catch block for FileNotFoundException.
		// It is already handled by the catch block for IOException
		// catch (IOException e) {
		// System.out.print("test1");
		// }
		catch (FileNotFoundException e) {
			System.out.print("test1");
		}
	}

}

class A {
	public void f() throws IOException {
	}
}

class B extends A {
	// public void f() throws Exception {}
	// 2 public void f() throws IOException {}
	// public void f() throws InterruptedException, IOException {}
	// 4 public void f() throws IOException, FileNotFoundException {}
	// 5 public void f() throws FileNotFoundException {}
	// 6 public void f() throws FileNotFoundException, InternalError {}

}

class Quest {
	private int qQ;

	public Quest(int q) {
		qQ = 12 / q;// 1
	}

	public int getQQ() {
		return qQ;// 2
	}

	public static void main(String[] args) {
		Quest quest = null;
		try {
			quest = new Quest(0);// 3
		} catch (Exception e) {// 4
		}
		System.out.println(quest.getQQ());// 5 java.lang.NullPointerException
	}
}
///////////////////////

// What two changes can you do, independent of each other,
// to make the following code compile:
// assume appropriate imports
class PortConnector {

	public PortConnector(int port) throws IOException {
		if (Math.random() > 0.5) {
			throw new IOException();
		}

		throw new RuntimeException();
	}
}

class TestClass {

	public static void main(String[] args) throws IOException {
		try {
			PortConnector pc = new PortConnector(10);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
}

/////////////////////
/*
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10 at
 * exeption.TestClass2.doTest(Exeption1.java:127) at
 * exeption.TestClass2.main(Exeption1.java:119)
 */
class TestClass2 {
	public static void main(String[] args) {
		try {
			doTest();
		} catch (MyException me) {
			System.out.println(me);
		}
	}

	static void doTest() throws MyException {
		int[] array = new int[10];
		array[10] = 1000;
		doAnotherTest();
	}

	static void doAnotherTest() throws MyException {
		throw new MyException("Exception from doAnotherTest");
	}
}

class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}

////////////////////////////////////
// Loop Lable line
// In Finally
class TestClass3 {
	public static void main(String args[]) {
		int i = 0;
		loop: // 1
		{
			System.out.println("Loop Lable line");
			try {
				for (; true; i++) {
					if (i > 5)
						break loop; // 2
				}
			} catch (Exception e) {
				System.out.println("Exception in loop.");
			} finally {
				System.out.println("In Finally"); // 3
			}
		}
	}
}
//Обход запрета на расширение множества 
//выбрасываемых исключений при перекрытии метода
class A1 {
	// выбрасывает только Error или RuntimeException:
	void m() {}
}
class B1 extends A1 {
	void m()  { // перекрытие метода m класса A
		try {
			// выброс исключения
			throw new IOException(); 
		} catch (Exception e) { // перехват исключения
			// выброс нового исключения
			throw new Error(e);
		}

	}
	public static void main(String[] args) {
		B1 b = new B1();
		try {
			// метод выбросит исключение Error:
			b.m();

		} catch (Throwable t) { // перехват исключения

			// извлечение исходного исключения
			Throwable cause = t.getCause();

			 // напечатает java.io.IOException:
			System.out.println(cause);
		} 

	}
}

