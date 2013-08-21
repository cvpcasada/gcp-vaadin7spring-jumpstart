package org.generationcp.ibpworkbench.views;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.generationcp.ibpworkbench.navigation.DynamicViewType;
import org.generationcp.ibpworkbench.navigation.ViewType;
import org.springframework.context.annotation.Scope;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@org.springframework.stereotype.Component
@Scope("prototype")
@VaadinView("")
@DynamicViewType(type=ViewType.MAIN_CONTENT)
public class LoginView extends CustomComponent implements View {
	private static final long serialVersionUID = -197897912496717920L;
	
	
	private static final String LAYOUT_NAME = "loginViewLayout";
	
	public LoginView() {
		
		
		CustomLayout root = new CustomLayout(LAYOUT_NAME);
		
		root.addComponent(new LoginForm(new BeanItem<LoginFormViewModel>(new LoginFormViewModel())),"gcp-login-form");
		
		setCompositionRoot(root);
		
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// Execute javascript code here
		Page.getCurrent().getJavaScript().execute("$('#dialog').dialog({ width: 800 })");
	}

	
	class LoginFormViewModel implements Serializable {
		
		@NotNull
		String username;
		
		@NotNull
		String password;
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	class LoginForm extends CustomComponent {
		
		@PropertyId("username")
		private TextField username;
		
		@PropertyId("password")
		private PasswordField password;
	
		public LoginForm(Item item) {
			// initialize components
			username = new TextField("username");
			password = new PasswordField("password");
			
			// buttons
			Button loginBtn = new Button("Login");
			Button forgotPasswordBtn = new Button("Forgot your password?");
			Button registerNewAcctBtn = new Button("Register New Account");
			
			loginBtn.setStyleName("center-text-align");
			forgotPasswordBtn.setStyleName(Reindeer.BUTTON_LINK + " center-text-align");
			registerNewAcctBtn.setStyleName(Reindeer.BUTTON_LINK + " center-text-align");
			
			// data bind
			//FieldGroup binder = new FieldGroup(item);
			final BeanFieldGroup<LoginFormViewModel> binder = new BeanFieldGroup<LoginFormViewModel>(LoginFormViewModel.class);
			binder.bindMemberFields(this);
			
			// layout components
			VerticalLayout rootLayout = new VerticalLayout();
			
			FormLayout layout = new FormLayout();
			layout.addComponents(username,password);
			layout.setSizeUndefined();
			
			rootLayout.addComponents(layout,loginBtn,forgotPasswordBtn,registerNewAcctBtn);
			rootLayout.setSizeUndefined();
			rootLayout.setSpacing(true);
			
			this.setSizeUndefined();
			
			setCompositionRoot(rootLayout);
		}
	}
}
