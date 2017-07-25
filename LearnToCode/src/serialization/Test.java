package serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		B b = new B();
		B newB=null;
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File("a.bin"))))) {
				out.writeObject(b);
		}
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("a.bin")))) {
			while (true) {
				Object object = in.readObject();
				 newB= (B) object;
			System.out.println(newB);
			}
		} catch (EOFException e) {
			// File end reached
		}

	}

}
class A1{
    public int iPublic;
    protected int iProtected;
    int iPackage;
    private int iPrivate;
}

class B1 extends A1 implements Serializable{}
////////////////////////////////////
//При десериализации производного класса, наследуемого 
//от несериализуемого класса, 
//вызывается конструктор без параметров 
//родительского несериализуемого класса.
//После десериализации
//B b.a=1 ; b.b = 3;
class A {
	public int a = 0;
	public A() {
		a = 1;
	}
}

class B extends A implements Serializable {
	public int b = 0;
	public B() {
		a = 2;
		b = 3;
	}
}
//////////////////////
/*
 * Which of the following are true statements about serialization in Java? (Choose all that apply.)
A. The process of converting serialized data back into memory is called deserialization.
B. All non-thread classes should be marked Serializable.
C. The Serializable interface requires implementing serialize() and deserialize()
methods.
D. The Serializable interface is marked final and cannot be extended.
E. The readObject() method of ObjectInputStream may throw a ClassNotFoundException
even if the return object is not explicitly cast.
A, E. The first statement is the definition of deserialization,
 so A is correct. B is incorrect,
because you may mark (or not mark) 
a class as serializable for a variety of reasons. C is
incorrect because the Serializable interface has 
no method requirements, and any class
can implement the interface. D is also incorrect,
 because the Serializable interface may
be extended by your own interface. Finally, 
E is correct, because the exception may be
thrown within the readObject() even if the result is not cast.
 */
/*
 * What are the requirements for a class that you want to serialize with ObjectOutputStream?
(Choose all that apply.)
A. The class must implement the Serializable interface.
B. The class must extend the Serializable class.
C. The class must declare a static serialVersionUID variable.
D. All instance members of the class must be Serializable.
E. All instance members of the class must be marked transient.
F. Any class can be serialized with ObjectOutputStream.

A. 
First, the class must implement the Serializable interface, 
so A is correct. Serializable
is not a class; therefore B is incorrect.
 Creating a static serialVersionUID variable
is optional and recommended, but it is not required 
for use with the ObjectOutputStream,
so C is incorrect. 
Every instance variable must either be Serializable or be marked
transient, but all variables are not required to be either,
so D and E are incorrect. 
F is incorrect, because the class must be Serializable 
and have instance members that are
Serializable or marked transient.
 */
/*
 * 16. Why shouldn’t every class be marked Serializable? (Choose all that apply.)
A. The compiler will throw an exception if certain classes 
are marked Serializable.
B. Only final classes can be marked Serializable.
C. Classes can implement only one interface, so marking 
them Serializable would
prevent them from using any other interface.
D. The data of some classes cannot be easily serialized,
 such as those managing threads or
processes.
E. Only concrete classes can be marked Serializable.
F. Classes that store most of their data in static fields 
would not be easily serialized.
D, F. 
Any class, abstract, concrete, or final, can be marked Serializable,
 so A, B, and E
are incorrect. Classes can implement multiple interfaces,
 so C is also incorrect. D is correct,
because process-heavy classes would be difficult to serialize since
 it may involve managing
multiple threads. F is also correct because
 serialization of an object stores only the instance
variable data, not the static class data. In other words, 
serializing an object throws away
the static class data.
 */
/*
 * Assuming the following class has proper
 *  public getter/setter methods for all of its private
fields, which of the following fields will always be null 
after an instance of the class is
serialized and then deserialized? (Choose all that apply.)
public class Zebra implements Serializable {
private static final long serialUID = 1L;
private transient String name = "George";
private static String birthPlace = "Africa";
private transient Integer age;
private java.util.List<Zebra> friends = new java.util.ArrayList<>();
private Object tail = null;
{ age = 10;}
public Zebra() {
this.name = "Sophia";
}
}
A. name
B. tail
C. age
D. friends
E. birthPlace
F. The code does not compile.
G. The code compiles but throws an exception at runtime.

A, C. The code compiles and runs without issue,
 so F and G are incorrect. Note that serialUID
is not the same as serialVersionUID, 
although since serialVersionUID is recommended
but not required, this does not pose any compilation issues.
 Just be aware that
serialUID will not be used by the serialization process for version control.
 The name variable
and age variable are both transient, which means that their 
values will not be saved
upon serialization. 
Upon deserialization, the default initializations and constructor will be
skipped, and they will both be null; 
therefore A and C are correct. B is incorrect because
tail is not transient and could be set by a caller
 before being serialized. 
 D is also incorrect
because a serialized empty array is not the same
 as a null pointer. Even though these
non-transient fields could be set to null, 
they are not guaranteed to be null after deserialization.
E is incorrect because the static value will not be serialized;
 it will be available
on the class after deserialization.

*/
/*
 * What is the value of name after an instance of Eagle 
 * is serialized and then deserialized?
 * 
public class Bird implements Serializable {
protected transient String name = "Bridget";
public void setName(String name) { this.name = name; }
public String getName() { return name; }
public Bird() {
this.name = "Matt";
}
}
 */
