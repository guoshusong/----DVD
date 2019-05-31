package demo;

public class User {
    /**
     * param:int
     * 用户ID
     * */
    private int userId;
    /**
     * param:String
     * 用户姓名
     * */
    private String userName;
    /***
     * param: String
     * 用户密码
     * */
    private String userPassword;

    private String userEmail;

    public String getUserEmail() {

        return userEmail;
    }

    public void setUserEmail(String userEmail) {

        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
