package asad.aspect;

import java.util.HashMap;
import java.util.Map;

public class SimpleAuthentificationService implements IAuthentificationService {

    private Map<String, String> users;

    public SimpleAuthentificationService() {
        users = new HashMap<String, String>();
        users.put("user1", "abcd");
        users.put("user2", "1111");
        users.put("user3", "1234");
    }

    @Override
    public boolean IsValid(String username, String password) {
        if (username == null || "".equals(username)) return false;
        String pwd = users.get(username.toLowerCase());
        return pwd != null && pwd.equals(password);
    }
}
