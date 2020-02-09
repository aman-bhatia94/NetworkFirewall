# NetworkFirewall
A firewall application that checks an incoming packet, and allows it entry into the network, based on certain rules

This firewall checks an incoming traffic packet, against a set of rules to determine if the packet should be allowed entry into the network.

This Readme describes how this firewall works. The following is a description of various classes in the project. The code also has
comments, to explain it better

### Application
 * This class serves as the entry point for the Firewall Application
 * The class takes the path of the rules file and calls Firewall class
 * Traffic represents each packet coming to the Firewall

### Firewall
This class is responsible for creating the Rules and calling the accept_packet method

### models.Direction
An enum to represent inbound and outbound traffic

### models.IPV4

This class represents the IP address
It will contain a list of four Integer values.
each representing the octets in IP address.
The class inplements Comparable to do comparison checks for IP of a traffic against the rules.

### models.Rule
This Rule class represents each rule(Direction,Protocol,IP and Port ranges) which is used for filtering packets.

### models.Protocol
This enum represents the protocol since our case uses tcp, udp, we have this but this enum can be extended to other rules like

### models.Traffic
Traffic class represents each traffic packet, that desires an entry into the network

### utils.FirewallUtils
This class is responsible for creating the Rules and calling the accept_packet method

### utils.Transformer
Transformer class converts the input String traffic to a format represented by model classes

### How does the code handle latency
accept_packets method uses parallel streams, we can run the code in parallel. Parallel streams leverages multicore processing, and thus enhances performance

### Improvements that can be made
*The code can be extended to work other protocols and IPV6
*Currently we are checking all the rules in the system but an improvement could be to use binary search to search in a particular subspace using [Range Trees]: https://en.wikipedia.org/wiki/Range_tree

### Testing
The system is tested on 6 traffic packets.

### Teams that I am interested in
Ranking(1 being the most interested in)
1. Platform Team
2. Data Team
3. Policy Team
