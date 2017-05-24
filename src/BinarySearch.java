/**
 * Created by pradeepkumar.v on 18/07/16.
 */
public class BinarySearch {
    public static void main(String [] args){
        int [] inputArray = {1,2,3,4,5,6,7,8,9};
        int searchElement = 8;

        binarySearchElement(inputArray, searchElement);
        String str = "rascal";
        for (int i = 0; i < str.length(); ++i)
           System.out.println(str.charAt(i) - 'a');
    }

    public static void binarySearchElement(int [] inputArrray, int searchElement){
        int low = 0;
        int high = inputArrray.length - 1;
        int middle = low + (high - low)/2;

        while (low <= high){
            if (inputArrray[middle] == searchElement){
                System.out.println("Element Found at Index " + middle);
                return;
            } else if (inputArrray[middle] > searchElement){
                high = middle - 1;
            } else{
                low = middle + 1;
            }
            middle = low + (high - low)/2;
        }

        System.out.println("Element not found");

    }
}
