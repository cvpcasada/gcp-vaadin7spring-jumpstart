package org.generationcp.ibpworkbench.views;

import org.generationcp.ibpworkbench.navigation.DynamicViewType;
import org.generationcp.ibpworkbench.navigation.ViewType;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView("dashboard")
@DynamicViewType(type=ViewType.SUB_CONTENT)
public class WorkbenchDashboardView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7785884242741408394L;

	public WorkbenchDashboardView() {
		this.addComponent(new Label("Workbench dashboard view"));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
