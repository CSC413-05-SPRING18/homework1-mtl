package DataModel;

public class Response {

    public String status;
    public int entries = 0;
    public iData[] data;

    public Response(String status, int  entries, iData[] data){
        this.status = status;
        this.entries = entries;
        this.data = data;
    }
}
