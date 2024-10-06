package torontomu.ca.lab4.Helper;

public class UserData {
    private String username;
    private String password;

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    AdminData admin = new AdminData(username,password);
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}