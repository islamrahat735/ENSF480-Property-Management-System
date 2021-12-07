package ensf480.model;

public class Account {
    private String username;
    private String password;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    //uh-oh security!
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
}