package collections;
import java.util.List;

class Booby {}
class Dooby extends Booby {}
class Tooby extends Dooby {}
public class TestClass {
	Booby b = new Booby();
	Tooby t = new Tooby();
	public void addData1(List<? super Dooby> dataList) {
		//if super we can add Dooby or its subclasses
		dataList.add(t);
		dataList.add(new Dooby());
		//dataList.add(new Object()); compile error
		//dataList.add(b); compile error
		
		Object obj  =dataList.get(0);
		//t or b= dataList.get(0); compile error
	}
	public void addData2(List<? extends Dooby> dataList) {
		//if extends we can get Dooby or its superclass
		b = dataList.get(0);
		Dooby fgf = dataList.get(0);
		//dataList.add(new Dooby()); compile error
		//t = dataList.get(0);//Type mismatch: cannot convert
		//from capture#3-of ? extends Dooby to Tooby
		Object obj  =dataList.get(0);
	}
}
/**
 * 1. addData1(List<? super Dooby> dataList) : 
 * This means that dataList is a
 * List whose elements are of a class that is either 
 * or a super class of Dooby. 
 * We don't know which super class of Dooby. 
 * Thus, if you try to add any
 * object to dataList, it has to be a assignable to Dooby. 
 * Thus, dataList.add(b); will be invalid 
 * because b is not assignable to Dooby.
 * Further, if you try to take 
 * some object out of dataList, that object will be
 * of a class that is either Dooby or a Superclass of Dooby. 
 * Only way you can
 * declare a variable that can be assigned the 
 * object retrieved from dataList is
 * Object obj. 
 * Thus, t = dataList.get(0); and b = dataList.get(0); 
 * are both invalid. 
 * 
 * 2. addData2(List<? extends Dooby> dataList) 
 * This means that dataList
 * is a List whose elements are of a class that 
 * is either Dooby or a subclass of
 * Dooby. Since we don't know which subclass 
 * of Dooby is the list composed of,
 * there is no way you can add any object 
 * to this list. If you try to take some
 * object out of dataList, that object will 
 * be of a class that is either Dooby
 * or a subclass of Dooby and thus it can 
 * be assigned to a variable of class
 * Dooby or its superclass.. 
 * Thus, t = dataList.get(0) ; is invalid.
 */
