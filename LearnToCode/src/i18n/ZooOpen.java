package i18n;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpen extends ResourceBundle.Control{

	public static void main(String[] args) {
		/*
		 * Zoo_en_US.properties 
		 * Zoo_en.java > Zoo_en.properties
		 * 
		 * Zoo_ru_RU.properties
		 * Zoo_ru.properties
		 * 
		 * Zoo_uk_UA.java > Zoo_uk_UA.properties
		 * Zoo_uk.properties
		 * 
		 * Zoo.java > Zoo.properties
		 * 
		 */
/*
		//1. Локаль по умолчанию ru-RU. 
		//Загружаем левое new Locale("es","ES") или деф локаль
		//1) Zoo_ru_RU.properties
		//2) Zoo_ru.properties
		//3) Zoo.java
		//Zoo.properties НЕ ЗАГРУЖАЮТСЯ ОНИ ПЕРЕКРЫТЫ КЛАССОМ!
		ResourceBundle rb = ResourceBundle
				.getBundle("i18n.Zoo");//, new Locale("es","ES"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		System.out.println(rb.getString("close"));

		*/
		/*
		//2. Локаль по умолчанию "en","US". - без разницы
		//Загружаем Locale("uk","UA")
		//1) Zoo_uk_UA.java
		//2) Zoo_uk.properties
		//3) Zoo.java
		Locale.setDefault(new Locale("en","US"));
				ResourceBundle rb2 = ResourceBundle
						.getBundle("i18n.Zoo", new Locale("uk","UA"));
				System.out.println(rb2.getString("hello"));
				System.out.println(rb2.getString("open"));
				System.out.println(rb2.getString("close"));
				*/
		
		//3. Локаль по умолчанию "en","US". - без разницы
				//Загружаем Locale("en","GB")
				//1) Zoo_en.java
				//2) Zoo.java
		Locale.setDefault(new Locale("en","US"));
		ResourceBundle rb3 = ResourceBundle
				.getBundle("i18n.Zoo", new Locale("en","GB"));
		System.out.println(rb3.getString("open"));
		System.out.println(rb3.getString("close"));
	
		//java.util.MissingResourceException
	//System.out.println(rb3.getString("visitor"));
		
		  
		 
	}

}