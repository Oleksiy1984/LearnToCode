package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Укажите классы, которые стоят во главе символьной иерархии потоков
 * ввода/вывода в Java (2): 
 * InputStreamReader 
 * OutputStreamWriter 
 * 3) Reader 
 * 4) Writer 
 * InputStream 
 * OutputStream 
 * На вершине иерархии байтовых потоков
 * ввода-вьюода два абстрактных класса: InputStream и OutputStream. На вершине
 * иерархии символьных потоков ввода-вывода два абстрактных класса: Reader и
 * Writer. InputStreamReader — поток ввода, который переводит байты в символы.
 * OutputStream Writer — поток ввода, который переводит символы в байты. Ответ:
 * 3,4.
 *
 */
public class TestIO {
	/**
	 * 
	 * При закрытии потока, на который указывает ссылка sc1, закроется и поток
	 * System.in. Дальнейшее считывание с помощью него становится невозможным.
	 * Ответ: 4. 4) компиляция кода осуществится успешно, а при работе программы
	 * возникнет исключительная ситуация;
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(System.in);
		int x1 = 0;
		x1 = sc1.nextInt();
		sc1.close();
		int x2 = 0;
		x2 = System.in.read();
		System.out.println(x1 + " " + (char) x2);

	}
	/**
	 * Укажите классы байтовых потоков ввода-вывода, для которых не существует
	 * аналогичных классов в символьной иерархии потоков ввода-вывода: 
	 * 1) DataInputStream 
	 *  InputStreamReader 
	 * 3) ObjectOutputStream 
	 *   StringWriter
	 * Классы InputStreamReader и StringWriter относятся к 
	 * символьным потокам ввода-вывода.
     * Ответ: 1, 3.
	 */

	
}

/**
 * Компиляция каких строк приведет к ошибке?
 * Для классов ByteArrayInputStream InputStreamReader, BufferedReader
 * не предусмотрены конструкторы, принимающие параметр типа File.
 * Ответ: 2, 3, 4.
 *
 */
class Quest7 {
	public static void main(String[] args) throws IOException {
		File file = new File("files.tl.txt");
		FileWriter obj1 = new FileWriter(file); //1
		// ByteArrayInputStream obj2 = new ByteArrayInputStream(file);//2
		//InputStreamReader obj3 = new InputStreamReader(file);//3
		// BufferedReader obj4 = new BufferedReader(file);//4
		PrintWriter obj5 = new PrintWriter(file); // 5
	}
}
class SysoutToFile{
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Print on console");

        // Store console print stream.
        PrintStream ps_console = System.out;

        // Create new print stream for file.
        PrintStream ps = new PrintStream(
        		new FileOutputStream(
        				new File("test1.txt")));

        // Set file print stream.
        System.setOut(ps);
        System.out.println("Print in the file !!");

        // Set console print stream.
        System.setOut(ps_console);
        System.out.println("Console again !!");
		
	}
}







