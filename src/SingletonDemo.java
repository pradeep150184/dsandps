/**
 * Created by pradeepkumar.v on 05/08/16.
 */
public class SingletonDemo {

    public static int counter = 0;
    private static SingletonDemo singleton = new SingletonDemo( );


    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private SingletonDemo(){ counter++;}

    /* Static 'instance' method */
    public static SingletonDemo getInstance( ) {
        return singleton;
    }
    /* Other methods protected by singleton-ness */
    protected static void demoMethod( ) {
        System.out.println("demoMethod for singleton");
    }
}


class SingletonMain {
    public static void main(String[] args) {
        SingletonDemo tmp = SingletonDemo.getInstance( );
        tmp.demoMethod( );
        System.out.println("Count " + SingletonDemo.counter);
    }
}