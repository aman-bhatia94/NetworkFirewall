/**
 * This Rule class represents each rule(Direction,Protocol,IP and Port ranges) which is used for filtering packets
 */
package models;

public class Rule {
    //Protocol and Direction
    private Direction direction; //inbound or outbound
    private Protocol protocol; //tcp or udp

    //starting and ending port(port range)
    private Integer startPort;
    private Integer endPort;

    //starting and ending IP address(IPrange)
    private IPV4 startingIPAddress;
    private IPV4 endingIPAddress;



    public Rule(Direction direction,Protocol protocol, Integer startPort, Integer endPort, IPV4 startingIPAddress, IPV4 endingIPAddress) {
        this.startPort = startPort;
        this.endPort = endPort;
        this.startingIPAddress = startingIPAddress;
        this.endingIPAddress = endingIPAddress;
        this.protocol = protocol;
        this.direction = direction;
    }


    public Direction getDirection() {
        return direction;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Integer getStartPort() {
        return startPort;
    }

    public Integer getEndPort() {
        return endPort;
    }

    public IPV4 getStartingIPAddress() {
        return startingIPAddress;
    }

    public IPV4 getEndingIPAddress() {
        return endingIPAddress;
    }
}
