package capilaly;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author FC5SKH
 */
public class Capilaly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database();

        try {
            database.read("input3.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        }
        database.report();

        
        int mapSize = database.getFields().size();
        ArrayList<Player> players = database.getPlayers();
        ArrayList<Field> fields = database.getFields();
        ArrayList<Integer> dice = database.getDice();
        ArrayList<Player> lostPlayers = new ArrayList<>();
        
        for (int i = 0, j = 0; i < dice.size() && j < players.size(); i++, j++) {
            System.out.println("\n===========================================\n");
            
            Field movedField = fields.get(players.get(j).move(dice.get(i), mapSize));

            if (players.get(j).play(movedField)) // if the player loses after playing
            {
                lostPlayers.add(players.get(j)); // add the lost player to the lostPlayers array
                players.remove(j); // remove the lost player from the players array
            }

            if (j == database.getPlayers().size() - 1) { // starting over iterating Players
                j = -1;
            }
            database.report();
        }
        System.out.println("LOST");
        for (Player p : lostPlayers) System.out.println(p.toString());


    }
}
