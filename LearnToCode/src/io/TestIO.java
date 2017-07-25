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
////////////////////////
/**
 * Which classes will allow the following to compile? (Choose all that apply.)
InputStream is = new BufferedInputStream(new FileInputStream("zoo.txt"));
InputStream wrapper = new (is);
A. BufferedInputStream
B. FileInputStream
C. BufferedWriter
D. ObjectInputStream
E. ObjectOutputStream
F. BufferedReader

A, D. The reference is for an InputStream object, 
so only a high-level input Stream class
is permitted. 
B is incorrect because FileInputStream is a low-level stream that interacts
directly with a file resource, not a stream resource. 
C and F are incorrect because you cannot
use BufferedReader/BufferedWriter directly on a stream. 
E is incorrect because
the reference is to an InputStream, not an OutputStream. 
A and D are the only correct
options. Note that a BufferedInputStream can be wrapped 
twice, since high-level streams
can take other high-level streams.
 */
/*
 * 13. Which of the following are built-in streams in Java? (Choose all that apply.)
A. System.err
B. System.error
C. System.in
D. System.input
E. System.out
F. System.output


A, C, E. 
The System class has three streams:
 in is for input,
  err is for error, 
  and out is for output. 
  Therefore A, C, and E are correct. The others do not exist.
 */

/*
 * 14. Which of the following are not java.io classes? (Choose all that apply.)
A. BufferedReader
B. BufferedWriter
C. FileReader
D. FileWriter
E. PrintReader
F. PrintWriter

E. PrintWriter is the only Writer class that 
you need to know that doesn’t have a complementary
Reader class, so E is correct.
 */
/*
 * Assuming zoo-data.txt is a multiline text file, what is true of the following method?
private void echo() throws IOException {
try (FileReader fileReader = new FileReader("zoo-data.txt");
BufferedReader bufferedReader = new BufferedReader(fileReader)) {
System.out.println(bufferedReader.readLine());
}
}
A. It prints the first line of the file to the console.
B. It prints the entire contents of the file.
C. The code does not compile because the reader is not closed.
D. The code does compile, but the reader is not closed.
E. The code does not compile for another reason.

A. This code compiles and runs without issue,
 so C and E are incorrect. It uses a try-withresource
block to open the FileReader and BufferedReader objects.
Therefore, both get
closed automatically, and D is incorrect. 
The body of the try block reads in the first line
of the file and outputs it to the user. 
Therefore, A is correct. Since the rest of the file is not
read, B is incorrect.
 */

/*
 * Which of the following stream classes are high-level? (Choose all that apply.)
A. ObjectInputStream
B. PrintStream
C. FileWriter
D. PrintWriter
E. OutputStream
F. FileInputStream
G. ObjectOutputStream

A, B, D, G. ObjectOutputStream and ObjectInputStream 
perform serialization and
deserialization on a low-level stream, 
respectively, so A and G are correct. PrintStream
and PrintWriter format text for a low-level OutputStream 
and Writer, respectively, so
B and D are also correct. FileWriter and FileInputStream 
operate on a file directly and
are low-level streams, so C and F are incorrect. 
Finally, OutputStream is an abstract parent
class and is neither high-level nor low-level, so E is incorrect.
 */

/*
 * Suppose that you need to write data that consists of int, 
 * double, boolean, and String values to
a file that maintains the format of the original data. 
For performance reasons, you also want to
buffer the data. Which three java.io classes can be chained
 together to best achieve this result?
A. FileWriter
B. FileOutputStream
C. BufferedOutputStream
D. ObjectOutputStream
E. DirectoryStream
F. PrintWriter
G. PipedOutputStream

B, C, D.
 Since you need to write primitives and String values,
  the OutputStream classes
are appropriate. Therefore, you can eliminate A and F 
since they are not OutputStream
classes. Next, DirectoryStream is not a java.io class, 
so E is incorrect. As you shall see
in the next chapter, DirectoryStream is an NIO.2 class. 
The data should be written to the
file directly using the FileOutputStream class,
 buffered with the BufferedOutputStream
class and automatically serialized with the ObjectOutputStream class,
 so B, C, and D are
correct. G is incorrect because it is not related
 to this task. We include it as an option to
help you adapt to situations on the exam where you may come
 across a class with which
you are not familiar. 
Just answer as best you can, based on what you know.
 */
/**
 * What are some reasons to use a character stream,
 *  such as Reader/Writer, over a byte
stream, such as InputStream/OutputStream? (Choose all that apply.)
A. More convenient code syntax when working with String data
B. Improved performance
C. Automatic character encoding
D. Built-in serialization and deserialization
E. Character streams are high-level streams
F. Multi-threading support

A, C. Character stream classes often include built-in 
convenience methods for working with
String data, so A is correct. 
They also handle character encoding automatically, so C is
also correct. 
The rest of the statements are irrelevant or incorrect
 and are not properties of
all character streams.
 */
/*
 * Assume that you have an InputStream whose next bytes are XYZABC.
 *  What is the result of
calling the following method on the stream, 
using a count value of 3?
public static String pullBytes(InputStream is, int count) throws IOException
{
is.mark(count);
final StringBuilder sb = new StringBuilder();
for(int i=0; i<count; i++)
sb.append((char)is.read());
is.reset();
is.skip(1);
sb.append((char)is.read());
return sb.toString();
}
A. It will return a String value of XYZ.
B. It will return a String value of XYZA.
C. It will return a String value of XYZX.
D. It will return a String value of XYZB.
E. It will return a String value of XYZY.
F. The code does not compile.
G. The code compiles but throws an exception at runtime.
H. The result cannot be determined with the information given.

H. 
Not all java.io streams support the mark() operation; 
therefore, without calling markSupported() on the stream,
 the result is unknown until runtime. If the stream does support
the mark() operation, then the result would be XYZY,
 because the reset() operation
puts the stream back in the position before the mark() was called,
 and skip(1) will skip
X, and E would be correct. 
If the stream does not support the mark() operation,
 a runtime
exception would likely be thrown,
 and G would be correct. Since you don’t know if the
input stream supports the mark() operation,
 H is the only correct choice.
 */
