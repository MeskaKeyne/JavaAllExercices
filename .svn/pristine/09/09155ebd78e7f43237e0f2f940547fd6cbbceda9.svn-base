package be.steformations.pc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import be.steformations.pc.client.ui.HelloUI;
import be.steformations.pc.client.ui.xml.HelloUIXml;

public class HelloEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() { // main
		// sysout dans la console javascript du navigateur
		com.google.gwt.core.client.GWT.log("HelloEntryPoint.onModuleLoad()");

		// HelloUI ui = new HelloUIIJavaImpl();
		HelloUI ui = new HelloUIXml();
		new HelloController(ui);
		
		// accrochage au Dom Html
		RootLayoutPanel.get().add(ui.getWidget()); // RootLayoutPanel =~ <body>
	}

}
