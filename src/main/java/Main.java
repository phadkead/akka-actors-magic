import actors.PingSupervisorActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import messages.PingMessage;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ping-pong-system");
        for (int i = 0; i < 5; i++) {
            ActorRef pingActor =
                    system.actorOf(PingSupervisorActor.props(), "demo" + i);
            pingActor.tell(new PingMessage(i), ActorRef.noSender());
        }
    }
}
