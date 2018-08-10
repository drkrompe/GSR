package gsr.model;

import java.util.List;

public class SqlResponse {

    private boolean success;
    private List result;

    public SqlResponse(boolean success, List result) {
        this.result = result;
    }

    public List getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }
}
