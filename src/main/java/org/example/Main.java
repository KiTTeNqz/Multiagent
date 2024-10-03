package org.example;
import jade.core.Runtime;
import jade.core.*;
import jade.util.ExtendedProperties;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // prepare argument for the JADE container
        Properties prop = new ExtendedProperties();
        // display a control/debug window
        prop.setProperty(Profile.GUI, "true");
        // declare the agents
        prop.setProperty(Profile.AGENTS, "agentA:org.example.AgentA;agentB:org.example.AgentB");
        // create the ain container
        ProfileImpl profMain = new ProfileImpl(jade.util.leap.Properties.toLeapProperties(prop));
        // launch it !
        Runtime rt = Runtime.instance();
        rt.createMainContainer(profMain);
    }

}
