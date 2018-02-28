package Processor;

import DataModel.ResponseBuilder;
import DataModel.User;
import com.google.gson.Gson;
import DataModel.Response;

public class UserProcessor extends Processor {

    public UserProcessor(String args) {
        super(args);
    }

    @Override
    public String process() {
        ResponseBuilder responseBuilder = new ResponseBuilder();

        if (this.args == null) {
            User allUsers[] = User.getAll();
            responseBuilder.setStatus("OK");
            responseBuilder.setData(allUsers);

        } else {
            String[] argParts = this.args.split("=");               //splits up the argument parts
            String argName = argParts[0];
            int userid = Integer.parseInt(argParts[1]);                    //converts string to int
            User user = User.getUserByUserID(userid);
            responseBuilder.setStatus("OK");
            responseBuilder.setData(user);

        }
        Gson gson = new Gson();
        Response response = responseBuilder.build();

        return gson.toJson(response);
    }
}