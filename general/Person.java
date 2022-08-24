package general;

/**
 * Person
 */
public class Person {
    private int userID;
    private String name;
    private String email;
    private String gender;
    private String phoneNum;

    public Person() {
        this("", "", "", "");
    }

    public Person(String name, String email) {
        this(name, "", email, "");
    }

    public Person(String name, String email, String gender, String phoneNum) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNum = phoneNum;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
