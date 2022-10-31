package capilaly;

/**
 *
 * @author FC5SKH
 */
public class Tactical extends Player {

    int skipped;

    Tactical(String name) {
        super(name);
        skipped = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Tactical:").append(System.lineSeparator());
        sb.append("\tName: ").append(name);
        sb.append("\tMoney: ").append(money);
        sb.append("\tLocation: ").append(location);
        sb.append("\tLost: ").append(isLost).append(System.lineSeparator());
        sb.append("\tOwned Properties:").append(System.lineSeparator());
        for (Property p : ownedProperties) {
            sb.append("\t\t").append(p.getName()).append(", ");
            sb.append("location: ").append(p.getFieldLoc()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    protected boolean play(Field f) {
        switch (f) {
            case Property property -> {
                // first identify if the player is supposed to buy a PROPERTY or HOUSE
                if (!property.isSoldProperty()) // property has not been sold yet!
                {
                    // check if the player has enough money
                    if (money > property.getPropertyPrice()) // the player can buy the property
                    {
                        // check if the player has skipped twice chance that he could buy
                        if (skipped / 2 == 1) {
                            money -= property.getPropertyPrice();
                            ownedProperties.add(property);
                            property.setIsSoldProperty(true);
                            property.setOwner(this);
                            skipped = 0;
                        } // if not, skip it
                        else
                            skipped++;
                    }
                    // if we do not have enough money, nothing happens

                } else if (ownedProperties.indexOf(property) != -1 && !property.isSoldHouse()) {
                    // check if the player has enough money
                    if (money > property.getHousePrice()) // the player can buy the house
                    {
                        // check if the player has skipped twice chance that he could buy
                        if (skipped / 2 == 1) {
                            money -= property.getHousePrice();
                            property.setIsSoldHouse(true);
                            skipped = 0;
                        } // if not, skip it
                        else
                            skipped++;
                    }
                    // if we do not have enough money, nothing happens
                }

                /*
                 * if the property is owned by other player
                 */
                if (property.isSoldProperty()) {
                    if (property.isSoldHouse()) {
                        if (money > property.getHouseRentFee()) // if the player has enough money to pay the rent
                        {
                            money -= property.getHouseRentFee();
                            property.getOwner().setMoney(property.getOwner().getMoney() + property.getHouseRentFee());
                        } else // if the player does not have enough money to pay the rent
                        {
                            // player sends all of his money
                            property.getOwner().setMoney(property.getOwner().getMoney() + money);
                            money -= property.getHouseRentFee(); // player loses
                        }

                    } else { // if the propery does not have a house on it
                        if (money > property.getPropertyRentFee()) // if the player has enough money to pay the rent
                        {
                            money -= property.getPropertyRentFee();
                            property.getOwner()
                                    .setMoney(property.getOwner().getMoney() + property.getPropertyRentFee());
                        } else // if the player does not have enough money to pay the rent
                        {
                            // player sends all of his money
                            property.getOwner().setMoney(property.getOwner().getMoney() + money);
                            money -= property.getPropertyRentFee(); // player loses
                        }
                    }
                }
            }

            case Service service -> {
                if (money > service.getPaymentAmount()) // if the player has enough money to pay the service fee
                {
                    money -= service.getPaymentAmount();
                } else // if the player does not have enough money to pay the service fee
                {
                    // player sends all of his money
                    money -= service.getPaymentAmount(); // player loses
                }
            }

            case Lucky lucky -> {
                money += lucky.getLuckAmount(); // player gets lucky money
            }

            case default -> {
            }
        }

        return isLost();
    }
}
