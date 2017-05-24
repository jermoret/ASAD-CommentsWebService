/**
 * Auteur    : Moret Jérôme
 * Date      : 24/05/2017
 * Version   : 1.0
 */
package asad.ws;

public class User {
    String login;
    String pass;

    public User() {
    }

    public User(String username, String pass) {
        this.login = username;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
