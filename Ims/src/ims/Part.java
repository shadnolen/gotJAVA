/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

/**
 *
 * @author shadn
 */
class Part {
     private final SimpleIntegerProperty PartNumber= new SimpleIntegerProperty(0);
    private final SimpleStringProperty PartName=new SimpleStringProperty("");
    private final SimpleDoubleProperty Cost=new SimpleDoubleProperty(0.0);
    public Part(){
        this(0,"",0.0);
    }
    public Part(int partNumber, String partName, double cost){
        setPartNumber(partNumber);
        setPartName(partName);
        setCost(cost);
    }
    public int getPartNumber(){
        return PartNumber.get();
    }
    public String getPartName(){
        return PartName.get();
    }
    public double getCost(){ 
        return Cost.get();
    }
    public void setPartNumber(int partNumber){
        PartNumber.set(partNumber);
    }
    public void setPartName(String partName){
        PartName.set(partName);
    }
    public void setCost(double cost){
        Cost.set(cost);
    }
}
