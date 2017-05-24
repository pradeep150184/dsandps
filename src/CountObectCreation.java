/**
 * Created by pradeepkumar.v on 03/08/16.
 */
public class CountObectCreation {

    private static int counter = 0;

    private CountObectCreation() {
        counter++;
    }

    public static void main(String[] args) {
        CountObectCreation obj1 = new CountObectCreation();
        CountObectCreation obj2 = new CountObectCreation();
        CountObectCreation obj3 = new CountObectCreation();
        CountObectCreation obj4 = new CountObectCreation();
        CountObectCreation obj5 = new CountObectCreation();
        System.out.println(CountObectCreation.counter);
    }
}
