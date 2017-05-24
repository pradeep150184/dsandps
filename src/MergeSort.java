/**
 * Created by pradeepkumar.v on 10/07/16.
 */
public class MergeSort {

    private int [] numbers;
    private int [] helper;

    public void sort(int [] arrayValues){

        if (arrayValues.length <= 1)
            System.out.println("Array is already sorted or empty");
        this.numbers = arrayValues;
        int number = arrayValues.length;
        this.helper = new int[arrayValues.length];
        mergeSort(0, number -1);
    }

    public void mergeSort(int lowIndex, int highIndex){

        if (lowIndex < highIndex){
            int middle = lowIndex + (highIndex - lowIndex)/2;

            mergeSort(lowIndex, middle);
            mergeSort(middle + 1, highIndex);

            mergeArrays(lowIndex, middle, highIndex);
        }

    }

    public void mergeArrays(int lowIndex, int middle, int highIndex){

        for (int i = lowIndex;i <= highIndex; i++){
            helper[i] = numbers[i];
        }

        int i = lowIndex;
        int j = middle + 1;
        int k = lowIndex;



        while(i <= middle && j <= highIndex){
            if(helper[i] <= helper[j]){
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy rest from the array

        while(i <= middle){
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}
