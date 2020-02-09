/**
 * Application class
 * This class serves as the entry point for the Firewall Application
 * The class takes the path of the rules file
 * and calls Firewall
 * Traffic represents each packet coming to the Firewall
 * 6 test cases have been written to check the validity of the Firewall
 */

import models.Traffic;
import utils.Transformer;
import utils.FirewallUtils;

public class Application {
    public static void main(String[] args){

        String filePathName = "src/rules.csv";
        Transformer transformer = new Transformer();

        FireWall fireWall = new FireWall(filePathName);

        Traffic traffic1 = transformer.createTraffic("outbound,udp,1023,52.12.48.92");
        Traffic traffic2 = transformer.createTraffic("inbound,udp,80,192.168.2.5");
        Traffic traffic3 = transformer.createTraffic("inbound,udp,53,192.168.1.1");
        Traffic traffic4 = transformer.createTraffic("inbound,tcp,80,192.168.1.2");
        Traffic traffic5 = transformer.createTraffic("inbound,tcp,900,52.12.48.92");
        Traffic traffic6 = transformer.createTraffic("inbound,tcp,80,52.12.48.92");

        System.out.println(fireWall.accept_packet(traffic1.getDirection(),traffic1.getProtocol(), traffic1.getIpAddress(), traffic1.getPort()));
        System.out.println(fireWall.accept_packet(traffic2.getDirection(),traffic2.getProtocol(), traffic2.getIpAddress(), traffic2.getPort()));
        System.out.println(fireWall.accept_packet(traffic3.getDirection(),traffic3.getProtocol(), traffic3.getIpAddress(), traffic3.getPort()));
        System.out.println(fireWall.accept_packet(traffic4.getDirection(),traffic4.getProtocol(), traffic4.getIpAddress(), traffic4.getPort()));
        System.out.println(fireWall.accept_packet(traffic5.getDirection(),traffic5.getProtocol(), traffic5.getIpAddress(), traffic5.getPort()));
        System.out.println(fireWall.accept_packet(traffic6.getDirection(),traffic6.getProtocol(), traffic6.getIpAddress(), traffic6.getPort()));


    }

}
