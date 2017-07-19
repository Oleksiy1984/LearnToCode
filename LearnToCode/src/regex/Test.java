package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
/*
 * Начальное состояние объекта типа Matcher неопределенно
 * java.lang.IllegalStateException, поэтому до вызова ме-
тода group() на объекте необходимо вызвать любой из методов обработчиков (напри-
мер. Find() или lookingAt()

 */
	public static void main(String[] args) {

		Pattern p = Pattern.compile("(1*)0");
		Matcher m = p.matcher("111110");
		m.find();
		System.out. println(m.group(1));

		Pattern p1 = Pattern.compile("c.*(?=bb{1,})");
		Matcher m1 = p1.matcher("aabccabbbccbbb");
		m1.find();
		System.out. println(m1.group());//ccabbbccb
	}

}
