package org.example;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentB extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agent B is ready.");

        addBehaviour(new TickerBehaviour(this, 1000) {
            @Override
            protected void onTick() {
                ACLMessage msg = receive();
                if (msg != null) {
                    ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                    System.out.println("AgentB received: " + msg.getContent());
                    msg2.addReceiver(getAID("agentA"));
                    msg2.setContent("Ping");
                    send(msg2);
                    System.out.println("AgentB sent: Ping");
                } else {
                    ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                    msg2.addReceiver(getAID("agentA"));
                    msg2.setContent("Ping");
                    send(msg2);
                    System.out.println("AgentB sent: Ping");
                }
            }
        });
    }
}