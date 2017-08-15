package ua.nure.orlovskyi.Practice7.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import ua.nure.orlovskyi.Practice7.entity.Gem;
import ua.nure.orlovskyi.Practice7.entity.VisualParameters;



public class StAXEventReader {

	private VisualParameters visualParameters;

	public List<Gem> getDataFromXML(String filename) throws FileNotFoundException, XMLStreamException {

		List<Gem> data = new ArrayList<>();
		Gem gem = null;

		InputStream in = new FileInputStream(new File(filename));
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		
		int eventType = reader.next();
		
		while (reader.hasNext()) {
			eventType = reader.next();
			
			if (eventType == XMLEvent.START_ELEMENT) {
				
				String elementName = reader.getName().toString();
				
				switch (elementName) {
				
				case "gem":
					gem = new Gem();
					data.add(gem);
					gem.setIdentity(reader.getAttributeValue("", Gem.ID));
					break;
					
				case VisualParameters.VISUAL_PARAMETERS:
					visualParameters = new VisualParameters();
					gem.getSet().add(visualParameters);
					break;
					
				case Gem.NAME:
					gem.setName(reader.getElementText());
					break;

				case Gem.ORIGIN:
					gem.setOrigin(reader.getElementText());
					break;
					
				case Gem.PRECIOUSNESS:
					gem.setPreciousness(reader.getElementText());
					break;
					
				case Gem.VALUE:
					gem.setValue(Double.parseDouble(reader.getElementText()));
					break;

				case VisualParameters.COLOR:
					visualParameters.setColor(reader.getElementText());
					break;
					
				case VisualParameters.FACETS:
					visualParameters.setFacets(Integer.parseInt(reader.getElementText()));
					break;
					
				case VisualParameters.TRANSPARENCY:
					visualParameters.setTransparency(Integer.parseInt(reader.getElementText()));
					break;
					
				default:
					break;
				}
				
			}
		}
		
		return data;
	}

}
