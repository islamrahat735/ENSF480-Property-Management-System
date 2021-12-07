package ensf480.model;

public class Account{

    private String username;
    private String password;
    //private Access access;

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

	// public Access getAccess() {
	// 	return this.access;
	// }

	// public void setAccess(Access access) {
	// 	this.access = access;
	// }


    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
}

enum Access{
    REGISTERED_RENTER,
    LANDLORD,
    MANAGER;

    public String toString() {
        switch(this) {
            case REGISTERED_RENTER:
                return "REGISTERED_RENTER";
            case LANDLORD:
                return "LANDLORD";
            case MANAGER:
                return "MANAGER";
        }
        return null;
    }
}