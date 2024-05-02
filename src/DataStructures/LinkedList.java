package DataStructures;

public class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public int size() {
        int itemCount = 0;

        Node current = head;
        while (current != null) {
            itemCount++;
            current = current.next;
        }

        return itemCount;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        head = null;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value);
    }

    public void add(int index, int value) throws IndexOutOfBoundsException {
        validateIndex(index);

        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void addFirst(int value) {
        add(0, value);
    }

    public void addLast(int value) {
        add(this.size(), value);
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        validateIndex(index);

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(this.size() - 1);
    }

    public int get(int index) throws IndexOutOfBoundsException {
        validateIndex(index);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() throws IndexOutOfBoundsException {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    public int indexOf(int value) {
        Node current = head;
        for (int i = 0; i < this.size(); i++) {
            if (current.data == value) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    public boolean contains(int value) {
        Node current = head;
        for (int i = 0; i < this.size(); i++) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void set(int index, int value) throws IndexOutOfBoundsException {
        validateIndex(index);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = value;
    }

    public void validateIndex(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void iterativeReverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        head = prev;
    }

    public void recursiveReverse() {
        this.head = recursiveReverse(this.head, null);
    }

    private Node recursiveReverse(Node current, Node previous) {
        if (current == null) {
            return previous;
        }

        Node tempNext = current.next;
        current.next = previous;
        return recursiveReverse(tempNext, current);
    }

    public String toString() {
        StringBuilder linkedListTextRepresentation = new StringBuilder();

        Node current = head;
        while (current != null) {
            linkedListTextRepresentation.append(current.data).append(" -> ");
            current = current.next;
        }

        linkedListTextRepresentation.append("X");

        return linkedListTextRepresentation.toString();
    }
}
