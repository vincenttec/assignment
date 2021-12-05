
public class Registerr {

	private String first_name,last_name,birthday, gender,email,password,phone,image, subject;

	public Registerr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registerr(String first_name, String last_name, String birthday, String gender, String email, String password,
			String phone, String image, String subject) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.image = image;
		this.subject = subject;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
	
	
}