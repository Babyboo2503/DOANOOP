package Nhanviensiucap;
import java.io.Serializable;
public class account implements Serializable {
    private String loginaccout, password;
    public account() {
    }
    public account (String loginaccout,String password) {
        this.loginaccout=loginaccout;
        this.password=password;
    }

    public String getLoginaccout() {
        return loginaccout;
    }

    public void setLoginaccout(String loginaccout) {
        this.loginaccout = loginaccout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
