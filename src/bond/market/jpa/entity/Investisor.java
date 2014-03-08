package bond.market.jpa.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@SuppressWarnings("serial")
@Entity
public class Investisor extends User{
	
	@OneToOne
	@JoinColumn(name="user")
	private Profile profile;
	
	@OneToMany(mappedBy="user")
	private ArrayList<Portfolio> pfs;
	
	public Investisor(){}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ArrayList<Portfolio> getPfs() {
		return pfs;
	}

	public void setPfs(ArrayList<Portfolio> pfs) {
		this.pfs = pfs;
	}
}
