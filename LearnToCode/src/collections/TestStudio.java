package collections;

public class TestStudio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/////////////////////////
/**
 * The signature of a method in a class is as follows:  
 * public static <E extends CharSequence> List<? super E> doIt(List<E> nums) 
 *  This method is being called in the following code:
 *  result = doIt(in);  Given that String implements 
 *  CharSequence interface, 
 * what should be the reference type of 'in' and 'result' variables?
 * 
 * ArrayList<String> in; List result;
 * 
 * The input parameter has been specified as List<E>, 
 * where E has to be some class that extends CharSequence.
 * So ArrayList<String>, List<String>, or List<CharSequence> are all valid 
 * as reference types for 'in'.  
 * The output type of the method has been specified as List<? super E> 
 * , which means that it is a List that contains objects of some class
 *  that is a super class of E. Here, E will be typed to whatever
 *   is being used for 'in'. For example, if you declare ArrayList<String>
 *    in, E will be String.  The important concept here 
 *    once the method returns, there is no way to know what is the exact
 *     class of objects stored in the returned List.
 *     So you cannot declare out in a way that ties it to
 *     any particular class, not even Object.  
 *     Thus, the only way to accomplish this is to either 
 *     use non-typed reference type, such as: 
 *      List result; or use the same type as the return type mentioned
 *      in the method signature i.e. List<? super String> 
 * (because E will be bound to String in this case.)
 * 
 */

/**
 * For Collections.sort(List<T> ) method to sort
 * a Collection of any class T, that class must implement
 *  java.lang.Comparable interface. 
 *  This interface has only one method: public int compareTo(T o),
 *  where T is same as the class to which Comparable is typed.
 *  In this case, since we want to sort Food instances,
 *  you can type Comparable to Food i.e. Comparable<Food>
 *  and therefore, the method parameter will be Food i.e.
 *  public int compareTo(Food f).  
 *  In cases where a class does not implement Comparable 
 *  or when you want to sort instances based on a different order 
 *  than the one provided by the class's compareTo method, 
 *  you can use another class that implements Comparator interface 
 *  to sort your collection. For example, if you want to sort 
 *  Food instances based on calories instead of name, 
 *  you can do it like this: 
 *  Comparator<Food> c = new Comparator<Food>(){    
 *  public int compare(Food o1, Food o2) {                 
 *  return o1.caloriesPerServing - o2.caloriesPerServing;             
 *  } }; and then use 
 *  Collections.sort(List<T>, Comparator<? super T>) method:  
 *  Collections.sort(al, c)
 *  
 *  public class Food implements Comparable<Food>{  // LINE 1   
 *  String name;   
 *  int caloriesPerServing;   
 *  public Food(String name, int calories){     
 *  this.name = name; 
 *  this.caloriesPerServing = calories;   }   
 *  //accessors not shown    
 *  
 *  //LINE 2 
 *  public int compareTo(Food f){   
 *  return this.name.compareTo(f.name); }
 *  }  
 *  
 *  This class is used in an application as follows -  
 *  ArrayList<Food> al = new ArrayList<>(); 
 *  //code that adds Food objects to al not shown 
 *  Collections.sort(al);
 *  
 *  
 */
/**
 * You are designing a class that will cache objects. 
 * It should be able to store and retrieve an object when 
 * supplied with an object identifier.
Further, this class should work by tracking the 
"last accessed times" of the objects. 
Thus, if its capacity is full, it should remove only 
the object that hasn't been accessed the longest.

Which collection class would you use to store the objects?

The LinkedHashMap class maintains the elements in the order
of their insertion time. This property can be used 
to build the required cache as follows:
1. Insert the key-value pairs as you do normally where key will
be the object identifier and value will be the object to be cached.
2. When a key is requested, remove it from the LinkedHashMap 
and then insert it again. This will make sure that 
this pair marked as inserted latest.
3. If the capacity is full, remove the first element.

Note that you cannot simply insert the key-value again
 (without first removing it) because a reinsertion operation 
 does not affect the position of the pair.
 */

/**
 * 
 */
