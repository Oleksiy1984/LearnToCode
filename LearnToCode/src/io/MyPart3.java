package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPart3 {

	private String dataString;

	public MyPart3() {
		this.dataString = readFile();
	}

	private String readFile() {
		System.out.println("READ FILE");
		StringBuilder result = new StringBuilder();
		try (Scanner sc = new Scanner(new File("part3.txt"))) {
			while (sc.hasNextLine()) {
				result.append(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
		return result.toString();
	}

	private String findDouble() {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("([\\d+]*\\.\\d+)");
		Matcher m = p.matcher(dataString);
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		return sb.toString().trim();
	}

	private String findInt() {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("(^|\\s)(\\d+)(\\s|$)");
		Matcher m = p.matcher(dataString);
		while (m.find()) {
			sb.append(m.group(2) + " ");
		}
		return sb.toString();
	}

	private String findString() {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("[À-ßà-ÿa-zA-Z]{2,}");
		Matcher m = p.matcher(dataString);
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		return sb.toString();
	}

	private String findChar() {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("(?i)(^|(?<=\\s))[a-zà-ÿA-ZÀ-ß]($|(?=\\s))");
		Matcher m = p.matcher(dataString);
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		return sb.toString();
	}

	public void start() {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String str = sc.nextLine();
				switch (str) {
				case "int":
					System.out.println(findInt());
					break;
				case "double":
					System.out.println(findDouble());
					break;
				case "String":
					System.out.println(findString());
					break;
				case "char":
					System.out.println(findChar());
					break;
				case "stop":
					System.exit(0);
				default:
					System.out.println("There is no such element");

				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyPart3 p = new MyPart3();
		p.start();

	}

}
