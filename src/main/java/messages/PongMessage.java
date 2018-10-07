package messages;

public class PongMessage {

    private String message;

    public PongMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
