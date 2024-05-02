import DataStructures.Array;
import DataStructures.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testLinkedList();
    }

    public static void testArray() {
        Array myarray = new Array(5);
        myarray.set(0, 1);
        myarray.set(1, 2);
        myarray.set(2, 3);
        myarray.set(3, 4);
        myarray.set(4, 5);

        System.out.println("values: " + myarray.toString());

        myarray.insert(3, 8);
        myarray.insert(15, 10);

        myarray.remove(5);

        myarray.get(50);

        System.out.println("size: " + myarray.size());
        System.out.println("values: " + myarray.toString());
    }

    public static void testLinkedList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(list);
        list.add(2,11);
        System.out.println(list);
        list.remove(3);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.addFirst(77);
        list.addLast(33);
        System.out.println(list);
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        System.out.println(list.indexOf(11));
        System.out.println(list.contains(0));
        System.out.println(list.contains(11));

    }
}