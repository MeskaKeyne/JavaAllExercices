package be.steformations.pc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import be.steformations.pc.client.ui.material.DateFormatterMaterial;

public class DateFormatEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		DateFormatterMaterial ui  = new DateFormatterMaterial();
		new DateFormatController(ui);
		RootLayoutPanel.get().add(ui);
	}

}
