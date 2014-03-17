package jboss.as.bond.market.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.InvestisorHelper;
import jboss.as.bond.market.helper.PortFolioHelper;
import jboss.as.bond.market.model.Portfolio;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class PortFolioController implements Serializable{
	
	@EJB
	private PortFolioHelper ph;
	
	@EJB
	private InvestisorHelper invHel;
	
	
	private String title;
	@ManagedProperty(value = "#{param.id}")
	private int owner;
	
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Portfolio> getMyPfs(){	
		if( this.getOwner() != 0){
			return  ph.getMyPortFolios(this.getOwner());
		}
		return null;
	}
	
	public String create(){
		if( this.getOwner() != 0){
			Portfolio prf = new Portfolio(invHel.getById(this.getOwner()), invHel.getById(this.getOwner()).getUsername()+"_PF");
			ph.save(prf);
			return "success";
		}
		return null;
	}
	
	public void remove(Portfolio index){
		ph.remove(index);	
	}
	
	
	
	
	
	
	
}
