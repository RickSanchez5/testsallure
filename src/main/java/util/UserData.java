package util;

public class UserData {
    private String userLogin;
    private String userPassword;

    public UserData(String userLogin, String userPassword){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
    }

    public String getUserLogin(){
        return this.userLogin;
    }

    public String getUserPassword(){
        return this.userPassword;
    }
}
