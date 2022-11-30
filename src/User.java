import java.io.Serializable;

public class User implements Serializable {
private String firstName;
private String lastName;
private String email;
private String password;
private int portNB = 80;
public User() {
    super();
    firstName = null;
    lastName = null;
    email = null;
    password = null;
}
public User(String firstName, String lastName, String email, String password, int portNB){
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.portNB = portNB;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public void setEmail(String email) {
    this.email = email;
}
public void setPassword(String password) {
    this.password = password;
}
public void setPortNB(int portNB) {
    this.portNB = portNB;
}
public String getLastName() {
    return lastName;
}
public String getEmail() {
    return email;
}
public String getPassword() {
    return password;
}
public int getPortNB() {
    return portNB;
}
    
}
