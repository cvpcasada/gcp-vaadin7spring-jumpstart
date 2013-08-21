package org.generationcp.ibpworkbench;


import org.generationcp.ibpworkbench.navigation.DynamicViewDisplay;
import org.springframework.context.annotation.Scope;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


@org.springframework.stereotype.Component
@Scope("prototype")
@Theme("gcp-default")
public class IBPWorkbenchApp extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3830710180146664628L;
	public static Navigator navigator;
	
	@Override
	protected void init(VaadinRequest request) {
		
		navigator = new ru.xpoft.vaadin.DiscoveryNavigator(this,new DynamicViewDisplay());
        
		// TODO Auto-generated method stub
		setSizeFull();
	}
}
