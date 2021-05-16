package jpm.Services;
import jpm.model.User;
public class LoginService {
    public static User current_user= new User();


    public static String get_user()
    {
        return current_user.getUsername();
    }
    public static String get_role()
    {
        return current_user.getRole();
    }
    public static void set_current_user(User user)
    {
        current_user.setUsername(user.getUsername());
        current_user.setRole(user.getRole());
    }
}
