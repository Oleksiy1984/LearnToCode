package enum1;

public enum Str {
	S(1), D(2) {
		public int tt() {
			return 44;
		}
	},
	F("F") {
		public int tt() {
			return 55;
		}
	};

	int i;

	static int k = 7;

	static {
		System.out.println("static block " + k);
	}

	int tt() {
		return 33;
	}

	Str(String g) {
		System.out.println("CONSTRUCTOR " + g);
	}

	Str(int i) {

		this.i = tt();

	}

	{
		System.out.println("non-static");
	}

	public static void main(String... strings) {
		System.out.println(Str.S.i);
//		System.out.println(Str.D.i);
//		System.out.println(Str.F.i);
	}
}
