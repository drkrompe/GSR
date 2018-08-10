package gsr.model;

public class UploadResponse {

    private boolean success;
    private String message;
    private int id;

    public UploadResponse(boolean success, String message, int id){
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public boolean getSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public int getId(){
        return id;
    }
}
