import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// Right here we're going to convert an array to Hash set
public class ArraysSet {
    public static void main(String[] args){
        String[] array ={"We", "Are", "The", "World", "One", "Two", "Three"};
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Set1: " + set);


            String[] array1 = {"a","b","c"};
            Set<String> set1 = new HashSet<>(Arrays.asList(array1));
            System.out.println("Set2: " + set1);
    }


    public abstract class Part{
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

        public void setPartCost(cost){
            this.partCost = cost;
        }

        public double getPartCost(){
            return partCost;
        }

        public void setPartCount(int count){
            this.partCount = count;
        }

        public void getPartCount(){
            return partCount;
        }

        public void setMin(int min){
            this.min = min;
        }

        public void getMin(){
            return min;
        }

        public void setMax(int max){
           this.max = max;
        }

        public void getMax(){
            return max;
        }
        public void setPartID(int partID){
            this.partID = partID;
        }

        public void getPartID(){
            return partID;
        }

    }

    public class Products{
        private ArraysSet<Parts> associatedParts = new ArraysSet<Parts>;
        private int proid;
        private String proName;
        private double proPrice = 0.0;
        private int proCount = 0;
        private int rmin;
        private int max;
        private double proCost;

        public Products(int proid, String proName, int proCount ,double proPrice, int min, int max){
            setProid(proid);
            setProName(proName);
            setProCount(proCount);
            
        }
    }


}
