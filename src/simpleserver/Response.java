package simpleserver;

public class Response {
    private final String status;        //status of input
    private final int entries;          //number of entries
    private final User[] user;          //data containing all the data of the users and posts
    private final Post[] post;


    public Response(String status, int entries, User[] user, Post[] post){
        this.status = status;
        this.entries = entries;
        this.user = user;
        this.post = post;
    }

    //getters for this class

    public int getEntries(){
        return this.entries;
    }

    public Post[] getPost(){
        return this.post;
    }

    public String getStatusString(){
        return this.status;
    }

}