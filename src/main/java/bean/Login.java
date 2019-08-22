package bean;

import javax.persistence.Entity; 
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	private String login_id;
	private String password;
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", password=" + password + "]";
	}
	

}
