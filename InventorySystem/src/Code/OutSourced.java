/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author shadn
 */
public class OutSourced extends Parts{
    
    // we need to change to company being outsourced too
    //cn = company name
    private String companyName;
    
    public OutSourced(int partID, String name, double price, int stock, int max, int min, String company){
       
        this.setCompanyName(company);
        this.setPartID(partID);
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
        this.setMax(max);
        this.setMin(min);
        
    }
    
    public void setCompanyName(String compName){
        this.companyName =compName ;
    }
    public String getCompanyName(){
    return companyName;
   }
}
