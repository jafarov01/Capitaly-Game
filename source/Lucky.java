package capilaly;

/**
 *
 * @author FC5SKH
 */
public class Lucky extends Field {
    private int luckAmount;

    Lucky(int fieldLoc, String name, int luckAmount)
    {
        super(fieldLoc, name);
        this.luckAmount = luckAmount;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Lucky:").append(System.lineSeparator());
        sb.append("\tName: ").append(name);
        sb.append("\tField Location: ").append(fieldLoc);
        
        return sb.toString();
    }
    
    public int getLuckAmount() {
        return luckAmount;
    }
}
