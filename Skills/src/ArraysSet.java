import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// Right here we're going to convert an array to Hash set
public class ArraysSet {
    public static void main(String[] args){
        String[] array ={"We", "Are", "The", "World", "One", "Two", "Three"};
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Set: " + set);


            String[] array1 = {"a","b","c"};
            Set<String> set1 = new HashSet<>(Arrays.asList(array1));
            System.out.println("Set " + set1);
    }

}
