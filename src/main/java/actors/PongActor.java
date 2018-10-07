package actors;

import akka.actor.UntypedAbstractActor;

public class PongActor extends UntypedAbstractActor {

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof Msg1)
            receiveMsg1((Msg1) msg);
        else if (msg instanceof Msg2)
            receiveMsg2((Msg2) msg);
        else if (msg instanceof Msg3)
            receiveMsg3((Msg3) msg);
        else
            unhandled(msg);
    }
}
