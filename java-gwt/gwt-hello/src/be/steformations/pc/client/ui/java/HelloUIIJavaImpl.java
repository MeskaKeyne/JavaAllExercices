package be.steformations.pc.client.ui.java;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.pc.client.ui.HelloUI;

public class HelloUIIJavaImpl implements HelloUI {

	private com.google.gwt.user.client.ui.TextBox nameInput; // <input type="text">
	private com.google.gwt.user.client.ui.Button goButton; // <input type="button">
	private com.google.gwt.user.client.ui.FlowPanel panel; // <div> display: inline-box 
	
	public HelloUIIJavaImpl() {
		super();
		this.nameInput = new com.google.gwt.user.client.ui.TextBox();
		this.goButton = new com.google.gwt.user.client.ui.Button("go");
		this.panel = new com.google.gwt.user.client.ui.FlowPanel();
		
		this.panel.add(nameInput);
		this.panel.add(goButton);
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
