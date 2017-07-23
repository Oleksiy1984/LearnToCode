package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("(1*)0");
		Matcher m = p.matcher("111110");
		//Начальное состояние Matcher не определено
		//поэтому будет java.lang.IllegalStateException
		//Нужно вызвать методы обработчики
		// m.find(); or 
		m.lookingAt();
		System.out.println(m.group(1));

	}

}
