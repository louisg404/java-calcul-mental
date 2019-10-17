package bo;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String pseudo;
    private String login;
    private String password;

    public User() {}

    public User(int id, String pseudo, String login, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
