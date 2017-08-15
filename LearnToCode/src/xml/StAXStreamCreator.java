package ua.nure.orlovskyi.Practice7.stax;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javanet.staxutils.IndentingXMLStreamWriter;
import ua.nure.orlovskyi.Practice7.entity.Gem;
import ua.nure.orlovskyi.Practice7.entity.VisualParameters;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class StAXStreamCreator {

	private static final String namespaceURI ="http://www.w3.org/2001/XMLSchema-instance";
	

	public void createDocument(List<Gem> data, String filename) throws XMLStreamException, IOException {
		
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		factory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
		OutputStream out = new FileOutputStream(filename);
		XMLStreamWriter w = factory.createXMLStreamWriter(out, "UTF-8");
		
		IndentingXMLStreamWriter writer = new IndentingXMLStreamWriter(w);
		writer.writeStartDocument("UTF-8", "1.0");
		writer.writeStartElement("Gem");
				writer.writeNamespace("xsi", namespaceURI);
		writer.writeAttribute(namespaceURI, "noNamespaceSchemaLocation",
		        "noNamespaceInput.xsd");
		
		for (Gem gem : data) {
			createGemElement(writer, gem);
		}
		
		writer.writeEndElement();
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
		
	}

	private void createGemElement(XMLStreamWriter writer, Gem gem) 
			throws XMLStreamException {
		writer.writeStartElement("gem");
		writer.writeAttribute(Gem.ID, gem.getIdentity());
		writeDataElement(writer, gem.getName(), Gem.NAME);
		writeDataElement(writer, gem.getPreciousness(), Gem.PRECIOUSNESS);
		writeDataElement(writer, gem.getOrigin(), Gem.ORIGIN);
		for (VisualParameters visualParameter : gem.getSet()) {
			writer.writeStartElement(VisualParameters.VISUAL_PARAMETERS);
			writeDataElement(writer, visualParameter.getColor(), VisualParameters.COLOR);
			writeDataElement(writer, Integer.toString(visualParameter.getTransparency()), VisualParameters.TRANSPARENCY);
			writeDataElement(writer, Integer.toString(visualParameter.getFacets()), VisualParameters.FACETS);
			writer.writeEndElement();
		}
		writeDataElement(writer, Double.toString(gem.getValue()), Gem.VALUE);
		writer.writeEndElement();
	}

	private void writeDataElement(XMLStreamWriter writer, String value, String elementName)
			throws XMLStreamException {
		writer.writeStartElement(elementName);
		writer.writeCharacters(value);
		writer.writeEndElement();
	}

}
