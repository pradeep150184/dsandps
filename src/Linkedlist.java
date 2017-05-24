import java.util.LinkedList;

import static java.lang.System.*;

/**
 * Created by pradeepkumar.v on 08/05/17.
 */
public class Linkedlist {
    Node head;
    Node tail;

    public static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    // Push data upfront on the list
    public void push(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        if (new_node.next == null){
            tail = new_node;
        }
    }

    public void append(int data){
        Node temp = head;

        if (head == null){
            Node new_node = new Node(data);
            head = new_node;
            return;
        }

        while (temp.next!= null){
            temp = temp.next;
        }

        Node new_node = new Node(data);

        temp.next = new_node;
        tail = new_node;

    }

    public void deleteNode(int data){
        Node temp = head;
        Node prev = null;

        if (temp!= null && temp.data == data) {
            head = temp.next;
            return;
        }


        if (temp != null && temp.data == data){
            head = temp.next;
            temp.next = null;
        }

        if (temp == null) {
            out.println("Element not found in list");
            return;
        }

        while(temp != null && temp.data != data){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        temp.next = null;

    }

    public void printList(Node temp){

        while(temp!= null){
            out.println(temp.data);
            temp = temp.next;
        }
    }

    public void deleteNodeWithPosition(int position){
        Node temp = head;
        Node prev = null;
        int count = 0;

        if (temp != null && count == position){
            head = temp.next;
            temp.next = null;
        }

        while(count != position){
            prev = temp;
            temp = temp.next;
            count = count + 1;
        }

        prev.next = temp.next;
        temp.next = null;

        if (prev.next == null){
            tail = prev;
        }

    }

    public void deleteNodeWithPositionNew(int pos){
        Node prev = null;
        Node temp = head;

        if (head == null){
            return;
        }

        if (pos == 0){
            head = temp.next;
            temp.next = null;
        }

        for(int i=0; temp != null && i>pos-1; i++){
            temp = temp.next;
        }

        if (temp == null || temp.next == null)
                return;

        Node next = temp.next.next;
        temp.next = next;


    }

    public int getCountRec(Node node){

        if (node == null)
            return 0;

        return 1 + getCountRec(node.next);
    }

    public int getNodeCount() {
        return getCountRec(head);
    }

    public int getNodeCountNonRec(){
        Node temp = head;
        int count = 0;

        if (temp == null)
                return count;

        while(temp!=null){
            temp = temp.next;
            count = count + 1;
        }

        return count;
    }

    public void checkRecursion(int number){

        if(number == 0)
            return;

        out.println("Check1 => " + number);
        checkRecursion(--number);
        out.println("Check2 => " + number);
        return;
    }

    public void swapNodes(int x, int y){

        if (x == y)
            return;

        Node prevX = null;
        Node currX = head;

        while (currX != null && currX.data != x){
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;

        while (currY != null && currY.data != y){
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            System.out.println("One/Both input values are not present");
            return;
        }

        if (prevX != null){
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null){
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currY.next;
        currY.next = currX.next;
        currX.next = temp;
        System.out.println("CurrX : " + currX.data + " CurrY : " + currY.data);
    }

    public static String intToBinary(int n)
    {
        String s = "";
        while (n > 0)
        {
            s =  ( (n % 2 ) == 0 ? "0" : "1") + s;
            n = n / 2;
        }

        if (s.length() < 4) {
            int sLength = s.length();
            for (int i = 1; i <= (4 - sLength); i++) {
                s = "0" + s;
            }
            return s;
        } else {
            return s;
        }

    }

    public void reverseLinkedList(){
        Node first = null;
        Node second = head;
        Node third = null;

        while(second != null){
            third = second.next;
            second.next = first;
            first = second;
            head = first;
            second = third;
        }

    }

    public Node reverseLinkedListRecursion(Node head){
        if (head.next == null){
            return head;
        } else {
            Node temp = head.next;
            Node returnedHead = reverseLinkedListRecursion(head.next);
            temp.next = head;
            head.next = null;
            return returnedHead;
        }
    }


    
    public void getMiddleNode(){
        Node first, second;
        first = second = head;

        while (second != null && first.next != null){
            first = first.next;
            second = second.next.next;
        }

        System.out.println("Middle node is :" + first.data);
    }

    public Node attachNodeToLlist(int data){
        Node temp = head;

        while (temp != null && temp.data != data){
            temp = temp.next;
        }

        if (temp == null)
            System.out.println("Data not Fount");


        return temp;
    }

    public static void seprateYLinkedList(Linkedlist list1, Linkedlist list2){
        int list1Length , list2Length;
        list1Length = list2Length = 0;
        int diffLength;
        int traverseLength = 0;
        Node list2temp = list2.head;
        Node list1temp = list1.head;

        Node list1Head = list1.head;
        while (list1Head != null){
            list1Length = list1Length + 1;
            list1Head = list1Head.next;
        }

        Node list2Head = list2.head;
        while (list2Head != null){
            list2Length = list2Length + 1;
            list2Head = list2Head.next;
        }

        if (list1Length > list2Length){
            diffLength = list1Length - list2Length;
            System.out.println("List2 Length : " + list2Length);
            traverseLength = list2Length;
            for(int i =0; i < diffLength; i++){
                list1temp = list1.head.next;
            }
        } else if (list2Length > list1Length){
            diffLength = list2Length - list1Length;
            traverseLength = list1Length;
            for(int i =0; i < diffLength; i++){
                list2temp = list2.head.next;
            }
        }

        System.out.println(" Temp points : " + list1temp.data + " " + list2temp.data + " TraverseLength : " + traverseLength);
        for(int i=0; i < traverseLength; i++) {
            if (list1temp.next == list2temp.next){
                list2temp.next = null;
                return;
            }
            list1temp = list1temp.next;
            list2temp = list2temp.next;
        }
    }

    public Node findNode(int data){
        Node temp = head;
        Node prev = null;

        while(temp != null && temp.data != data){
            prev = temp.next;
            temp = temp.next;
        }

        if (prev.next == null)
            System.out.println("Node not found");

        return prev;
    }

    public void findFuckingLoop(){
        Node first, second;
        first = second = head;
        int loopLength = 0;

        while (first != null){
            second = second.next.next;
            first = first.next;
            if (second == first){
                while (second != null){
                    loopLength = loopLength + 1;
                    second = second.next;
                    if (second == first)
                        break;
                }
                break;
            }
        }

        System.out.println("Lenght Of Loop :" + loopLength);

        first = second = head;
        for(int i = 0; i < loopLength -1; i++){
            second = second.next;
            System.out.println("Data : " + second.data);
        }

        //System.out.println("Second pointer : " + second.data + " First pointer " + first.data);

        while (first != null){
            first = first.next;
            second = second.next;
            System.out.println("Second pointer : " + second.data + " First pointer " + first.data);
            if (second.next == first){
                System.out.println("Found Node : " + second.next.data);
                second.next = null;
                break;
            }
        }
    }

    public void printListWithRec(Node head){

        if (head == null){
            return;
        } else {
            System.out.println("val : " + head.data);
            printListWithRec(head.next);
        }

    }

    public int printListSumWithRec(Node head){
        if (head == null){
            System.out.println("No values to sum up");
            return 0;
        } else {
            return printListSumWithRec(head.next) + head.data;
        }
    }

    public void splitEvenOddList(){
        Node head1 = null;
        Node head2 = null;
        Node even = null;
        Node odd = null;
        Node temp = head;
        Node prev = null;

        while (temp != null){
            if (temp.data % 2 == 0){
                if (head1 == null)
                    head1 = temp;

                if (even == null){
                    even = temp;
                } else {
                    even.next = temp;
                    even = temp;
                }

            } else {
                if (head2 == null)
                    head2 = temp;

                if (odd == null){
                    odd = temp;
                } else {
                    odd.next = temp;
                    odd = temp;
                }

            }
            prev = temp;
            temp = temp.next;
            prev.next = null;
        }

        printList(head1);
        printList(head2);

    }

    public int findLengthRecursive(Node head){

        if (head == null){
            return 0;
        } else {
            return findLengthRecursive(head.next) + 1;
        }
    }


    public void findElementRecursively(Node head, int data){

        if (head == null)
            System.out.println("NO element");

        if (head.data == data){
            System.out.println("Found element : " + head.data);
            return;
        } else {
            findElementRecursively(head.next, data);
        }

    }

    public void deleteNodeNew(int data){
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == data){
            head = temp.next;
            return;
        }

        while(temp != null && temp.data != data){
            prev = temp;
            temp = temp.next;
        }

        if (temp == null){
            System.out.println("No data");
            return;
        }
        prev.next = temp.next;
        temp.next = null;
    }

    public int findNthNode(Node head, int index){
        int count = 0;
        Node temp = head;

        while(temp!=null && index != count){
            temp = temp.next;
            count = count + 1;
        }

        if (temp == null){
            System.out.println("Data not found");
            return 0;
        }

        return temp.data;
    }

    public static void main(String[] args) {
        Linkedlist llist = new Linkedlist();
        Linkedlist llist1 = new Linkedlist();
        llist1.push(10);
        llist1.push(11);
        llist1.push(12);
        llist1.push(13);
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.push(0);
        //Node temp = llist.attachNodeToLlist(5);
        //llist1.tail.next = temp;
        //System.out.println("Tail : " + llist1.tail.data);;
        //llist.reverseLinkedList();
        //llist.getMiddleNode();
        //llist.printList();
        //System.out.println("List Separator ");
        //llist1.printList();
        //seprateYLinkedList(llist, llist1);
        //llist1.printList();
        //llist.printList();
        //Node resNode = llist.findNode(5);
        //llist.tail.next = resNode;
        //llist.printList();
        //llist.findFuckingLoop();
        //llist.printList();
        //llist.printListWithRec(llist.head);
        //llist.checkRecursion(10);
        //int res = llist.printListSumWithRec(llist.head);
        llist.head = llist.reverseLinkedListRecursion(llist.head);
        llist.printList(llist.head);
        //System.out.println("Result : " + res);

        //llist.splitEvenOddList();

        /*int res = llist.findLengthRecursive(llist.head);
        llist.printList(llist.head);
        System.out.println("Result :" + res);
        llist.findElementRecursively(llist.head, 5);*/
        //llist.printList(llist.head);
        //llist.deleteNodeNew(9);
        //llist.swapNodes(10, 9);
        //llist.printList(llist.head);
        //int res = llist.findNthNode(llist.head, 5);
        //System.out.println("Result : " + res);


    }
}
