package serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Create new Animal 
 * In Parent static block init 
 * In Animal static block init 
 * In Parent block init 
 * In Parent default constructor 
 * In Animal block init 
 * In Animal constructor (...) 
 * Deserialze 
 * In Parent block init 
 * In Parent default constructor
 * [Animal [Added= 22 Cat=null, name=null, age=0, type=T]] 
 * In Parent block init
 * In Parent default constructor Mamal=111
 * 
 *
 */
public class ObjectStreamSample {
	public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Animal)
					animals.add((Animal) object);
			}
		} catch (EOFException e) {
			// File end reached
		}
		return animals;
	}

	public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animal animal : animals)
				out.writeObject(animal);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>();
		System.out.println("Create new Animal");
		animals.add(null);// ignored due to (object instanceof Animal)
		Animal newAnimal = new Animal("Tommy Tiger", 5, 'T');
		newAnimal.mamal = 100;
		animals.add(newAnimal);
		// animals.add(new Animal("Peter Penguin", 8, 'P'));
		File dataFile = new File("animal.data");
		createAnimalsFile(animals, dataFile);
		System.out.println("Deserialze");
		System.out.println(getAnimals(dataFile));
		animals = getAnimals(dataFile);
		Animal animal = animals.get(0);
		System.out.println("Mamal=" + animal.mamal);// 111
		// [Animal [Added= 22 Cat=null, name=null, age=0, type=T]]
	}
}
