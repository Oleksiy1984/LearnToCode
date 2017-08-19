package xml;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SimpleTransform {
	public static void main(String[] args) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();

			// установка используемого XSL-преобразования
			Transformer transformer = tf.newTransformer(new StreamSource("students.xsl"));

			// установка исходного XML-документа и конечного XML-файла
			//transformer.transform(new StreamSource("students.xml"), new StreamResult("newstudents.xml"));

			//create a StringWriter for the output
			StringWriter outWriter = new StringWriter();
			StreamResult result = new StreamResult( outWriter );
			
			transformer.transform( new StreamSource("students.xml"), result );  
			StringBuffer sb = outWriter.getBuffer(); 
			String finalstring = sb.toString();

			System.out.print(finalstring);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
