/**
 * Created by pradeepkumar.v on 12/07/16.
 */
public class PowerSolution {

    public static void main(String [] args){
        System.out.println(powerOf(3,5));
    }

    public static int powerOf(int x, int n){
        if(n==1) {
            return x;
        } else if (n%2 == 0){
            return powerOf(x, n/2) * powerOf(x, n/2);
        } else {
            return x * powerOf(x, n/2) * powerOf(x, n/2);
        }

    }
}


