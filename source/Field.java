package capilaly;

/**
 *
 * @author FC5SKH
 */
abstract public class Field {
    protected int fieldLoc;
    protected String name;
    
    public Field(int fieldLoc, String name)
    {
        this.fieldLoc = fieldLoc;
        this.name = name;
    }
    
    @Override
    public abstract String toString();
    
    
    /*getters*/
    public int getFieldLoc() {
        return fieldLoc;
    }

    public String getName() {
        return name;
    }
}
