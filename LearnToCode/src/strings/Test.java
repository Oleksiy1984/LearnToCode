package strings;

import sun.applet.Main;

public class Test {

	public static void main(String[] args) {
		String a = "abc";
		a.charAt(2);// c
		a.length();// 3

		String s2 = null;
		s2 = s2 + "34"; // s = "null34"
		Integer i = null;
		s2 = "abc" + i; // s = "abcnull"

		String s11 = "abc";
		String s22 = "abc";
		boolean flag = (s11 == s22); // flag = true

		String s = "abc";
		String s4 = new String("abc");
		boolean f = s == s4; // f = false
		System.out.println(f);
		s4 = s4.intern();
		System.out.println(s4 == s);// true
	}
}

class Intern {
	public static void main(String[] args) {
		String s1 = "abc", s2 = "ab";
		boolean flag = (s1 == "abc"); // flag = true
		flag = ((s1 + "") == "abc"); // flag = false
		flag = ((s1 + "").intern() == "abc"); // flag = true

		flag = (s1 == "ab" + "c"); // flag = true
		System.out.println(flag);
		flag = (s1 == s2 + "c"); // flag = false
		System.out.println(flag);
		flag = (s1 == (s2 + "c").intern()); // flag = true
		System.out.println(flag);

	}
}

class Substring {
	public static void main(String[] args) {
		String f = "012345";
		System.out.println(f.substring(4));// 45
		System.out.println(f.substring(1, 4));// 123
		// java.lang.StringIndexOutOfBoundsException
		// System.out.println(f.substring(4,1));
		// System.out.println(f.substring(4,10));

	}
}

class CompareTo {
	public static void main(String[] args) {
		String s1 = "A";
		String s2 = "Z";

		// public int compareTo(String another)
		// отрицательное целое число, если this лексикографически
		// предшествует строке another;
		int k = s1.compareTo(s2);
		System.out.println(k);//-25

		// public int compareTo(String another)
		// положительное целое число, если this лексикографически
		//следует за строкой another.
		int k1 = s2.compareTo(s1);
		System.out.println(k1);//25

	}
}
class Concat{
	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "567";
		String another=s1.concat(s2);
		System.out.println(another); // 123567
		System.out.println(s1); // 123
		s2=null;
		//java.lang.NullPointerException
		//s1.concat(s2);

	}
}
class Replace{
	public static void main(String[] args) {
		String s = "123";
		String s1 = s.replace('1', 'A');
		System.out.println(s1); // 123 
		System.out.println(s); // 123 

	}
}
class Constructors{
	public static void main(String[] args) {
		//public String(char[] value, int offset,int count)
		char[] c = {'0','1','2','3','4','5'};
		String a = new String(c,1,3);
		System.out.println(a);//123
	}
}
