package userInterface;

public class Login {
	
	private String EmailAdress;
	private String Password;

  public String getEmailAdress() {
    return this.EmailAdress;
  }

  public void setEmailAdress(String EmailAdress) {
    this.EmailAdress = EmailAdress;
  }

  public String getPassword() {
    return this.Password;
  }

  public void setPassword(String Password) {
    this.Password = Password;
  }

  

  @Override
  public String toString() {
    return "{" +
      " EmailAdress='" + getEmailAdress() + "'" +
      ", Password='" + getPassword() + "'" +
      "}";
  }

}
