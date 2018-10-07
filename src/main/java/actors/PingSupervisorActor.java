package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import messages.PingMessage;
import messages.PingPongFinishMessage;
import messages.PongMessage;

public class PingSupervisorActor extends AbstractActor {

    private static final String PING = "Ping";

    public static Props props() {
        return Props.create(PingSupervisorActor.class, PingSupervisorActor::new);
    }

    public Receive createReceive() {
        return receiveBuilder()
                .match(PingMessage.class, this::performPing)
                .match(PingPongFinishMessage.class, this::sendFinishMessage)
                .build();
    }

    private void performPing(PingMessage message) {
        ActorRef pongActor = getContext().actorOf(PongActor.props());
        pongActor.tell(new PongMessage(PING + message.getMagicNumber()), getSelf());
    }

    private void sendFinishMessage(PingPongFinishMessage message) {
        sendEmailConfirmation(message);
        // Don't forget to stop the actor after it has nothing more to do
        getContext().stop(self());
    }

    private void sendEmailConfirmation(PingPongFinishMessage message) {
        System.out.println("Hurray! " + message.getMessage());
    }
}


