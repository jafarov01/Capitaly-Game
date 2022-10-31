/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capilaly;

/**
 *
 * @author Mexlu
 */
public class StartField extends Field {
    StartField()
    {
        super(0, "Start");
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Property:").append(System.lineSeparator());
        sb.append("\tName: ").append(name);
        sb.append("\tField Location: ").append(fieldLoc);
        
        return sb.toString();
    }
}
