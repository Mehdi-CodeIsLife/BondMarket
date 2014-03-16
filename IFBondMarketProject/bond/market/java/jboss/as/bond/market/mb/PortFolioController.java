package jboss.as.bond.market.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jboss.as.bond.market.helper.PortFolioHelper;
import jboss.as.bond.market.model.Portfolio;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class PortFolioController implements Serializable{
	
	@EJB
	private PortFolioHelper ph;
	
	
	private int id;
	private String title;
	private int owner;
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Portfolio> getMyPfs(){	
		System.out.println("**************************************");
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));
    	System.out.println("*********************************");
    	
//    	if((Integer) session.getAttribute("id") != 0)
//			return ph.getMyPortFolios((Integer) session.getAttribute("id"));
		return null;
	}
	
	public String create(){
		ph.bind(this.getTitle(), this.getOwner());
		ph.save();
		return "success";
	}
	
	
	
	
	
	
	
}
