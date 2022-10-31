package capilaly;

/**
 *
 * @author FC5SKH
 */
public class Property extends Field {
    private int propertyPrice;
    private int housePrice;
    private int houseRentFee;
    private int propertyRentFee;
    private boolean isSoldProperty;
    private boolean isSoldHouse;
    private Player owner;

    Property(int fieldLoc, String name) {
        super(fieldLoc, name);
        this.propertyRentFee = 500;
        this.houseRentFee = 2000;
        this.propertyPrice = 1000;
        this.housePrice = 4000;
        this.isSoldProperty = false;
        this.isSoldHouse = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Property:").append(System.lineSeparator());
        sb.append("\tName: ").append(name);
        sb.append("\tField Location: ").append(fieldLoc);
        sb.append("\tProperty Sold: ").append(isSoldProperty);
        sb.append("\tHouse Sold: ").append(isSoldHouse);

        return sb.toString();
    }

    /* getters */
    public int getHouseRentFee() {
        return houseRentFee;
    }

    public int getPropertyRentFee() {
        return propertyRentFee;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public boolean isSoldProperty() {
        return isSoldProperty;
    }

    public boolean isSoldHouse() {
        return isSoldHouse;
    }

    public Player getOwner() {
        return owner;
    }

    /* setters */
    public void setIsSoldProperty(boolean isSoldProperty) {
        this.isSoldProperty = isSoldProperty;
    }

    public void setIsSoldHouse(boolean isSoldHouse) {
        this.isSoldHouse = isSoldHouse;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setPropertyFree() {
        propertyPrice = housePrice = 0;
        System.out.println("---PROPERTY GOT FREE! ");
        System.out.println(this.toString());
    }
}
 