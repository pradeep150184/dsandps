/**
 * Created by pradeepkumar.v on 31/07/16.
 */
public class SingleLinkedList<T> {

    private NewNode head;
    private NewNode tail;

    public void addValue(T element){

        NewNode node = new NewNode<T>();
        node.setValue(element);

        if(head == null){
            head = node;
            tail = node;
        } else {
            tail.setNextRef(node);
            tail = node;
        }

    }

    public void addAfter(T element, T afterValue){

        NewNode<T> tmp = head;
        NewNode<T> refNode = null;

        while(true){
            if(tmp == null){
                System.out.println("Empty List");
                break;
            }

            if(tmp.compareTo(afterValue)==0){
                refNode = tmp;
                break;
            }

            tmp = tmp.getNextRef();
        }

        if(refNode != null){
            NewNode<T> node = new NewNode<T>();
            node.setValue(element);
            node.setNextRef(tmp);
            if(tmp == tail){
                tail = node;
            }
            tmp.setNextRef(node);
        }

    }

}

class NewNode<T> implements Comparable<T>{

    private T value;
    private NewNode nextRef;

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public NewNode<T> getNextRef(){
        return this.nextRef;
    }

    public void setNextRef(NewNode<T> ref){
        this.nextRef = ref;
    }

    @Override
    public int compareTo(T arg){
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }

}
