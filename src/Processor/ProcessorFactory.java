package Processor;

public class ProcessorFactory {
    public static Processor getProcessor(String resource) {
        Processor processor = new ErrorProcessor(null);                        //set new processor to errorproessor so it returns error as default
        String endpoint;
        String queryString = null;
        String endpointParts[] = resource.split("\\?");                       //split the endpoint so we get the query
        endpoint = endpointParts[0];

        if (endpointParts.length == 2) {                                            //if there is a query, set query string to it
            queryString = endpointParts[1];
        }

        switch (endpoint) {
            case "/user":
                processor = new UserProcessor(queryString);                         //return user if there is no error
                break;
            case "/post":
                processor = new PostProcessor(queryString);
                break;
            default:
                //add error code later?
                break;

        }


        return processor;                                                           //returns error as default

    }

}
