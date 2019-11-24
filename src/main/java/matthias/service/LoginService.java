package matthias.service;

public class LoginService {

    public boolean authenticate(String username, String password) {
        if( isEmpty(username) || isEmpty(password) ) {
            return false;
        }

        return true;
    }

    private boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

}
