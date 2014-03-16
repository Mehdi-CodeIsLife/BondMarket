package jboss.as.bond.market.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jboss.as.bond.market.repository.UserRepository;
import jboss.as.bond.market.service.LoginRequestHandler;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginHandlerBean implements Serializable {
	
	private String username;
	private String password;
	private int id;
	
	@EJB
	private UserRepository ur;
	
	@EJB
	private LoginRequestHandler lrq;
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		
		int check = ur.check_login(username, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if(check != 0){
	        if (username != null) {
	        	this.setId(check);
	        	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", check);
	            return "/Investisor/inv_dashboard";
	        } 
		} 
        context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
        return "login";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		context.getExternalContext().getSessionMap().remove("id");
		
		return "/common/login";
	}
	
	public String checkIn(){
		if(this.getId() == 0)
			return "/common/login";
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}