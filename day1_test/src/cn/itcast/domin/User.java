package cn.itcast.domin;

/**
 * @author Ling
 * Created on 2020/1/12
 * 用户的实体类
 */
public class User {
    private int id;
    private String username;
    private String Password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
