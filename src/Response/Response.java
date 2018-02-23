package Response;

//response class that the output will be using

public class Response {

    private  int entries;                //entries keep count of the entries
    private boolean statusOK;            //status tells if there are errors;

    //builder class for the Response class
    public static class responseBuilder {

        private  int entries;                //entries keep count of the entries
        private boolean statusOK;            //status tells if there are errors;

       //sets the entries variable to the number of entries counted
       public responseBuilder entries(int e){
           this.entries = e;
           return this;

       }

       //sets the statusOK variable for the class
       public responseBuilder statusOK(boolean s){
           this.statusOK = s;
           return this;

       }

       /*
       //sets the data variable
       public responseBuilder dataArray(){
           return this
       }
        */

       public Response build(){
           return new Response(this);

       }
    }

    private Response(responseBuilder rB){
        this.statusOK = rB.statusOK;
        this.entries = rB.entries;

    }

}
