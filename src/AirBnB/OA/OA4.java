package AirBnB.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z001ktb
 */
public class OA4 {
    /**
     * Class for representing Troop data structure
     * @property strength, strength of the troop including supports, with no support, default strength = 1
     * @property currentLocation, troop's current location
     * **/
    /*
 * Complete the function below.
 */

// class for represtenting Troop data structure
    static class Troop {
        int strength;
        String currentLocation;
        Troop() {
            strength = 1; // all troops initially has power 1
        }
    }

    static Map<String,String> supportMap = new HashMap<>();
    static Map<String,String> locations = new HashMap<>();
    static Map<String,Troop> troopMap = new HashMap<>();
    static Map<String,String> moveMap = new HashMap<>();

    static String[] evaluateActions(String[] actions) {
        List<String> input = new ArrayList<String>();
        supportMap = new HashMap<String,String>();
        locations = new HashMap<String,String>();
        troopMap = new HashMap<String,Troop>();
        moveMap = new HashMap<String,String>();

        for(String command : actions) { // setup troops and support/move/location relationships
            String[] parts = command.split(" ");
            String party1 = parts[0];
            input.add(party1);
            Troop party1Troop = troopMap.containsKey(party1) ? troopMap.get(party1) : new Troop();
            String location1 = parts[1];
            String action = parts[2];
            String party2 = null;
            Troop party2Troop = null;
            if(!action.equals("Hold")) {
                party2 = parts[3];
                party2Troop = troopMap.containsKey(party2) ? troopMap.get(party2) : new Troop();
            }

            switch(action) {
                case "Hold":
                    party1Troop.currentLocation = location1;
                    locations.put(location1, party1);
                    break;
                case "Support":
                    party2Troop.strength += 1;
                    supportMap.put(party1, party2);
                    troopMap.put(party2, party2Troop);
                    party1Troop.currentLocation = location1;
                    locations.put(location1, party1);
                    break;
                case "Move":
                    moveMap.put(party1, party2);
                    break;
            }

            troopMap.put(party1, party1Troop);
        }

        for(String command : actions) { // remove invalid supports
            String[] parts = command.split(" ");
            if(parts[2].equals("Move")) {
                String party2 = parts[3];
                if(locations.containsKey(party2)) {
                    String supportTroop = locations.get(party2);
                    if(supportMap.containsKey(supportTroop)) {
                        String enhancedTroop = supportMap.get(supportTroop);
                        troopMap.get(enhancedTroop).strength -= 1;
                        locations.put(party2, supportTroop);
                    }
                }
            }
        }

        for(String attacker : moveMap.keySet()) { // process actual move
            String location = moveMap.get(attacker);
            if(!locations.containsKey(location)) {
                locations.put(location, attacker);
                troopMap.get(attacker).currentLocation = location;
            } else {
                String defender = locations.get(location);
                Troop attackerTroop = troopMap.get(attacker);
                Troop defenderTroop = troopMap.get(defender);

                if(attackerTroop.strength > defenderTroop.strength) { // if attacker success, attacker moves to new location, defender dead
                    attackerTroop.currentLocation = location;
                    defenderTroop.currentLocation = "[dead]";

                } else if(attackerTroop.strength < defenderTroop.strength) { // if attacker failed, attacker dead, defender holds location
                    attackerTroop.currentLocation = "[dead]";

                } else { //if tie both attacker and defender dead
                    attackerTroop.currentLocation = "[dead]";

                    defenderTroop.currentLocation = "[dead]";

                    locations.put(location,attacker);
                }
                troopMap.put(attacker, attackerTroop);
                troopMap.put(defender, defenderTroop);
            }

        }

        String[] result = new String[input.size()];

        for(int i = 0; i < input.size(); i++) {
            result[i] = input.get(i) + " " + troopMap.get(input.get(i)).currentLocation;
        }

        return result;
    }




    public static void main(String[] args) {
        String[] input = {
                "A Paris Move London",
                "C London Hold",
                "B Berlin Move London",
                "D Lisbon Support C",
                "F Mosscow Support C",
                "G Kiev Move Mosscow",
                "H Bejing Move Tokyo",
                "I Shanghai Move Paris"
        };
        String[] result = evaluateActions(input);
        for(String output : result) {
            System.out.println(output);
        }
    }
}
