/**
 * ASA
 *
 * A public class that store the static function to calculate all possible sum from different combination
 * of elements within an array. The number of sum calculated is equal to 2^N), where as N refers to the number of items in the array.
 */
import java.util.List;
import java.util.LinkedList;
public class ASA{
    
    /**
     * ASA()
     *
     * Private constructor so no one could initiate the call to make a instance of the class.
     */
    private ASA(){};
    
    
    /**
     * asaRecursion(int[] arr, int first)
     *
     * Recursively calculate and record all the sum resulted from all possible combination.
     * Algorithm speed would be approximatly = arr.length * 2^(first)
     * As there would be total of arr.length call for an array of size length, and each call there is a
     * for loop, which will loop through 2^(first) items.
     */
    public static LinkedList<Integer> asaRecursion(int[] arr, int first){
        LinkedList<Integer> temp = new LinkedList<Integer>();
        if(first == arr.length){
            temp.add(0);
            return temp;
        }
        temp = asaRecursion(arr, first+1);
        LinkedList<Integer> temp1 = new LinkedList<Integer>();
        for(int number : temp){
            temp1.add(arr[first] + number);
        }
        temp.addAll(temp1);
        return temp;
    }
    
    
    
    /**
     * asaFunc(int[] arr)
     *
     * Driver function of the recursive definition for asa algorithm.
     * @Param arr, sums are being computed using the element from the array.
     * @return list1, an linkedlist which contain all sums in no specific order.
     */
    public static List<Integer> asaFunc(int[] arr){
        if(arr==null) throw new NullPointerException("Array passed in cannot be null");
        return asaRecursion(arr, 0);
    }
}
