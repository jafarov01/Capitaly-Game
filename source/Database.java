/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capilaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FC5SKH
 */
public class Database {
    private final ArrayList<Player> players;
    private final ArrayList<Field> fields;
    private final ArrayList<Integer> dice;
    
    public Database() {
        players = new ArrayList<>();
        fields = new ArrayList<>();
        dice = new ArrayList<>();
        fields.add(new StartField());
    }

    public void read(String filename) throws FileNotFoundException, InvalidInputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int numFields = sc.nextInt();
        
        while (sc.hasNext()) {
            Field field;
            for (int i = 0; i < numFields; i++) {
                switch (sc.next()) {
                    case "P" -> field = new Property(i + 1,sc.next());
                    case "L" -> field = new Lucky(i + 1,sc.next(), sc.nextInt());
                    case "S" -> field = new Service(i + 1,sc.next(), sc.nextInt());
                    default -> throw new InvalidInputException();
                }
                fields.add(field);
            }
            
            int numPlayers = sc.nextInt();
            Player player;
            for (int i = 0; i < numPlayers; i++) {
                switch (sc.next()) {
                    case "G" -> player = new Greedy(sc.next());
                    case "C" -> player = new Careful(sc.next());
                    case "T" -> player = new Tactical(sc.next());
                    default -> throw new InvalidInputException();
                }
                players.add(player);
            }
            
            int numDice = sc.nextInt();
            for (int i = 0; i < numDice;i++)
                dice.add(sc.nextInt());
        }
    }
    
    public void report() {
        System.out.println("Fields in the database:");
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Players in the database:");
        for (Player p : players) {
            System.out.println(p);
        }
    }
    
    /*getters*/
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Integer> getDice() {
        return dice;
    }
    
    public void clear() {
        fields.clear();
        players.clear();
        dice.clear();
    }

}