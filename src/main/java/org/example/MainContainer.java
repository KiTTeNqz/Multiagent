package org.example;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import org.example.A.AgentA1;
import org.example.B.AgentB1;
import org.example.B.AgentC1;

import java.util.Properties;

public class MainContainer {

    public static void main(String[] args) {
//        Runtime runtime = Runtime.instance();
//        Profile profile = new ProfileImpl();
//        AgentContainer mainContainer = runtime.createMainContainer(profile);
//
//        try {
//            AgentController agentA = mainContainer.createNewAgent("A", AgentA1.class.getName(), null);
//            AgentController agentB = mainContainer.createNewAgent("B", AgentB1.class.getName(), null);
//            AgentController agentC = mainContainer.createNewAgent("C", AgentC1.class.getName(), null);
//
//            agentA.start();
//            agentB.start();
//            agentC.start();
//
//        } catch (StaleProxyException e) {
//            e.printStackTrace();
//        }

        // prepare argument for the JADE container
        Properties prop = new ExtendedProperties();
        // display a control/debug window
        prop.setProperty(Profile.GUI, "true");
        // declare the agents
        prop.setProperty(Profile.AGENTS, "agentA:org.example.A.AgentA1;agentB:org.example.B.AgentB1;agentB:org.example.B.AgentC1");
        // create the ain container
        ProfileImpl profMain = new ProfileImpl(jade.util.leap.Properties.toLeapProperties(prop));
        // launch it !
        Runtime rt = Runtime.instance();
        rt.createMainContainer(profMain);
    }
}