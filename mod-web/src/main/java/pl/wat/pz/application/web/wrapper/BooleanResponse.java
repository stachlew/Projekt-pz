package pl.wat.pz.application.web.wrapper;

/**
 * Created by Marian on 2016-12-29.
 */
public class BooleanResponse {
    private Boolean flag;

    public BooleanResponse() {
    }

    public BooleanResponse(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
