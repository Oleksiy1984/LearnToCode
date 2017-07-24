package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		int[] buffer = { 128, 250, 430, 520, 820 };

		try (PrintWriter out = new PrintWriter(new File("test11.txt"), "Cp1251");
				DataInputStream dis = new DataInputStream(
						new FileInputStream("test1.txt"))	
				) {

			// for each int in int buffer
//			for (int j : buffer) {
//
//				// write int to data output stream
//				out.println(j);
//			}

			// force data to the underlying file output stream
			//dos.flush();
			Scanner sc = new Scanner(new File("test1.txt"));
			//sc.useDelimiter("\\s");
			while(sc.hasNext())
			{
				//System.out.println(sc.next());
				if(sc.hasNextInt())
				 System.out.println(sc.nextInt());
				sc.next();
			}
		  
		

			// available stream to be read
//			while (true) {
//
//				// read four bytes from data input, return int
//				int k = dis.readInt();
//
//				// print int
//				System.out.print(k + " ");
//			}

		} catch (Exception e) {

			// if any error occurs
			e.printStackTrace();
		}

	}
}
