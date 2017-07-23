package io;

import java.io.IOException;
import java.util.Scanner;

/**
 * Укажите классы, которые стоят во главе символьной иерархии потоков
 * ввода/вывода в Java (2): InputStreamReader OutputStreamWriter 3) Reader 4)
 * Writer InputStream OutputStream На вершине иерархии байтовых потоков
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
	 * Ответ: 4. 
	 * 4) компиляция кода осуществится успешно, а при работе программы
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

}
