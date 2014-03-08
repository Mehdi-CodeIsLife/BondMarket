package bond.market.jpa.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Member extends User{
	
	@ManyToOne
	@JoinColumn(name="members")
	private Company company;
	
	public Member(){}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
}
