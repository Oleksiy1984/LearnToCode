package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyPart3 {

	public static String readFile(String trigger) throws FileNotFoundException {
		StringBuilder result = new StringBuilder();

		switch (trigger) {
		case "int":
			try (Scanner sc = new Scanner(new File("test1.txt"))) {
				sc.useLocale(Locale.US);
				while (sc.hasNext()) {
					if (sc.hasNextInt()) {
						result.append(sc.nextInt() + " ");
					}
					sc.next();
				}
			}
			break;
		case "double":
			try (Scanner sc = new Scanner(new File("test1.txt"))) {
				//sc.useLocale(Locale.US);
				Pattern p1 = Pattern.compile("(^|\\s)([\\d+]*\\.\\d+)(\\s|$)");
				while (sc.hasNext()) {
					if(sc.hasNext(p1)) {
						return result.append(sc.next() + " ").toString();
					}
					sc.next();
				}
			}
			break;
		case "String":
			try (Scanner sc = new Scanner(new File("test1.txt"))) {
				sc.useLocale(Locale.US);
				while (sc.hasNext()) {
					if (!sc.hasNextDouble() && !sc.hasNextDouble()) {
						Pattern p = Pattern.compile("[Р-пр-џ\\w]{2,}");
						if (sc.hasNext(p)) {
							result.append(sc.next() + " ");
						}
					}
					sc.next();
				}
			}
			break;
		case "char":
			try (Scanner sc = new Scanner(new File("test1.txt"))) {
				sc.useLocale(Locale.US);
				while (sc.hasNext()) {
					Pattern p1 = Pattern.compile("(?:(?:^|\\s)([a-zA-Zр-џР-п])(?=\\s))", Pattern.MULTILINE);
					if (sc.hasNext(p1)) {
						result.append(sc.next() + " ");
					}
					sc.next();
				}
			}
			break;
		}

		return result.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String str = sc.nextLine();
				switch (str) {
				case "int":
					System.out.println(readFile("int"));
					break;
				case "double":
					System.out.println(readFile("double"));
					break;
				case "String":
					System.out.println(readFile("String"));
					break;
				case "char":
					System.out.println(readFile("char"));
					break;
				default:
					System.out.println("No such element");

				}

				// if ("int".equals(str)) {
				// System.out.println(integerValue());
				// } else if ("double".equals(str)) {
				// System.out.println(doubleValue());
				// } else if ("char".equals(str)) {
				// System.out.println(charValue());
				// } else if ("String".equals(str)) {
				// System.out.println(stringValue());
				// } else if ("stop".equals(str)) {
				// System.out.println("End of input");
				// return;
				// } else {
				// System.out.println("No such element");
				// }
			}
		}

	}

}
