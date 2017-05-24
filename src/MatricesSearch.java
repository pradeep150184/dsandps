/**
 * Created by pradeepkumar.v on 17/07/16.
 */
public class MatricesSearch {

    public static void main(String [] args){

        int [][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        searchMatrix(mat, 1);

    }

    public static void searchMatrix(int [][] mat, int searchVal){
        int row = 0;
        int col = mat[0].length -1;
        int matlength = mat.length - 1;

        while (row >=0 && row <= matlength && col >=0 && col <= mat[0].length -1){
            if(mat[row][col] == searchVal){
                System.out.println("Element Found " + mat[row][col] + " At index mat[" + row + "]" + "[" + col + "]");
                return;
            } else if (mat[row][col] > searchVal){
                col --;
            } else {  // if mat[row][col] > searchVal
                row ++;
            }
        }

        System.out.println("Eelement not found");
        return;

    }
}
