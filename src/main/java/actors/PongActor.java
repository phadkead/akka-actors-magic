package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import messages.PingPongFinishMessage;
import messages.PongMessage;

public class PongActor extends UntypedAbstractActor {

    private static final String PONG = " Pong";
    private static final String DONE = " Done ";

    public static Props props() {
        return Props.create(PongActor.class, PongActor::new);
    }

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof PongMessage)
            receiveMsg1((PongMessage) msg);
        else
            unhandled(msg);
    }

    private void receiveMsg1(PongMessage msg) {
        String result = timeTakingProcessing();
        getContext().parent().tell(new PingPongFinishMessage(msg.getMessage() + PONG + result), self());
    }

    private String timeTakingProcessing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("I was interrupted");
        }
        return DONE;
    }
}
