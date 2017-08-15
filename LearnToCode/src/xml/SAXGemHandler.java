package ua.nure.orlovskyi.Practice7.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.orlovskyi.Practice7.constants.Constants;
import ua.nure.orlovskyi.Practice7.entity.Gem;
import ua.nure.orlovskyi.Practice7.entity.VisualParameters;

public class SAXGemHandler extends DefaultHandler {
	private List<Gem> data;
	private VisualParameters visualParameters;
	private Gem gem;
	private String currentElement = "";
	private StringBuilder currentText;

	public List<Gem> readDataFromXML(String filename, boolean validate)
			throws IOException, ParserConfigurationException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);

		
		try {
			// set validation
			if (validate) {
				factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
				factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
			}

			SAXParser parser = factory.newSAXParser();
			parser.parse(new File(filename), this);
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}

	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Start document");
		data = new ArrayList<Gem>();
	}

	@Override
	public void endDocument() throws SAXException {
		//System.out.println("End document");
	}

	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement = qName;

		switch (currentElement) {
		case "Gem":
			break;

		case "gem":
			gem = new Gem();
			String idAsString = attributes.getValue(Gem.ID);
			gem.setIdentity(idAsString);
			data.add(gem);
			break;

		case VisualParameters.VISUAL_PARAMETERS:
			visualParameters = new VisualParameters();
			gem.getSet().add(visualParameters);
			break;
			
		default:
			currentText = new StringBuilder();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (currentElement.equals("Gem") || currentElement.equals("gem")) {
			return;
		}

		String content = currentText.toString();
		switch (currentElement) {
		case Gem.NAME:
			gem.setName(content);
			break;

		case Gem.PRECIOUSNESS:
			gem.setPreciousness(content);
			break;

		case Gem.ORIGIN:
			gem.setOrigin(content);
			break;

		case VisualParameters.COLOR:
			visualParameters.setColor(content);
			break;

		case VisualParameters.TRANSPARENCY:
			visualParameters.setTransparency(Integer.parseInt(content));
			break;

		case VisualParameters.FACETS:
			visualParameters.setFacets(Integer.parseInt(content));
			break;

		case Gem.VALUE:
			gem.setValue(Double.parseDouble(content));
			break;

		default:
			break;
		}

		currentElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentText != null) {
			currentText.append(ch, start, length);
		}
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error!");
	}
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("Fatal error!");
	}
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("Warning!");
	}
}
