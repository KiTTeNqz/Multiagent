package org.example;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
//agentA:AgentA;agentB:AgentB
public class AgentA extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agent A is ready.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("AgentA received: " + msg.getContent());

                    ACLMessage reply = msg.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent("Pong");
                    send(reply);
                }
                block();
            }
        });
    }
}