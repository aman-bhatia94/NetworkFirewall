/**
 * This class is responsible for creating the Rules
 * and calling the accept_packet method
 */

import models.*;
import utils.Transformer;
import utils.FirewallUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FireWall {

    private final Transformer transformer;
    private final FirewallUtils firewallUtils;
    private List<Rule> ruleList;

    /*FireWall(Transformer transformer, FirewallUtils firewallUtils, String ruleFilePath){
        this.transformer = transformer;
        this.firewallUtils = firewallUtils;
        ruleList = createRules(ruleFilePath);
    }*/

    FireWall(String ruleFilePath){
        transformer = new Transformer();
        firewallUtils = new FirewallUtils();
        ruleList = createRules(ruleFilePath);
    }

    List<Rule> createRules(String filePathName){

        ruleList = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePathName));
            String ruleLine = reader.readLine();
            while(ruleLine != null){

                Rule rule = transformer.getRule(ruleLine);
                ruleList.add(rule);

                ruleLine = reader.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ruleList;
    }


    //using parallel streams, we can run the code in parallel, as every check is independent of the other
    //this we we can use multiple cores, which will speed up our process, if we have a lot of rules
    public boolean accept_packet(Direction direction, Protocol protocol, IPV4 ipAddressRange, Integer port){
        Traffic traffic = new Traffic(direction,protocol,port,ipAddressRange);
        return ruleList.parallelStream().anyMatch(new Predicate<Rule>() {
            @Override
            public boolean test(Rule rule) {
                return firewallUtils.isSatisfy(rule, traffic);
            }
        });
    }
}
