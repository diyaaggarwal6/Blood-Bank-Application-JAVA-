package table;

public class tableBean
{
	//small letters
	public String MobileNo;
	public String Name;
	public String Gender;
	public String Address;
	public int Age;
	public String city;
	public String Disease;
	public String BloodGroup;

	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	
	
	public tableBean(String mobileNo, String name, String gender, String address, int age, String city, String disease,
			String bloodGroup) {
		super();
		MobileNo = mobileNo;
		Name = name;
		Gender = gender;
		Address = address;
		Age = age;
		this.city = city;
		Disease = disease;
		BloodGroup = bloodGroup;
	}
	
	
}	
	
	