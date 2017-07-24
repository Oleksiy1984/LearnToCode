package serialization;

public class Mamal {
	public int mamal=1;
	Mamal(int i){
		
		System.out.println("In Parent constructor (...)");
	}
	Mamal(){
		this.mamal=111;
		System.out.println("In Parent default constructor");
	}
	{
		System.out.println("In Parent block init");
	}
	static
	{
		System.out.println("In Parent static block init");
	}

}
