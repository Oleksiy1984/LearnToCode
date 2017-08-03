package collections;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<User> set = new HashSet<>();
		 Calendar calendar = new GregorianCalendar(1988, Calendar.JUNE, 19);
		    User user1 = new User("Pavel", 0, calendar);
		    User user2 = new User("Pavel", 0, calendar);
		    set.add(user1);
		    set.add(user2);
		    System.out.println("Size: "+set.size());
		    //equal+h => size= 1
		    // only h =>size=2
		    // only e (hash different) => size=2
		    
		    
		    System.out.println(user1.hashCode());
		    System.out.println(user2.hashCode());
	}

}
class User {
    public String name;
    public int children;
    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    

	@Override
	public int hashCode() {
		System.out.println("in hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + children;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (children != other.children)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
}
/**
 * Для методов equals и hashCode установлен определенный контракт:

1. если элементы равны между собой, т.е. equals возвращает true,
 то значение hashCode для этих объектов должно совпадать.
2. если значение hashCode для объектов совпадает, то это еще не значит,
 что equals для них вернет true, т.е. объекты не обязаны быть равны 
 между собой, т.е. возможны коллизии.
И так, рассмотрим хэш таблицу с bucket'ами. 
Она состоит из массива, в каждой ячейке которого хранится список элементов.

Когда мы добавляем элемент, для него вычисляется кэшкод,
 затем по определяется индекс ячейки, где должен хранится список,
  содержащий данный элемент:

index = hashcode % table_size
где table_size - это размер таблицы.

По индексу достается список, методом equals проверяется, 
содержится ли данный элемент в списке, если нет, то он добавляется.
Аналогично, выполняется операции remove, contains.

Теперь рассмотрим каждый случай по отдельности:

equals и hashCode не переопределены, это значит, 
что equals будет возвращать true только в случае если ссылки равны,
 а hashCode может быть как равен так и нет.
  Размер, не зависимо от значения hashCode, будет 2.
  
equals и hashCode переопределены,
 тогда у нас будет одинаковое хэш значение,
  мы попадем в одну и туже ячейку таблицы,
   equals определит, что объект в списке уже присутствует,
    соответственно размер будет равен 1.
    
equals непереопределен, а hashCode переопределен. 
В этом случае, индекс ячейки будет одним и тем же,
 но в списке не обнаружится одинакового элемента
  и по этому размер будет равен 2.
  
equals переопределен, а hashCode непереопределен. 
Здесь зависит того как генерируется значение для hashCode
 в классе Object. Если значения будут одинаковы,
  то список будет один и тот же, и соответсвенно,
   количество элементов в таблице будет 1. 
   
   Если разные, то поиск будет происходить в разных списках,
    и дубликатов не обнаружится, тогда размер будет равен 2.
 */
