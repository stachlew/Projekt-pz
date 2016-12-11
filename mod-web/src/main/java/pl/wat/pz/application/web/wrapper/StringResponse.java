package pl.wat.pz.application.web.wrapper;

/**
 * Created by Marian on 2016-12-10.
 */
public class StringResponse {
    private String response;
    public StringResponse(String s){
        this.response=s;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
