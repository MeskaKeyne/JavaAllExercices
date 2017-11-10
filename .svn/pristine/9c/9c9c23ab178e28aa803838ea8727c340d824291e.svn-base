package be.steformations.pc.xml.shakespeare;

import be.steformations.java_xml.shakespeare.SpeechConcatenator;

public class SpeechConcatenatorImpl implements SpeechConcatenator {

	@Override
	public String concatenateLines(String xml) {
		String concat = null;
		org.w3c.dom.Node speechNode = XmlConverter.string2Node(xml);
		if (speechNode != null) {
			concat = this.concatenateLines(speechNode);
		}
		return concat;
	}
	
	public String concatenateLines(org.w3c.dom.Node speechNode) {
		String concat = null;
		
		try {
			if (speechNode != null) {
				StringBuilder builder = new StringBuilder();
				
				boolean complete = false;
				org.w3c.dom.NodeList children = speechNode.getChildNodes();
				for (int i = 0; !complete && i < children.getLength(); i++) {
					org.w3c.dom.Node child = children.item(i);
					if (child.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
						if (child.getNodeName().equals("LINE")) {
							builder.append(child.getTextContent())
								.append(System.lineSeparator());
						} else if (child.getNodeName().equals("STAGEDIR")
									|| child.getNodeName().equals("SUBHEAD")
								) {
							complete = true;
						}
					}
				}
				
				concat = builder.toString();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return concat;
	}

}
