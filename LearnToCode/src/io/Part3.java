package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	
	Part3(String fileName) {
		setFileName(fileName);
	}

	private static final String ENCODING = "CP1251";
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private static final String REGEXP_FOR_INTEGER = "(^|\\s)(\\d+)(\\s|$)";
	private static final String REGEXP_FOR_DOUBLE = "(^|\\s)([\\d+]*\\.\\d+)(\\s|$)";
	private static final String REGEXP_FOR_CHAR = "(?i)(^|(?<=\\s))[a-z�-�]($|(?=\\s))";
	private static final String REGEXP_FOR_STRING = "[�-��-�a-zA-Z]{2,}";

	public String getString() {
		String str = null;
		try {
			Scanner sc = new Scanner(new File(getFileName()), ENCODING);
			while (sc.hasNextLine()) {
				str = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(getFileName() + " not found");
		}
		return str;
	}

	public String integerValue() {
		StringBuilder sb = new StringBuilder();
		Pattern p1 = Pattern.compile(REGEXP_FOR_INTEGER);
		Matcher m = p1.matcher(getString());
		while (m.find()) {
			sb.append(m.group(2) + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public String doubleValue() {
		StringBuilder sb = new StringBuilder();
		Pattern p2 = Pattern.compile(REGEXP_FOR_DOUBLE);
		Matcher m2 = p2.matcher(getString());
		while (m2.find()) {
			sb.append(m2.group(2) + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);

	}

	public String charValue() {
		StringBuilder sb = new StringBuilder();
		Pattern p3 = Pattern.compile(REGEXP_FOR_CHAR);
		Matcher m3 = p3.matcher(getString());
		while (m3.find()) {
			sb.append(m3.group() + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);

	}

	public String stringValue() {
		StringBuilder sb = new StringBuilder();
		Pattern p4 = Pattern.compile(REGEXP_FOR_STRING);
		Matcher m4 = p4.matcher(getString());
		while (m4.find()) {
			sb.append(m4.group() + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);

	}

	public void input() {
		Scanner sc = new Scanner(System.in, ENCODING);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			if ("int".equals(str)) {
				System.out.println(integerValue());
			} else if ("double".equals(str)) {
				System.out.println(doubleValue());
			} else if ("char".equals(str)) {
				System.out.println(charValue());
			} else if ("String".equals(str)) {
				System.out.println(stringValue());
			} else if ("stop".equals(str)) {
				System.out.println("End of input");
				return;
			} else {
				System.out.println("No such element");
			}
		}
	}

	public static void main(String[] args) {
		Part3 part3 = new Part3("test1.txt");
		part3.input();

	}
}
