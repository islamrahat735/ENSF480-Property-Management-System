package ensf480.model;

//superclass that represents an account with a username and password
public class Account {
    //fields
    private String username;
    private String password;
    private String fname;
    private String lname;

    //constructor
    public Account(String username, String password, String fname, String lname){
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    //getters and setters
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    //for debugging
    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", fname='" + getFname() + "'" +
            ", lname='" + getLname() + "'" +
            "}";
    }

}