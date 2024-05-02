package DataStructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("Size should be zero on creation")
    void emptyListSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Size should have the number of items added")
    void sizeAfterAddingItems() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("Size should have the number of items added less items deleted")
    void sizeAfterRemovingItems() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.removeFirst();
        list.removeFirst();
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Size should be zero after clear the list")
    void sizeAfterClear() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Is empty should be true when list is created")
    void isEmptyAfterCreation() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Is empty should be false after adding items")
    void isEmptyAfterAddingItems() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Is empty should be true after deleting all items")
    void isEmptyAfterRemovingAllItems() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Is empty should be true after clear")
    void isEmptyAfterClear() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Should have the new Item after adding it")
    void add() {
        LinkedList list = new LinkedList();
        list.add(5);
        assertAll(() -> assertFalse(list.isEmpty()), () -> assertEquals(1, list.size()), () -> assertEquals(0, list.indexOf(5)));
    }

    @Test
    @DisplayName("Should add the new item on the head of the list")
    void addFirst() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.addFirst(1);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    @DisplayName("Should add the new item on the tail of the list")
    void addLast() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.addLast(1);
        assertEquals(4, list.indexOf(1));
    }

    @Test
    @DisplayName("Item removed should not be part of the list")
    void remove() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(5);
        list.remove(2);
        assertFalse(list.contains(1));
    }

    @Test
    @DisplayName("First item should be removed")
    void removeFirst() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeFirst();
        assertFalse(list.contains(1));
    }

    @Test
    @DisplayName("Last item should be removed")
    void removeLast() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeLast();
        assertFalse(list.contains(3));
    }

    @Test
    @DisplayName("Should return the item on the second position")
    void get() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.get(2));
    }

    @Test
    @DisplayName("Should return the item on the head")
    void getHead() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.getHead().data);
    }

    @Test
    @DisplayName("Should return the last item")
    void getTail() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getTail().data);
    }

    @Test
    @DisplayName("Should return the position of the unique item")
    void indexOf() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    @DisplayName("Should return -1 for an item that is not part of the list")
    void indexOfNonExistentItem() {
        LinkedList list = new LinkedList();
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    @DisplayName("Should contain an already added item")
    void contains() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertTrue(list.contains(1));
    }

    @Test
    @DisplayName("Should not contain a non-added value")
    void noContains() {
        LinkedList list = new LinkedList();
        assertFalse(list.contains(1));
    }

    @Test
    @DisplayName("Should change the value of the item")
    void set() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(2, 4);
        assertEquals(4, list.get(2));
    }

    @Test
    @DisplayName("Should change the value of the item")
    void setOutOfBoundaries() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(6, 7));
    }

    @Test
    @DisplayName("Should reverse with iterative method")
    void iterativeReverse() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.iterativeReverse();
        assertEquals(0, list.indexOf(3));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(1));
    }

    @Test
    @DisplayName("Should reverse with recursive method")
    void recursiveReverse() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.recursiveReverse();
        assertEquals(0, list.indexOf(3));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(1));
    }
}