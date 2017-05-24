/**
 * Created by pradeepkumar.v on 10/07/16.
 */
public class ArrayUnionAndIntersection {

    public static void main (String [] args){

        MergeSort mergeSort = new MergeSort();
        int [] firstArray = {2,3,1,20,12,9,5,6};
        int [] secondArray = {5,32,11,10,20,9,6,4};

        mergeSort.sort(firstArray);
        mergeSort.sort(secondArray);

        for(int i:firstArray){
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println("\n");

        for(int i:secondArray){
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println("\n");

        fetchUnion(firstArray, secondArray);
        fetchIntersection(firstArray, secondArray);

    }

    public static void fetchUnion(int [] firstArray, int [] secondArray){
        int i = 0, j =0 , k = 0;
        int [] unionOfArrays = new int [firstArray.length + secondArray.length];

        while (i < firstArray.length && j < secondArray.length){
            if (firstArray[i] < secondArray[j]){
              unionOfArrays[k] = firstArray[i];
                i++;
            } else if (firstArray[i] > secondArray[j]){
                unionOfArrays[k] = secondArray[j];
                j++;
            } else {
                unionOfArrays[k] = secondArray[j];
                i++;
                j++;
            }
            k++;
        }
        //copy rest from large array

        while (i < firstArray.length){
            unionOfArrays[k] = firstArray[i];
            i++;
            k++;
        }

        while (j < secondArray.length){
            unionOfArrays[k] = secondArray[j];
            j++;
            k++;
        }

        System.out.println("\nUnion of Array Is \n");
        for(int u:unionOfArrays){
            System.out.print(u);
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    public static void fetchIntersection(int [] firstArray, int [] secondArray){
        int i = 0, j =0 , k = 0;
        int [] intersectionArray = new int [firstArray.length + secondArray.length];

        while (i < firstArray.length && j < secondArray.length){
            if (firstArray[i] < secondArray[j]){
                i++;
            } else if (firstArray[i] > secondArray[j]){
                j++;
            } else {
                System.out.println("Intersection " + secondArray[j]);
                //intersectionArray[k] = secondArray[j];
                i++;
                j++;
            }
            k++;
        }

        System.out.println("\nIntersection of Array Is \n");
        for(int u:intersectionArray){
            System.out.print(u);
            System.out.print(" ");
        }
    }
}
