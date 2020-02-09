package models;

/**This class represents the IP address
It will contain a list of four Integer values
each representing the octets in IP address
The class inplements Comparable to do comparison checks for IP of a traffic against the rules

/*TODO extend this class to handle IPV6*/

public class IPV4 implements Comparable {

    private Integer octetListSize;
    private Integer[] octets;

    public Integer getOctetListSize() {
        return octetListSize;
    }

    public Integer[] getOctets() {
        return octets;
    }

    public IPV4(Integer octetListSize, Integer[] octets) {
        this.octetListSize = octetListSize;
        this.octets = octets;
    }

    @Override
    public int compareTo(Object o) {

        IPV4 ip = (IPV4) o;

        for(int i = 0; i < octetListSize; i++){

            if(octets[i] < ip.octets[i]){
                return -1;
            }
            else if(octets[i] > ip.octets[i]){
                return 1;
            }

        }

        return 0;
    }
}
