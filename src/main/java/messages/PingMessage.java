package messages;

public class PingMessage {

    private int magicNumber;

    public PingMessage(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getMagicNumber() {
        return magicNumber;
    }
}


