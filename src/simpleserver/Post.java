package simpleserver;

import java.util.HashMap;
import java.util.Map;

//holds the information of the posts (post content/post ID)
// parsed from the data file

public class Post {
    private final static Map<Integer, Post> postidDict = new HashMap<>();                  //tuple of postID and post
    private final static Map<String, Post> postcontDict = new HashMap<>();                  //tuple of post content and Post

    private final String postContent;
    private final int postid;

    public Post(String postContent, int postid){
        this.postContent = postContent;
        this.postid = postid;

        postcontDict.put(postContent, this);
        postidDict.put(postid, this);

    }

    //returns post with the same post ID
    public static Post getPost(int postid){
        return postidDict.get(postid);

    }

    /* return posts that are made by userid
    public static Post getpost(int userid){
        return

    }*/
}
