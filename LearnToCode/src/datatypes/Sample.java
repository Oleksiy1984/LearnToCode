package datatypes;

public class Sample {
	void s(int... a) {
		System.out.println("massiv");
	}

	void s(long a, long b) {
		System.out.println("long");
	}

	void s(Integer a, Integer b) {
		System.out.println("Integer");
	}

	void test(int... a) {
		for (int s : a) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		int theInt = 1, b = 1;
		char theChar='d';
		short theShort =5;
		double theDouble=1.5;
		float theFloat = 45;
		Sample s = new Sample();
		s.s(theInt, b);// long
		s.test(1, 2, 3);// 123
		s.test();// empty
		
		long theLong = theInt;
		theInt=(int) theLong;
		
		theInt=theChar;
		theChar=(char) theInt;

		theInt=theShort;
		theShort=(short) theInt;
		
		theDouble=theInt;
		theDouble=1.9;
		theInt=(int) theDouble;
		System.out.println(theInt);//1
		
		theDouble = theFloat;
		theFloat=(float) theDouble;
		
	}

}
