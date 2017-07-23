package io;

import java.io.IOException;
import java.util.Scanner;

/**
 * ������� ������, ������� ����� �� ����� ���������� �������� �������
 * �����/������ � Java (2): InputStreamReader OutputStreamWriter 3) Reader 4)
 * Writer InputStream OutputStream �� ������� �������� �������� �������
 * �����-������ ��� ����������� ������: InputStream � OutputStream. �� �������
 * �������� ���������� ������� �����-������ ��� ����������� ������: Reader �
 * Writer. InputStreamReader � ����� �����, ������� ��������� ����� � �������.
 * OutputStream Writer � ����� �����, ������� ��������� ������� � �����. �����:
 * 3,4.
 *
 */
public class TestIO {
	/**
	 * 
	 * ��� �������� ������, �� ������� ��������� ������ sc1, ��������� � �����
	 * System.in. ���������� ���������� � ������� ���� ���������� �����������.
	 * �����: 4. 
	 * 4) ���������� ���� ������������ �������, � ��� ������ ���������
	 * ��������� �������������� ��������;
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
