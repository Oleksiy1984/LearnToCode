package strings;

public class Another {
	public static String hello="hello";
	public static String by="by";

	public static void main(String[] args) {
		System.out.println(Another.hello==Test.hello);//true
		System.out.println(Another.by==Test.by);//false
		System.out.println(Another.by==Test.by.intern());//true
		System.out.println(Another.by==Test.by);//false
	}

}
