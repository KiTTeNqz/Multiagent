package org.example.B;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class AgentB1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new jade.core.behaviours.CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("B получил сообщение от A: " + msg.getContent());
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Мяч возвращен от B к A");
                    send(reply);
                    System.out.println("B отправил сообщение A");
                } else {
                    block();
                }
            }
        });
    }
}