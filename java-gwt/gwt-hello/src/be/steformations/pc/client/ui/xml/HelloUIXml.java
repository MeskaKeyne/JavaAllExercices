package be.steformations.pc.client.ui.xml;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.pc.client.ui.HelloUI;

public class HelloUIXml extends Composite implements HelloUI {

	interface HelloUIXmlUiBinder extends UiBinder<Widget, HelloUIXml> {
	}

	private static HelloUIXmlUiBinder uiBinder = GWT.create(HelloUIXmlUiBinder.class);

	@UiField com.google.gwt.user.client.ui.TextBox nameInput;
	@UiField com.google.gwt.user.client.ui.Button goButton; 
	@UiField com.google.gwt.user.client.ui.FlowPanel panel; 
	
	public HelloUIXml() {
		GWT.log("HelloUIXml.HelloUIXml()");
		initWidget(uiBinder.createAndBindUi(this));
		this.nameInput.setText("betty boop !");
	}

	@Override
	public HasText getNameInput() {
		return this.nameInput;
	}

	@Override
	public HasClickHandlers getClickSource() {
		return this.goButton;
	}

	@Override
	public Widget getWidget() {
		return this.panel;
	}
}
