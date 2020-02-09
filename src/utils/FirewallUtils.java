/**
 * Utils class has the isSatisfy method which checks if a given traffic packet
 * satisfies the rules, if it does a true gets returned, which means allow the packet into the network
 * and a false means, the packet wont be allowed
 */
package utils;

import models.Rule;
import models.Traffic;

public class FirewallUtils {


    public boolean isSatisfy(Rule rule, Traffic traffic ){

        if(!(traffic.getDirection() == rule.getDirection())){
            return false;
        }

        if(!(traffic.getProtocol() == rule.getProtocol())){
            return false;
        }

        if (!((traffic.getPort() >= rule.getStartPort()) &&(traffic.getPort() <= rule.getEndPort()))){

            return false;

        }

        if(traffic.getIpAddress().compareTo(rule.getStartingIPAddress()) == -1){
            return false;
        }

        if(traffic.getIpAddress().compareTo(rule.getEndingIPAddress()) == 1){
            return false;
        }

        return true;


    }

}
