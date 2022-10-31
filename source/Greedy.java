package capilaly;

/**
 *
 * @author FC5SKH
 */
public class Greedy extends Player {

    Greedy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Greedy:").append(System.lineSeparator());
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
                /*
                the property is not sold yet
                 */
                if (!property.isSoldProperty()) {
                    if (money > property.getPropertyPrice()) //the player has money twice the property price amount to buy the property
                    {
                        money -= property.getPropertyPrice();
                        ownedProperties.add(property);
                        property.setIsSoldProperty(true);
                        property.setOwner(this);
                    } else //if the player does not have enough (2x) money, he skips
                    {
                        //nothing happens
                    }
                } else if (ownedProperties.indexOf(property) != -1 && !property.isSoldHouse()) {
                    if (money > property.getHousePrice()) //the player has money twice the house price amount to buy a house
                    {
                        money -= property.getHousePrice();
                        property.setIsSoldHouse(true);
                    } else // if player cannot afford buying a house
                    {
                        //nothing happens
                    }
                }


                /*
                    if the property is owned by other player
                 */
                if (property.isSoldProperty()) {
                    if (property.isSoldHouse()) {
                        if (money > property.getHouseRentFee()) //if the player has enough money to pay the rent
                        {
                            money -= property.getHouseRentFee();
                            property.getOwner().setMoney(property.getOwner().getMoney() + property.getHouseRentFee());
                        } else // if the player does not have enough money to pay the rent
                        {
                            //player sends all of his money
                            property.getOwner().setMoney(property.getOwner().getMoney() + money);
                            money -= property.getHouseRentFee(); //player loses
                        }

                    } else { //if the propery does not have a house on it
                        if (money > property.getPropertyRentFee()) //if the player has enough money to pay the rent
                        {
                            money -= property.getPropertyRentFee();
                            property.getOwner().setMoney(property.getOwner().getMoney() + property.getPropertyRentFee());
                        } else // if the player does not have enough money to pay the rent
                        {
                            //player sends all of his money
                            property.getOwner().setMoney(property.getOwner().getMoney() + money);
                            money -= property.getPropertyRentFee(); //player loses
                        }
                    }
                }
            }

            case Service service -> {
                if (money > service.getPaymentAmount()) //if the player has enough money to pay the service fee
                {
                    money -= service.getPaymentAmount();
                } else // if the player does not have enough money to pay the service fee
                {
                    //player sends all of his money
                    money -= service.getPaymentAmount(); //player loses
                }
            }

            case Lucky lucky -> {
                money += lucky.getLuckAmount(); //player gets lucky money
            }

            case default -> {
            }
        }

        return isLost();
    }
}
