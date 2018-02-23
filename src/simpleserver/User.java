package simpleserver;

import java.util.HashMap;
import java.util.Map;

//holds the information of the users (username/user ID)
//parsed from the data file

public class User {

  private final static Map<String, User> usernameDict = new HashMap<>();      //tuple of user and username
  private final static Map<Integer, User> useridDict = new HashMap<>();       //tuple of user and user ID
  private String username;                                              //holds the username
  private int userid;                                                   //holds the user ID
  private static User[] masteruserArray;



  public User(String username, int userid){                                   //builder for the user class
    this.username = username;
    this.userid = userid;

  }

  public User getUserID(int userid){                                     //getter for getting user VIA userID
      return useridDict.get(userid);

  }

  public User getUsername(String username){                                //getter for getting user VIA username
    return usernameDict.get(username);

  }

  public void setUserID(){
      useridDict.put(this.userid, this);
  }

  public void setUsername(){
      usernameDict.put(this.username, this);
  }

  public static void setAll(int length){
      for(int i = 0; i < length; i++){
          masteruserArray[i].setUserID();
          masteruserArray[i].setUsername();

      }


  }


}
