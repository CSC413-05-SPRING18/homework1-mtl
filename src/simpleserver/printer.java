package simpleserver;

public class printer {

    //return String so it can be printed in simple server
    //prints the correct response if there are parameters
    public static String usersPrinter(User[] user){
        String data;                    //data to be printed

        if(user.length == 0){                //if there are no parameters
            data = "userID is 0";
        }

        else{                           //if there are parameters
            data = "userID is not 0";
        }
        return data;

    }

    //prints the correct response if there are no params
    //makes the argument optional
    public static void usersPrinter(){
    }

    public static String postsPrinter(int id){

        return null;
    }
}
