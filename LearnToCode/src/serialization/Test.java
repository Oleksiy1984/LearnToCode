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
