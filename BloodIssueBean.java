package BloodIssuetbl;

public class BloodIssueBean 
{
	public String nname;
	public String hospital;
	public String reason;
	public String doi;
	public String bgroup;
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public BloodIssueBean(String nname, String hospital, String reason, String doi, String bgroup) {
		super();
		this.nname = nname;
		this.hospital = hospital;
		this.reason = reason;
		this.doi = doi;
		this.bgroup = bgroup;
	}
	
	

}
