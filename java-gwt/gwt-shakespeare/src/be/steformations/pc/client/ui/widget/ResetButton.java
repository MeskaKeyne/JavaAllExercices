package be.steformations.pc.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.pc.client.event.EventManager;
import be.steformations.pc.client.event.reset.ResetEvent;
import gwt.material.design.client.ui.MaterialButton;

public class ResetButton extends MaterialButton implements ClickHandler {

	@UiConstructor
	public ResetButton(String text) {
		GWT.log("ResetButton.ResetButton()");
		this.setText(text);
		this.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		GWT.log("ResetButton.onClick()");
		ResetEvent resetEvent = new ResetEvent();
		EventManager.getInstance().fireEvent(resetEvent);
	}
}
