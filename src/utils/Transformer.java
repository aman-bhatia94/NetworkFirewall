/**
 * Transformer class converts the input String traffic to a format represented by model classes
 */

package utils;

import models.*;

public class Transformer {
    public static String IP_OCTET_SEPARATOR = "\\.";
    public static String RANGE_SEPARATOR = "-";
    public static String RULE_SEPARATOR = ",";

    public IPV4 getIP(String ipString){

        String[] ipStringTokens = ipString.split(IP_OCTET_SEPARATOR);
        Integer ipOctetsSize = 4; //To represent 4 octets
        Integer[] ipOctets = new Integer[4];

        for(int i = 0; i < ipStringTokens.length; i++){

            ipOctets[i] = Integer.parseInt(ipStringTokens[i]);
        }

        IPV4 ipv4 = new IPV4(ipOctetsSize,ipOctets);

        return ipv4;

    }

    public Rule getRule(String ruleString){

        String[] ruleTokens = ruleString.split(RULE_SEPARATOR);
        Integer startPort;
        Integer endPort;
        IPV4 startIP;
        IPV4 endIP;

        Direction direction = Direction.valueOf(ruleTokens[0]);

        Protocol protocol = Protocol.valueOf(ruleTokens[1]);

        if(ruleTokens[2].contains("-")){
            String[] portTokens = ruleTokens[2].split(RANGE_SEPARATOR);
            startPort = Integer.parseInt(portTokens[0]);
            endPort = Integer.parseInt(portTokens[1]);
        }
        else{
            startPort = Integer.parseInt(ruleTokens[2]);
            endPort = Integer.parseInt(ruleTokens[2]);
        }

        if(ruleTokens[3].contains("-")){
            String[] ipTokens = ruleTokens[3].split(RANGE_SEPARATOR);
            startIP = getIP(ipTokens[0]);
            endIP = getIP(ipTokens[1]);
        }
        else{
            startIP = getIP(ruleTokens[3]);
            endIP = getIP(ruleTokens[3]);
        }

        Rule rule = new Rule(direction,protocol, startPort,endPort,startIP,endIP);
        return rule;
    }


    public Traffic createTraffic(String trafficString){


        IPV4 ipAddress;
        Integer port;

        String[] trafficTokens = trafficString.split(RULE_SEPARATOR);

        Direction direction = Direction.valueOf(trafficTokens[0]);

        Protocol protocol = Protocol.valueOf(trafficTokens[1]);

        port = Integer.parseInt(trafficTokens[2]);
        ipAddress = getIP(trafficTokens[3]);

        Traffic traffic = new Traffic(direction,protocol,port,ipAddress);
        return traffic;
    }


}
