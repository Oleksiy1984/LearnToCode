package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Book implements Comparable<Book>{
	
	public Book(String author) {
		this.author = author;
	}

	String author;
	
	@Override
	public String toString() {
		return "Book [author=" + author + "]";
	}

	
	
//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		return true;
	}




	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		list.add(new Book("z"));
		list.add(new Book("o"));
		list.add(new Book("a"));
		list.add(new Book("c"));
		Collections.sort(list, new BookComparator()); //1 case use own comparator
		Collections.sort(list);//2 case imlemenenrs Comparable/compareTo
		System.out.println(list);
		
		Set<Book> set = new TreeSet<>();//uses Comparable interface
		set.add(new Book("a"));
		set.add(new Book("a"));
		System.out.println(set);//[Book [author=a]]
		
		Set<Book> set2 = new HashSet<>();//uses Equals and Hashcode
		set2.add(new Book("a"));
		set2.add(new Book("a"));
		System.out.println(set2);//[Book [author=a]]
		
		
	}

	@Override
	public int compareTo(Book o) {
		
		return this.author.compareTo(o.author);
	}
}
class BookComparator implements Comparator<Book>{
	@Override
	public int compare(Book o1, Book o2) {
		return o1.author.compareTo(o2.author);
	}
}