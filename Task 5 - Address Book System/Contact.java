import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNo;
    private String email;


    public Contact(String name, String phoneNo, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Name: " + name + ", Phone Number: " + phoneNo + ", Email: " + email;
    }
}
