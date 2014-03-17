package jboss.as.bond.market.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jboss.as.bond.market.model.Role;
import jboss.as.bond.market.repository.UserRepository;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginHandlerBean implements Serializable {

	private String username;
	private String password;
	@ManagedProperty("#{param.id}")
	private int id;
	private boolean userProfileActive;

	@EJB
	private UserRepository ur;


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
				this.setUserProfileActive(ur.findUser(getId()).getIsActive());
				FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("id", check);
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("isActive", ur.findUser(id).getIsActive());
				try {
					FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/IFBondMarketProject/faces/Investisor/inv_dashboard.xhtml?id="+this.getId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		} 
		context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
		return "login";
	}

	
	public String logout() {
		this.id = 0;
		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().remove("user");
		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().remove("id");

		return "/common/login";
	}

	public String checkIn(){
		if(this.getId() == 0)
			return "/common/login";
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}

	public boolean hasRole(String Role){
		Integer id = (Integer)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("id");
		if(id != 0){
			Set<Role> roles = ur.findUser(id).getRoles();
			if(roles != null){
				Iterator<Role> it = roles.iterator();
				while(it.hasNext())
					if(it.next().getName().equalsIgnoreCase(Role))
						return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isUserProfileActive() {
		return userProfileActive;
	}

	public void setUserProfileActive(boolean userProfileActive) {
		this.userProfileActive = userProfileActive;
	}

}