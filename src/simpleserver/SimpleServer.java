package simpleserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


class SimpleServer {

  public static void main(String[] args) throws IOException {
    ServerSocket ding;
    Socket dong = null;

    String jsonString;
    Gson gson = new Gson();
    BufferedReader br;
    JsonParser jsonParser;

    String resource = null;
    User[] userArray = null;        //array of users to store users read from GSON
    Post[] postArray = null;        //array of posts to store posts read from GSON
    User testUser = new User("Peter Lin", 1);


    try {
      ding = new ServerSocket(1299);
      System.out.println("Opened socket " + 1299);
      while (true) {



        // keeps listening for new clients, one at a time
        try {
          dong = ding.accept(); // waits for client here
        } catch (IOException e) {
          System.out.println("Error opening socket");
          System.exit(1);
        }

        InputStream stream = dong.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        try {

          // read the first line to get the request method, URI and HTTP version
          String line = in.readLine();
          System.out.println("----------REQUEST START---------");
          System.out.println(line);
          // read only headers
          line = in.readLine();
          while (line != null && line.trim().length() > 0) {
            int index = line.indexOf(": ");
            if (index > 0) {
              System.out.println(line);
            } else {
              break;
            }
            line = in.readLine();
          }
          System.out.println("----------REQUEST END---------\n\n");
        } catch (IOException e) {
          System.out.println("Error reading");
          System.exit(1);
        }
        BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
        PrintWriter writer = new PrintWriter(out, true);  // char output to the client

        //read the data and put the user into appropriate tuples

        try {
          br = new BufferedReader(new FileReader("src/simpleserver/data.json"));
          jsonParser = new JsonParser();
          JsonObject obj = jsonParser.parse(br).getAsJsonObject();

          userArray = gson.fromJson(obj.get("users"), User[].class);            //array of users
          postArray = gson.fromJson(obj.get("posts"), Post[].class);            //array of posts
          //User.setAll(userArray.length);

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }

        // every response will always have the status-line, date, and server name
        writer.println("HTTP/1.1 200 OK");
        writer.println("Server: TEST");
        writer.println("Connection: close");
        writer.println("Content-type: application/json");
        writer.println("");


        // Body of our response
        // build the response then spit it out here
        //responseBuilder rb = new responseBuilder();

          for(int i = 0; i < userArray.length; i++) {
              jsonString = gson.toJson(userArray[i]);
              writer.println(jsonString + ", \n");
              writer.println(userArray[i].getUserID(0) + ", \n");
          }

         /* writer.println("{ status: 'OK',  \n");
          writer.println("  data: \n");
          writer.println("   [ ");
          for(int i = 0; i < userArray.length; i++) {
              jsonString = gson.toJson(userArray[i]);
              if(i != userArray.length - 1) {
                  writer.println("      " + jsonString + ", \n");
              }
              else{
                  writer.println("      " + jsonString + " ], \n");
              }
              //writer.println(testUser.getUser(1) + ", \n");
          }
          writer.println("  entries: 7 }");*/
/*
          for(int i = 0; i < postArray.length; i++) {
              jsonString = gson.toJson(postArray[i]);
              writer.println(jsonString + ", \n");
              writer.println(postArray[i].getPost(2)+ ", \n");
          }
*/




        dong.close();
      }
    } catch (IOException e) {
      System.out.println("Error opening socket");
      System.exit(1);
    }
  }
}
