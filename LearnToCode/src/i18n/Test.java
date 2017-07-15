package i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Test {
}

// A Locale object represents a specific geographical, political, or cultural
// region.
// Locale(String language, String country, String variant)
class Locale1 {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale.getDisplayLanguage());// русский
		System.out.println(locale.getLanguage());// ru
		System.out.println(locale.getDisplayCountry());// Россия
		System.out.println(locale.getCountry());// RU
		System.out.println(locale.getVariant());
		Locale locale2 = new Locale("uk", "UA");
		Locale.setDefault(locale2);
		locale = Locale.getDefault();
		System.out.println(locale.getDisplayLanguage());// українська
		System.out.println(locale.getLanguage());// uk
		System.out.println(locale.getDisplayCountry());// Україна
		System.out.println(locale.getCountry());// UA
		System.out.println(locale.getVariant());
	}
}

// NumberFormat helps you to format and parse numbers for any locale
class NumberFormat1 {
	public static void main(String[] args) throws ParseException {
		Locale locale = new Locale("uk", "UA");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		double d = 1465.456;
		// nf.setMaximumFractionDigits(2);
		String localeString = nf.format(d);
		System.out.println(localeString);// 1 465,46 грн. to locale specific string
		double c = (double) nf.parse(localeString);
		System.out.println(c);// 1465.46 to java number
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf2.format(d));// $1,465.46
	}
}

class DateFormat1 {
	public static void main(String[] args) throws ParseException {
		String df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(new Date());
		System.out.println(df);// July 15, 2017
		// субота, 15 липня 2017 р.
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL, new Locale("uk", "UA")).format(new Date()));
		// to java Date
		DateFormat df2 = DateFormat.getDateInstance();
		String myString = df2.format(new Date());
		Date myDate = df2.parse(myString);
		System.out.println(myDate);
		//15 июля 2017 г. 0:00:00 EEST
		DateFormat us = DateFormat.getDateTimeInstance(0, 0, new Locale("ru", "RU"));
		System.out.println(us.format(myDate));

	}
}
