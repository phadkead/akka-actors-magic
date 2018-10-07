package messages;

public class PingPongFinishMessage {

    private String message;

    public PingPongFinishMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
