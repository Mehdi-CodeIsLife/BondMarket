package jboss.as.bond.market.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.AdminHelper;
import jboss.as.bond.market.model.Investisor;

@ManagedBean
@RequestScoped
public class AdministratorController {
	
	@EJB
	AdminHelper ah;
	

	private String email;
	private String password;
	private String username;
	
	public AdministratorController() {}
	
	public String create(){
		ah.saveData(getEmail(), getUsername(), getPassword());
		return "/Administrator/dashboard";
	}
	
	public void validate(Investisor i){
		ah.activeProfile(i.getId());
	}
	
	public void decline(Investisor i){
		ah.declineProfile(i.getId());
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	private String confirmPassword;
	
}
