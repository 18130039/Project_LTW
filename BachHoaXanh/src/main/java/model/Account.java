package model;

public class Account {
	private String user;
	private String pass;
	private String name;
	private int isSell;
	private int isAdmin;

	public Account() {
	}

	public Account(String user, String pass, String name, int isSell, int isAdmin) {
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsSell() {
		return isSell;
	}

	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", pass=" + pass + ", name=" + name + ", isSell=" + isSell + ", isAdmin="
				+ isAdmin + "]";
	}


}
