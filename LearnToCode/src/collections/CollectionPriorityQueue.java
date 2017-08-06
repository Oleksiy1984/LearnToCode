package collections;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class CollectionPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		for (int i = 10; i > -1; i--) {
			pq1.add(i);
		}
		System.out.println(pq1.poll());// 0
		System.out.println(pq1.remove());// 1

		System.out.println(pq1.peek());// 2
		System.out.println(pq1);// [2, 3, 5, 4, 8, 9, 6, 10, 7]

		for (int i = 0; i < 10; i++) {
			System.out.print(pq1.poll() + " ");//2 3 4 5 6 7 8 9 10 null
		}
		System.out.println("\n---------------------------------");

		PriorityQueue<String> pqs = new PriorityQueue<>();
		
			pqs.add("a");
			pqs.add("aa");
			pqs.add("A");
			pqs.add("AA");
			pqs.add("AB");
		
		for (int i = 0; i < 6; i++) {
			System.out.print(pqs.poll() + " ");//A AA AB a aa null
		}
		
		
		PriorityQueue<LocalDate> pq = new PriorityQueue<>();
		pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
		 pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
		 pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
		 pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse
		
		 System.out.println("Iterating over elements...");
		 for (LocalDate date : pq)
		 System.out.println(date);
		 System.out.println("Removing elements...");
		 while (!pq.isEmpty())
		 System.out.println(pq.remove());//1815-12-10
		 //1903-12-03
		 //1906-12-09
		 //1910-06-22
		}
	}


