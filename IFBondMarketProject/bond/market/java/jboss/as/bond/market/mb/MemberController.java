package jboss.as.bond.market.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import jboss.as.bond.market.helper.CompanyHelper;

@ManagedBean
@RequestScoped
public class MemberController {
	
	private int c_id;
	private String info;
	
	@EJB
	private CompanyHelper ch;
	
	public void updateInfo(){
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
