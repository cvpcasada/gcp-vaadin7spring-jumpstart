package org.generationcp.ibpworkbench.views;

import org.generationcp.ibpworkbench.navigation.DynamicViewType;
import org.generationcp.ibpworkbench.navigation.ViewType;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView("")
@DynamicViewType(type=ViewType.MAIN_CONTENT)
public class LoginView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -197897912496717920L;

	public LoginView() {
		this.addComponent(new Label("Login View"));
		
		this.addComponent(new Link("Got To Dashboard",new ExternalResource("#!dashboard")));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
