package simpleserver;

public class responseBuilder {
    private Response responses;
    private User[] user;
    private Post[] post;
    private StatusCode statusCode;

    public enum StatusCode {
        OK,
        ERROR_GENERAL,
    }

    public void setStatus(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    //method to build the class
    public Response build() {
        String statusString;

        //checks status, switches to the appropriate case depending on the status
        switch (this.statusCode) {
            case OK:
                statusString = "OK";
                break;
            default:
                statusString = "ERROR_GENERAL";
        }

        //if there are no data it makes a new array of users
        if (user == null){
            user = new User[0];
        }

        //initialize entries to 0

        return new Response(statusString, user.length, user, post);
    }

    public static void main(String args[]){
        responseBuilder responseBuilder = new responseBuilder();      //initiate new responsebuilder
        responseBuilder.setStatus(StatusCode.ERROR_GENERAL);          //sets status to error_general
        Response response = responseBuilder.build();                  //new build new object called response
        System.out.println(response.getStatusString());               //prints the status
    }

}
