package serialization;

import java.io.Serializable;

public class Animal extends Mamal implements Serializable {
	private static final long serialVersionUID = 2L;
	private transient String name;
	private transient int age = 10;
	private static char type = 'C';
	private final int  added=22;
	Cat cat;

	static{
		System.out.println("In Animal static block init");
	}
	{
		System.out.println("In Animal block init");
		this.age = 14;
	}

	public Animal() {
		System.out.println("In Animal constructor ()");
		this.name = "Unknown";
		this.age = 12;
		this.type = 'Q';
	}

	public Animal(String name, int age, char type) {
		
		System.out.println("In Animal constructor (...)");
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getType() {
		return type;
	}

	public String toString() {
		return "Animal [Added= "+added+" Cat="+cat+", name=" + name + ", age=" + age + ", type=" + type + "]";
	}
}
