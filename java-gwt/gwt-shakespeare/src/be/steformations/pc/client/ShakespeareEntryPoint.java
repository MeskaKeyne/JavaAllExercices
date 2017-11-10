package be.steformations.pc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import be.steformations.pc.client.http.Searcher;
import be.steformations.pc.client.ui.UiPanel;

public class ShakespeareEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		GWT.log("ShakespeareEntryPoint.onModuleLoad()");
		
		UiPanel panel = new UiPanel();
		RootLayoutPanel.get().add(panel);
		
		new Searcher();
		
	}

}
