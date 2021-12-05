
public class Registere {
	private String F_name,L_name,Bithdates,Gender,email,phone,password;

	public Registere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registere(String f_name, String l_name, String bithdates, String gender, String email, String phone,
			String password) {
		super();
		F_name = f_name;
		L_name = l_name;
		Bithdates = bithdates;
		Gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public String getL_name() {
		return L_name;
	}

	public void setL_name(String l_name) {
		L_name = l_name;
	}

	public String getBithdates() {
		return Bithdates;
	}

	public void setBithdates(String bithdates) {
		Bithdates = bithdates;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
