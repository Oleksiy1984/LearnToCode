package i18n;

import java.util.ListResourceBundle;

public class Zoo extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			 { "hello", "Hello. Zoo.java" },
			 { "open", "The zoo is open. Zoo.java" },
			 { "close", "Close. Zoo.java" }
};
	}

}
