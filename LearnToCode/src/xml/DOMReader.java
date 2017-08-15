package ua.nure.orlovskyi.Practice7.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.nure.orlovskyi.Practice7.entity.Gem;
import ua.nure.orlovskyi.Practice7.entity.VisualParameters;

public class DOMReader {

	Document doc = null;


	public List<Gem> getDataFromXML(String filename) {

		List<Gem> data = new ArrayList<Gem>();

		File xmlFile = new File(filename);
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e.getMessage());
		}

		NodeList list = doc.getElementsByTagName("gem");

		for (int i = 0; i < list.getLength(); i++) {
			Gem gem = new Gem();
			data.add(gem);

			Element gemElement = (Element) list.item(i);
			String idAsString = gemElement.getAttribute(Gem.ID);
			gem.setIdentity(idAsString);

			gem.setName(getTextFromRepeatedElement(gemElement, Gem.NAME, 0));
			gem.setOrigin(getTextFromRepeatedElement(gemElement, Gem.ORIGIN, 0));
			gem.setValue(Double.parseDouble(getTextFromRepeatedElement(gemElement, Gem.VALUE, 0)));
			gem.setPreciousness(getTextFromRepeatedElement(gemElement, Gem.PRECIOUSNESS, 0));

			NodeList listVisualParameters = gemElement.getElementsByTagName(VisualParameters.VISUAL_PARAMETERS);

			for (int j = 0; j < listVisualParameters.getLength(); j++) {
				VisualParameters visualParameters = new VisualParameters();
				visualParameters.setColor(getTextFromRepeatedElement(gemElement, VisualParameters.COLOR, j));
				visualParameters.setFacets(
						Integer.parseInt(getTextFromRepeatedElement(gemElement, VisualParameters.FACETS, j)));
				visualParameters.setTransparency(
						Integer.parseInt(getTextFromRepeatedElement(gemElement, VisualParameters.TRANSPARENCY, j)));
				gem.getSet().add(visualParameters);
			}
		}

		return data;

	}

	private String getTextFromRepeatedElement(Element gemElement, String elementName, int numberRepeated) {
		Element node = (Element) gemElement.getElementsByTagName(elementName).item(numberRepeated);
		String content = node.getTextContent();
		return content;
	}
}
