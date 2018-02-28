package DataModel;

import java.util.HashMap;
import java.util.Map;

public class User implements iData {

    private static Map<Integer, User> userById = new HashMap<>();
    private static Map<String, User> userByUsername = new HashMap<>();

    private static User allUsers[];
    private static String username;
    private static int userid;


    public void register(){
        User.userById.put(this.userid, this);
        User.userByUsername.put(this.username, this);
    }

    public static User getUserByUserID(int userid){
        return User.userById.get(userid);
    }

    public static User getUserByUsername(String username){
        return User.userByUsername.get(username);
    }

    public static void setAll(User[] allUsers){
        this.allUsers = allUsers;
    }

    public static User[] getAll(){
        return allUsers;
    }

}