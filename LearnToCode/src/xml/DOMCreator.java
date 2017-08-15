package ua.nure.orlovskyi.Practice7.dom;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.nure.orlovskyi.Practice7.entity.Gem;
import ua.nure.orlovskyi.Practice7.entity.VisualParameters;

public class DOMCreator {

	private List<Gem> data;

	private Document doc = null;

	private static final String namespaceURI = "http://www.w3.org/2001/XMLSchema-instance";

	public DOMCreator(List<Gem> data) {
		this.data = data;
	}

	public Document createXMLDoc() throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();
		Element root = doc.createElement("Gem");
		root.setAttributeNS(namespaceURI, "xsi:noNamespaceSchemaLocation", "noNamespaceInput.xsd");
		doc.appendChild(root);

		for (Gem gem : data) {
			Element gemElement = addElement(root, "gem", "");
			gemElement.setAttribute(Gem.ID, gem.getIdentity());

			addElement(gemElement, Gem.NAME, gem.getName());
			addElement(gemElement, Gem.PRECIOUSNESS, gem.getPreciousness());
			addElement(gemElement, Gem.ORIGIN, gem.getOrigin());
			for (VisualParameters visualParameter : gem.getSet()) {
				Element vpElement = addElement(gemElement, VisualParameters.VISUAL_PARAMETERS, "");
				addElement(vpElement, VisualParameters.COLOR, visualParameter.getColor());
				addElement(vpElement, VisualParameters.TRANSPARENCY,
						Integer.toString(visualParameter.getTransparency()));
				addElement(vpElement, VisualParameters.FACETS, Integer.toString(visualParameter.getFacets()));
			}
			addElement(gemElement, Gem.VALUE, Double.toString(gem.getValue()));
		}

		return doc;
	}

	private Element addElement(Element parent, String elementName, String textValue) {
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}

	/**
	 * Save DOM to XML.
	 * 
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public void saveTo(String xmlFileName) throws ParserConfigurationException, TransformerException {

		DOMSource source = new DOMSource(createXMLDoc());
		StreamResult result = new StreamResult(new File(xmlFileName));
		getTransformer().transform(source, result);
	}

	private static Transformer getTransformer() throws TransformerConfigurationException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		return transformer;
	}

}
