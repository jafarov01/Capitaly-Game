package capilaly;

import java.util.ArrayList;

/**
 *
 * @author FC5SKH
 */
abstract public class Player
{
    protected String name; //the name of the player
    protected int money; //amount of the money the player has
    protected int location; //location in the map the player stands
    protected boolean isLost; //player is avtive (false) or passive (true)
    protected ArrayList<Property> ownedProperties; //ownedProperties
    
    
    public Player(String name)
    {
        this.name = name;
        this.money = 10000;
        this.location = 0; // 0 means START (every player starts from the START)
        this.isLost = false;
        this.ownedProperties = new ArrayList<>();
    }

    public int move(int sumDice, int mapSize) //sumDice is the sum of the two dice
    {
        location = (location + sumDice) % mapSize;
        System.out.println(name + ": " + location);
        return location;
    }
    
    abstract protected boolean play(Field f);
    
    @Override
    public abstract String toString();
    
    /*getters*/
    public boolean isLost() //have positive amount of money
    {
        if (isLost = money < 0)
        {
            for (Property p : ownedProperties)
            {
                p.setPropertyFree();
            }
            ownedProperties.clear();
        }


        return isLost;
    }
    
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getLocation() {
        return location;
    }

    public ArrayList<Property> getOwnedProperties() {
        return new ArrayList<>(ownedProperties);
    }

    /*setters*/
    public void setMoney(int money) {
        this.money = money;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setIsLost(boolean isLost) {
        this.isLost = isLost;
    }

    public void setOwnedProperties(ArrayList<Property> ownedProperties) {
        this.ownedProperties = new ArrayList<>(ownedProperties);
    }
}
