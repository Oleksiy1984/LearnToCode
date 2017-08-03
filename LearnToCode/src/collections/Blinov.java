package collections;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public class Blinov {
	public static void main(String[] args) {
		Object ob = new HashSet();
	    System.out.print((ob instanceof Set)+",");//true
	    System.out.print(ob instanceof SortedSet);//false

	}

}
///////////////////////
/**
 * Интерфейс Set уникальность хранимых 
 * объектов определяет реализацией метода equals().
Ответ: 2.
 *
 */
class X {
	private int x;

	public X(int x) {
		this.x = x;
	}

	public int hashCode() {
		return 2;
	}
	public static void main(String[] args) {
		X objl = new X(1);
		X obj2 = new X(1); 
		Set<X> set = new HashSet<X>();
		set.add(objl); set.add(obj2);
		System.out.println(set.size());//2
	}
}
/////////////////////////
class ArList{
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add(null);
		list.add(null);
		System.out.println(list.lastIndexOf("1"));
		System.out.println(list.size()+list.toString());//2
		Iterator<String> itr = list.iterator(); 
        while(itr.hasNext()) {
            String e = itr.next();
            itr.remove();
        }
        System.out.println(list.size()+list.toString());//0
		
	}
}
//////////////////////////

enum PCounter {
	UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE
};

class Quest11 {
	public static void main(String[] args) {
		EnumSet<PCounter> enstl =
				EnumSet.range(PCounter.TRES, PCounter.CINCO);
		 EnumSet<PCounter> enst2 = EnumSet.complementOf(enstl);																// EnumSct.complementOJlomtiyj/2
	 System.out.println(enst2);
	 //[UNO, DOS, SEIS, SIETE]

	}
}
/**
 * Какие из фрагментов кода создадут объект класса ArrayList
 *  и добавят элемент ?(выберите 2) 
    ArrayList a = new ArrayList(); a[0]=''0''; 
    ArrayList a = new ArrayList(); a.addElement(''0''); 
 3.   ArrayList a = new ArrayList(10); a.add("0"); 
 4.   ArrayList a = new ArrayList(); a.add(''0'');  

 */

/**
 * Что из приведенного ниже являются интерфейсами пакета
 *  java/util ? (выберите 2) 
   HashMap 
   HashSet 
 3.  SortedSet 
   Stack 
   AbstactMap  
 6.  SortedMap 

 */
/*
 * Какой интерфейс наиболее пригоден для создания
 *  класса содержаще-го несортированные уникальные объекты? 
   List 
   Map  
   Vector  
   Нет правильного ответа 
 5.  Set  

 */
/**
 * Какой интерфейс реализует Hashtable ? 
   Vector 
   AbstractMap 
   List 
 4.  Map 
   Set 

 */
/**
 * Какой класс коллекции позволяет наращивать
 *  и сокращать размер, предоставляет индексный доступ к элементам,
 *   но его методы несинхронизированы (1)?
	java.util.HashSet
2)	java.util.ArrayList
	java.util.LinkedHashSet
 */
////////////////////////
/**
Algorithm           ArrayList   LinkedList
seek front            O(1)         O(1)
seek back             O(1)         O(1)
seek to index         O(1)         O(N)
insert at front       O(N)         O(1)
insert at back        O(1)         O(1)
insert after an item  O(N)         O(1)
 */
/**
 * 	
TL;DR ArrayList with ArrayDeque are preferable in much more use-cases than LinkedList. Not sure — just start with ArrayList.

LinkedList and ArrayList are two different implementations of the List interface. LinkedList implements it with a doubly-linked list. ArrayList implements it with a dynamically re-sizing array.

As with standard linked list and array operations, the various methods will have different algorithmic runtimes.

For LinkedList<E>

get(int index) is O(n/4) average
add(E element) is O(1)
add(int index, E element) is O(n/4) average
     but O(1) when index = 0 <--- main benefit of LinkedList<E>
remove(int index) is O(n/4) average
Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>
Note: O(n/4) is average, O(1) best case (e.g. index = 0), O(n/2) worst case (middle of list)

For ArrayList<E>

get(int index) is O(1) <--- main benefit of ArrayList<E>
add(E element) is O(1) amortized, but O(n) worst-case since the array 
must be resized and copied
add(int index, E element) is O(n/2) average
remove(int index) is O(n/2) average
Iterator.remove() is O(n/2) average
ListIterator.add(E element) is O(n/2) average
Note: O(n/2) is average, O(1) best case (end of list), O(n) worst case (start of list)
 */





