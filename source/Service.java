/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capilaly;

/**
 *
 * @author FC5SKH
 */
public class Service extends Field {
    private int paymentAmount;
    
    Service(int fieldLoc, String name, int paymentAmount)
    {
        super(fieldLoc, name);
        this.paymentAmount = paymentAmount;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Service:").append(System.lineSeparator());
        sb.append("\tName: ").append(name);
        sb.append("\tField Location: ").append(fieldLoc);
        
        return sb.toString();
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }
}
