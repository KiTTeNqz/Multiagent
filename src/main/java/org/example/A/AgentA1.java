package org.example.A;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.behaviours.SequentialBehaviour;

public class AgentA1 extends Agent {

    @Override
    protected void setup() {
        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();

        // Отправка сообщения B
        sequentialBehaviour.addSubBehaviour(new SendToB(this));

        // Ожидание сообщения от B
        sequentialBehaviour.addSubBehaviour(new ReceiveFromB(this));

        // Отправка сообщения C
        sequentialBehaviour.addSubBehaviour(new SendToC(this));

        // Ожидание сообщения от C
        sequentialBehaviour.addSubBehaviour(new ReceiveFromC(this));

        addBehaviour(sequentialBehaviour);
    }

    // Поведение для отправки сообщения агенту B
    private class SendToB extends OneShotBehaviour {
        public SendToB(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("B", AID.ISLOCALNAME));
            msg.setContent("Мяч от A к B");
            send(msg);
            System.out.println("A отправил сообщение B");
        }
    }

    // Поведение для получения сообщения от агента B
    private class ReceiveFromB extends OneShotBehaviour {
        public ReceiveFromB(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = blockingReceive();
            if (msg != null) {
                System.out.println("A получил сообщение от B: " + msg.getContent());
            }
        }
    }

    // Поведение для отправки сообщения агенту C
    private class SendToC extends OneShotBehaviour {
        public SendToC(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("C", AID.ISLOCALNAME));
            msg.setContent("Мяч от A к C");
            send(msg);
            System.out.println("A отправил сообщение C");
        }
    }

    // Поведение для получения сообщения от агента C
    private class ReceiveFromC extends OneShotBehaviour {
        public ReceiveFromC(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            ACLMessage msg = blockingReceive();
            if (msg != null) {
                System.out.println("A получил сообщение от C: " + msg.getContent());
            }
        }
    }
}