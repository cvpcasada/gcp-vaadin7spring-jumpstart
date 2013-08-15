package org.generationcp.ibpworkbench.navigation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;

public class DynamicViewDisplay implements ViewDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 62566424211049979L;
	
	HorizontalSplitPanel mainContentPanel = new HorizontalSplitPanel();
	VerticalSplitPanel rootVSPanel = new VerticalSplitPanel();
	
	Panel fullScreenContentPanel = new Panel();
	
	public DynamicViewDisplay() {
		rootVSPanel.setFirstComponent(new Label("Header Panel is here"));
		
		rootVSPanel.setSecondComponent(mainContentPanel);
		
		fullScreenContentPanel.setSizeFull();
	}
	
	
	@Override
	public void showView(View view) {
		if (!(view instanceof Component)) {
			throw new IllegalArgumentException();
		}
		
		DynamicViewType dynamicViewAnnotation = view.getClass().getAnnotation(DynamicViewType.class);
		
		if (dynamicViewAnnotation == null)
			UI.getCurrent().setContent((Component) view);;
		
		switch (dynamicViewAnnotation.type()) {
			case MAIN_CONTENT:
				fullScreenContentPanel.setContent((Component) view);
				
				UI.getCurrent().setContent(fullScreenContentPanel);
				
				break;
			case SUB_CONTENT:
				mainContentPanel.setSecondComponent((Component) view);
				
				UI.getCurrent().setContent(rootVSPanel);
				
				break;
		}
		
	}

}
