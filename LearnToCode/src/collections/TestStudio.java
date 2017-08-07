package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TestStudio {

	public static void main(String[] args) {
		/**
		 * E ceiling(E e) 
          Returns the least element in this 
          set greater than or equal to the given 
          element, or null if there is no such element. 
 E floor(E e) 
          Returns the greatest element in this set
           less than or equal to the given element, 
           or null if there is no such element. 
 E higher(E e) 
          Returns the least element in this 
          set strictly greater than the given 
          element, or null if there is no such element. 
 E lower(E e) 
          Returns the greatest element in this 
          set strictly less than the given element, 
          or null if there is no such element. 


Note that methods of NavigableMap 
(such as ceilingEntry(), ceilingKey(), floorEntry(),
 floorKey() etc.) also work exactly the same way.
		 */
			NavigableSet<String> myset = new TreeSet<String>();
			myset.add("a");
			myset.add("b");
			myset.add("c"); 
			myset.add("aa"); 
			myset.add("bb"); 
			myset.add("cc");
			System.out.println(myset);//[a, aa, b, bb, c, cc]
			System.out.println(myset.floor("a"));//a
			System.out.println(myset.ceiling("aaa"));//b
			System.out.println(myset.lower("a") );//null
			System.out.println(myset.higher("bb"));//c
/////////////////////////////////////////////////////////
		/**
		 * TreeSet is a NavigableSet and so it supports subSet() method :
		 * 
		 * NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement,
		 * boolean toInclusive) Returns a view of the portion of this set whose elements
		 * range from fromElement to toElement.
		 * 
		 * The returned subset is backed by the original set. So if you insert or remove
		 * an element from the subset, the same will be reflected on the original set.
		 * 
		 * Further, since the subset is created using a range (fromElement to
		 * toElement), the element that you are inserting must fall within that range.
		 * Otherwise an IllegalArgumentException is thrown with a message "key out of
		 * range.". This is what is happening in this question. The range of subs is 326
		 * to 328 and 329 is out of that range. Therefore, an IllegalArgumentException
		 * is thrown at runtime.
		 */
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for (int i = 324; i <= 328; i++) {
			s.add(i);
		}
		subs =  (TreeSet) s.subSet(326, true, 328, true);
		//subs.add(329);// java.lang.IllegalArgumentException
		System.out.println(s + " " + subs);
		/////////////////////
		Deque<Integer> d = new ArrayDeque<>(1);
		d.add(1);
		d.addFirst(2);
		d.pop();
		d.offerFirst(3);
	}

	/**
	 * List<? extends Number> 
	 * Read it aloud like this: A List containing instances
	 * of Number or its subclass(es). This will allow you to retrieve Number objects
	 * because the compiler knows that this list contains objects that can be
	 * assigned to a variable of class Number. However, you cannot add any object to
	 * the list because the compiler doesn't know the exact class of objects
	 * contained by the list so it cannot check whether whatever you are adding is
	 * eligible to be added to the list or not.
	 */
	public void m1(List<? extends Number> list) {
		// list.add(new Integer(5));// compile error
		Number n = list.get(0);
	}
	/**
	 * List<?>
	 * This is same as List<? extends Object>. Read it aloud like this: A List
	 * containing instances of some class that extends Object class. Thus, this will
	 * not allow you to add anything to it because the compiler doesn't know the
	 * exact class of objects contained by the list so it cannot check whether
	 * whatever you are adding is eligible to be added to the list or not. Further,
	 * this will only allow you to do this: Object o = list.get(index); because all
	 * the compiler knows is that this list contains objects.
	 */
	
//BUT
	/**
	 * List<? super Number> 
	 * Read it aloud like this: A List containing instances of
	 * Number or its super class(es). Thus, this will allow you to do this:
	 * list.add(new Integer(10)); because Integer 
	 * can be assigned to a variable of
	 * type Number or its super class, but it will not allow you to retrieve
	 * anything other than Object: Object obj = list.get(i); because the compiler
	 * doesn't know the exact class of objects contained by list.
	 */
	public void m2(List<? super Number> list) {
		 list.add(new Integer(5));
		//Number n = list.get(0);// compile error
		 Object d = list.get(0);
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
 * import java.util.*; 
 * class Request { } 
 * class RequestCollector{ 
 * //1 : Insert declaration here 
 * public synchronized void addRequest(Request r){
 * container.add(r); } 
 * public synchronized Request getRequestToProcess(){ 
 * return container.poll(); } } 
 * 
 * What can be inserted at //1?
 * Queue<Request> container = new LinkedList<Request>();
 * Since the return type of getRequestToProcess() method is Request,
 * and the return statement does not have a cast,
 * it means that container must be a typed generic collection
 * that returns Request objects only. Further, the use of poll() 
 * method indicates that it must be a Queue.  
 * Both LinkedList and PriorityQueue classes implement Queue interface.
 */

/**
 * Deque is an important interface for the exam. To answer the questions, you
 * must remember that a Deque can act as a Queue as well as a Stack. Based on
 * this fact, you can deduce the following: 
 * 1. Since Queue is a FIFO structure
 * (First In First Out i.e. add to the end and remove from the front), it has
 * methods offer(e)/add(e)(for adding an element to the end or tail) and
 * poll()/remove()(for removing an element from the front or head) for this
 * purpose.  Note that offer and add are similar while poll and remove are
 * similar. 
 * 2. Since Stack is a LIFO structure (Last In First Out i.e. add to
 * the front and remove from the front), it provides methods push(e) and pop()
 * for this purpose, where push adds to the front and pop removes from the
 * front. Besides the above methods, Deque also has variations of the above
 * methods. But it is easy to figure out what they do: pollFirst()/pollLast() -
 * poll is a Queue method. Therefore pollFirst and pollLast will remove elements
 * from the front and from the end respectively. removeFirst()/removeLast() -
 * These are Deque specific methods. They will remove elements from the front
 * and from the end respectively. These methods differ from pollFirst/pollLast
 * only in that they throw an exception if this deque is empty.
 * offerFirst(e)/offerLast(e) - offer is a Queue method. Therefore offerFirst
 * and offerLast will add elements to the front and to the end respectively.
 * addFirst(e)/addLast(e) - add is a Queue method. Therefore addFirst and
 * addLast will add elements to the front and to the end respectively. 
 * peek(), peekFirst(): return the first element from the front of the queue but does
 * not remove it from the queue. 
 * peekLast() : returns the last element from the
 * end of the queue but does not remove it from the queue. 
 * element(): retrieves,
 * but does not remove, the head of the queue represented by this deque (in
 * other words, the first element of this deque). This method differs from peek
 * only in that it throws an exception if this deque is empty. Notice that there
 * is no pushFirst(e) and pushLast(e). You may wonder why there are multiple
 * methods for the same thing such as offer(e) and add(e). Well, they are not
 * exactly same. add(e) throws an exception if the element cannot be added to
 * the queue because of lack of capacity, while offer(e) does not. There are
 * similar differences in other methods but they are not too important for the
 * exam.
 */
