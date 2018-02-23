package simpleserver;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class dataReader{
/*
    public static void main(String[] args) {
        Gson gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/simpleserver/data.json"));
            JsonParser jsonParser = new JsonParser();
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();

            User[] users = gson.fromJson(obj.get("users"), User[].class); //array of users
            String jsonString = gson.toJson(users);
            System.out.println(jsonString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }*/
}
