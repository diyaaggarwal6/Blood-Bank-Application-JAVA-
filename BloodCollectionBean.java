package BloodCollectionTable;

public class BloodCollectionBean 
{
	public String mobile;
	public String bgroup;
	public String date;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BloodCollectionBean(String mobile, String bgroup, String date) {
		super();
		this.mobile = mobile;
		this.bgroup = bgroup;
		this.date = date;
	}
	

}
