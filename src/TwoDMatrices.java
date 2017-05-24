/**
 * Created by pradeepkumar.v on 17/07/16.
 */
public class TwoDMatrices {
    public static void main(String [] args){

        int [][] board = new int[3][5];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println("Length "+ board[i].length );
                board[i][j] = i + j;
            }
        }

        for (int[] a : board) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }

        String[][] names = {
                {"John", "Smith"},
                {"Javin", "Paul"},
                {"James", "Gosling"},
        };

        for (String[] a : names) {
            for (String i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }



    }
}
