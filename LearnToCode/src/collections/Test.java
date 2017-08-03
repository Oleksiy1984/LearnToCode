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
 * ��� ������� equals � hashCode ���������� ������������ ��������:

1. ���� �������� ����� ����� �����, �.�. equals ���������� true,
 �� �������� hashCode ��� ���� �������� ������ ���������.
2. ���� �������� hashCode ��� �������� ���������, �� ��� ��� �� ������,
 ��� equals ��� ��� ������ true, �.�. ������� �� ������� ���� ����� 
 ����� �����, �.�. �������� ��������.
� ���, ���������� ��� ������� � bucket'���. 
��� ������� �� �������, � ������ ������ �������� �������� ������ ���������.

����� �� ��������� �������, ��� ���� ����������� ������,
 ����� �� ������������ ������ ������, ��� ������ �������� ������,
  ���������� ������ �������:

index = hashcode % table_size
��� table_size - ��� ������ �������.

�� ������� ��������� ������, ������� equals �����������, 
���������� �� ������ ������� � ������, ���� ���, �� �� �����������.
����������, ����������� �������� remove, contains.

������ ���������� ������ ������ �� �����������:

equals � hashCode �� ��������������, ��� ������, 
��� equals ����� ���������� true ������ � ������ ���� ������ �����,
 � hashCode ����� ���� ��� ����� ��� � ���.
  ������, �� �������� �� �������� hashCode, ����� 2.
  
equals � hashCode ��������������,
 ����� � ��� ����� ���������� ��� ��������,
  �� ������� � ���� � ���� ������ �������,
   equals ���������, ��� ������ � ������ ��� ������������,
    �������������� ������ ����� ����� 1.
    
equals ���������������, � hashCode �������������. 
� ���� ������, ������ ������ ����� ����� � ��� ��,
 �� � ������ �� ����������� ����������� ��������
  � �� ����� ������ ����� ����� 2.
  
equals �������������, � hashCode ���������������. 
����� ������� ���� ��� ������������ �������� ��� hashCode
 � ������ Object. ���� �������� ����� ���������,
  �� ������ ����� ���� � ��� ��, � �������������,
   ���������� ��������� � ������� ����� 1. 
   
   ���� ������, �� ����� ����� ����������� � ������ �������,
    � ���������� �� �����������, ����� ������ ����� ����� 2.
 */
