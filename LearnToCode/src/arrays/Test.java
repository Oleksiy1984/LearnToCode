package arrays;

public class Test {

	public static void main(String[] args) {
		int[] f = new int[] { 1, 2, 3 };
		// int[] f1=new int[3] {1,2,3}; error

		int[] masl = new int[24];
		Integer mas2[] = new Integer[24];
		// Type mismatch: cannot convert from Character[] to char[]
		// char [] mas3 = new Character [] {'a', 'b', 'c'};
		Character[] mas4 = new Character[] { 'a', 'b', 'c' };
		// Syntax error on token(s), misplaced construct(s)
		// Item [] mas4 = new Item {new Item (), new Item ()};
		double[] mas5 = { 5, 10, 15, 20 };
		int[] mas6[] = new int[4][5];
		int mas7[][] = new int[4][];

	}

}

class Item {
}