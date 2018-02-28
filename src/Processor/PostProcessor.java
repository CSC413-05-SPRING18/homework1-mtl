package Processor;

import DataModel.Response;
import DataModel.ResponseBuilder;
import DataModel.Post;
import DataModel.User;
import com.google.gson.Gson;

public class PostProcessor extends Processor {

    public PostProcessor(String args) {
        super(args);
    }

    @Override
    public String process() {
        ResponseBuilder responseBuilder = new ResponseBuilder();


        //this function splits it up and does stuff if theres a post ID
        String[] argParts = this.args.split("=");               //splits up the argument parts
        String argName = argParts[0];
        //if (argName == "postid") {                                      //if argName is postid, search by using the post's ID
        int postid = Integer.parseInt(argParts[1]);                //converts string to int
        Post post = Post.getPostByPostID(postid);
        responseBuilder.setStatus("OK");
        responseBuilder.setData(post);


        if (argName == "userid") {                                  //if argName is userid, search up by user's ID
            int userid = Integer.parseInt(argParts[1]);
            post = Post.getPostByUser(userid);
            responseBuilder.setStatus("OK");
            responseBuilder.setData(post);
        }
        Gson gson = new Gson();
        Response response = responseBuilder.build();

        return gson.toJson(response);

    }
}
