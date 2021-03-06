package org.generationcp.ibpworkbench.views;

import org.generationcp.ibpworkbench.navigation.DynamicViewType;
import org.generationcp.ibpworkbench.navigation.ViewType;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView(WorkbenchDashboardView.VIEW_NAME)
@DynamicViewType(type=ViewType.SUB_CONTENT)
public class WorkbenchDashboardView extends VerticalLayout implements View {
	public static final String VIEW_NAME = "dashboard";
	/**
	 * 
	 */
	private static final long serialVersionUID = 7785884242741408394L;

	public WorkbenchDashboardView() {
		this.addComponent(new Label("Workbench dashboard view"));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification notification = new Notification("Sample Error Notification",Notification.Type.TRAY_NOTIFICATION);
		notification.setPosition(Position.TOP_CENTER);
		notification.show(Page.getCurrent());
	}

}
