/**
 * Traffic class represents each traffic packet, that desires an entry into the network
 */
package models;

public class Traffic {

    private Direction direction; //direction inbound or outbound;
    private Protocol protocol; //Network protocol - tcp or udp
    private Integer port; //port specified in the packet
    private IPV4 ipAddress; //ip Address;

    public Traffic(Direction direction, Protocol protocol, Integer port, IPV4 ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public Direction getDirection() {
        return direction;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public IPV4 getIpAddress() {
        return ipAddress;
    }

}
