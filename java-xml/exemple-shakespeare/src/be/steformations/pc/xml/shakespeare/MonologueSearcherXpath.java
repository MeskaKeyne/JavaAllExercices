package be.steformations.pc.xml.shakespeare;

public class MonologueSearcherXpath 
	extends MonologueSearcherDom {

	private javax.xml.xpath.XPath xpath;
	
	public MonologueSearcherXpath() {
		super();
		this.xpath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
	}

	@Override
	protected org.w3c.dom.Node getGoodSpeechNode(org.w3c.dom.Document doc, 
			String role, String start) {
		org.w3c.dom.Node goodSpeech = null;
		
		String expression 
			= String.format("//SPEECH[SPEAKER='%s' and starts-with(LINE, '%s')]", 
					role.toUpperCase(), start);
		
		try {
			goodSpeech = (org.w3c.dom.Node) 
					this.xpath.evaluate(expression, doc, javax.xml.xpath.XPathConstants.NODE);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return goodSpeech;
	}
	
	
	
	
	
	
	
	
	
}
