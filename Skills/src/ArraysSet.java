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




    public class Products{
        private ArraysSet<Parts> associatedParts = new ArraysSet<Parts>;
        private int proid;
        private String proName;
        private double proPrice = 0.0;
        private int proCount = 0;
        private int min;
        private int max;
        private double proCost;

        public Products(int proid, String proName, int proCount, double proPrice, int min, int max){
            setProid(proid);
            setProName(proName);
            setProCount(proCount);
            setMin(min);
            setMax(max);
        }

        public void setProName(String proName){
            this.proName = proName;
        }

        public String getProName() {
            return proName;
        }

        public void setProCost(double proCost) {
            this.proCost = proCost;
        }

        public double getProCost() {
            return proCost;
        }

        public void setProCount(int proCount) {
            this.proCount = proCount;
        }

        public int getProCount() {
            return proCount;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public void  addAssociatedParts(Parts partsToAdd){
            associatedParts.add(partsToAdd);
        }

        public boolean removeAssociatedParts(Parts partsToRemove){
            int i;
            for(i=0; i< associatedParts.size(); i++){
                if (associatedParts.get(i).getPartID() == partsToRemove){
                    associatedParts.remove(i);
                    return true;
                }
            )
                    return false;
            }

            public Parts lookupAssociatedParts(int partToSearch){
              for(int i = 0; i < associatedParts.size(); i++){
                  if(associatedParts.get(i).getPartID() == partToSearch){
                      return associatedParts.get(i);
                  }
                  return null;
              }
              public void setProid(int id){
                  this.proid = id;
                }
              public int getProid(){
                  return this.proid;
                }

              public int getPartsListSize(){
                  return associatedParts.size()
                }
            }



        }
    }


}
