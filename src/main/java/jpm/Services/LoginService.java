package jpm.Services;
import jpm.model.User;

import java.util.Objects;

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
    public static float get_balance()
    {
        return current_user.getBalance();
    }
    public static void set_balance(float funds)
    {
        current_user.setBalance(current_user.getBalance()+funds);
    }
    public static boolean ifbuyer() { if(Objects.equals( current_user.getRole(),"Buyer")) return true;
        return false;
    }
    public static boolean ifseller() { if(Objects.equals( current_user.getRole(),"Seller")) return true;
        return false;
    }
    public static void set_current_user(User user)
    {
        current_user.setUsername(user.getUsername());
        current_user.setRole(user.getRole());
        current_user.setBalance(user.getBalance());
    }
}
