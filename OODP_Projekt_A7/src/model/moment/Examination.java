package model.moment;

import java.util.Date;

public class Examination extends Moment {
	private Date lastRegisterDate;
	private String place;
	
	public Date getLastRegisterDate() {
		return lastRegisterDate;
	}
	public void setLastRegisterDate(Date lastRegisterDate) {
		this.lastRegisterDate = lastRegisterDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
}
