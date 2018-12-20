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
        


    }


}
