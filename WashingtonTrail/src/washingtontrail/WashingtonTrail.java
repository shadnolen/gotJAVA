/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package washingtontrail;

/**
 *
 * @author shadn
 */
public class WashingtonTrail {
    
    public static final int TERRITORY_UNSET = 0;
     public static final int TERRITORY_WASHINGTON = 1;
      public static final int TERRITORY_IDAHO = 2;
       public static final int TERRITORY_MONTANA = 3;
        public static final int TERRITORY_NDAKOTA = 4;
         public static final int TERRITORY_MINNESOTA = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     GameGenerator.gameGen();
    }
    
}
