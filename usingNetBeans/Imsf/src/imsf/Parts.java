/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsf;

/**
 *
 * @author shadn
 */
 public abstract class Parts{
        protected int partID;
        protected String partName;
        protected double partCost = 0.0;
        protected int partCount;
        protected int min;
        protected int max;

        public void setPartName(String name){
            this.partName = name;
        }

        public String getPartName() {
            return partName;
        }

        public void setPartCost( double cost){
            this.partCost = cost;
        }

        public double getPartCost(){
            return partCost;
        }

        public void setPartCount(int count){
            this.partCount = count;
        }
        
        public int getPartCount(){
            return this.partCount;
        }
        
        public void setMin(int min){
            this.min = min;
        }
        
        public int getMin(){
            return min;
        }
        
        public void setMax(int max){
           this.max = max;
        }
        
        public int getMax(){
            return max;
        }
        public void setPartID(int partID){
            this.partID = partID;
        }
        
        public int getPartID(){
            return partID;
        }
        
    }
    
    

