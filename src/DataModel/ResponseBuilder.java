package DataModel;

public class ResponseBuilder {
    public String status;
    public iData[] data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(iData[] data) {
        this.data = data;
    }

    public void setData(iData data) {                    //if single item is passed, makes an array of 1
        this.data = new iData[1];
        this.data[0] = data;
    }


    public Response build() {
        Response response = new Response(status, data.length, data);
        return response;
    }


}
