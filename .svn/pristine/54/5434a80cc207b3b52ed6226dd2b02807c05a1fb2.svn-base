package be.steformations.pc.client;

import com.google.gwt.event.dom.client.ClickEvent;

import be.steformations.pc.client.ui.HelloUI;

public class HelloController
	implements com.google.gwt.event.dom.client.ClickHandler {

	private HelloUI ui;
	
	public HelloController(HelloUI ui) {
		super();
		this.ui = ui;
		this.ui.getClickSource().addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		String message = "hello " + this.ui.getNameInput().getText();
		com.google.gwt.user.client.Window.alert(message);
	}
}
