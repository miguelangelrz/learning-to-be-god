package DataStructures;

public class Array {
    private int[] array;

    public Array(int size) {
        array = new int[size];
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public int size() {
        return array.length;
    }

    public void set(int index, int value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;
    }

    public void resize(int newSize) {
        int[] resizedArray = new int[newSize];
        System.arraycopy(array, 0, resizedArray, 0, array.length);

        this.array = resizedArray;
    }

    public void insert(int index, int value) {
        int currentLength = array.length;

        resize(getNewCapacityAfterInsertion(index));

        int leftItemsQuantity = Math.min(index, currentLength);
        int rightItemsQuantity = Math.max(0, currentLength - index);

        System.arraycopy(this.array, leftItemsQuantity, this.array, index + 1, rightItemsQuantity);

        this.array[index] = value;
    }

    public int getNewCapacityAfterInsertion(int index) {
        if (index < this.array.length - 1) return this.array.length + 1;

        return index + 1;
    }


    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.array.length) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(array, index + 1, array, index, array.length - index - 1);

        array[this.array.length - 1] = 0;
    }

    public String toString() {
        String text = "";
        for (int j : array) {
            text += j + ", ";
        }
        return text;
    }
}
