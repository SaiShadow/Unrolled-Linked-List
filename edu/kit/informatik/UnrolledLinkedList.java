package edu.kit.informatik;

/**
 * This class represents a doubly unrolled linked list.
 * 
 * @author uogok
 * @version 4
 *
 */
public class UnrolledLinkedList {

    private ListCell head;
    private ListCell last;
    private final int arrayLength;
    private int count; // counts how many elements are in the List

    /**
     * This is the constructor for the UnrolledLinkedList class. It sets the head,
     * last and count to its default values/null. And also sets the parameter
     * arraySize to the arrayLength constructor with the array size a as the only
     * parameter. Assume that a> 0.
     * 
     * @param arraySize > 0 represents the max length of an array in the list cell
     */
    public UnrolledLinkedList(int arraySize) {
        this.head = null;
        this.last = null;
        this.arrayLength = arraySize;
        this.count = 0;
    }

    /**
     * Inserts an element at the end of the list.
     * 
     * @param element Insert element at the end of the list.
     * @return returns true if a new array had to be created, otherwise false.
     */
    public boolean push(int element) {

        // case 1: the List is empty or the array is full
        if (isArrayFull()) {

            ListCell newListCell = new ListCell(arrayLength, this.last, null);

            if (this.head == null) {
                this.head = newListCell;
            } else {
                this.last.next = newListCell;
            }
            this.last = newListCell;
            newListCell.array[0] = element;

            this.count = this.count + 1;
            return true;

        }
        // case 2: the list is not empty and it is not full

        // finds the last element
        int i = (size() - 1) % arrayLength;

        // i + 1 doesn't go out of the boundary because we already checked if the array
        // is full
        this.last.array[i + 1] = element;

        this.count = this.count + 1;
        return false;
    }

    /**
     * Remove the element at the end of the list. If only one element exists then
     * there will be an empty list after pop()
     * 
     * @return If an array was removed, true should be returned, otherwise false.
     */
    public boolean pop() {

        // find the last element in the list
        int i = (size() - 1) % arrayLength;

        // sets the element to its default value of int which is 0
        this.last.array[i] = 0;
        this.count = this.count - 1;

        // if the last element in the list is the first element of the array, then
        // delete this cell
        if (i == 0) {
            this.last = this.last.prev;
            // if the list doesn't have any list cells then it's empty
            if (this.last == null) {
                this.head = null;
                return true;
            }
            this.last.next = null;
            return true;
        }

        return false;
    }

    // i starts at 0 but count starts at 1
    // so after adding the first element the count is 1 but i must be 0 to "get" the
    // value of the element
    /**
     * i starts at 0 but count starts at 1,so after adding the first element the
     * count is 1 but i must be 0 to "get" the value of the element
     * 
     * @param i >=0. Have to get the element at position i. If i = 0 then the wanted
     *          element is the first element in the list. That is why i can never be
     *          bigger than size() - 1.
     * @return returns the element at position i.
     */
    public int get(int i) {

        if (i >= size() || i < 0) {
            return 0;
        }
        ListCell c = this.head;

        int listCellNumber = i / arrayLength;
        int arrayElementNumber = i % arrayLength;

        for (int j = 1; j <= listCellNumber; j++) {

            c = c.next;

        }
        return c.array[arrayElementNumber];
    }

    /**
     * Get the number of currently saved elements
     * 
     * @return returns the number of elements currently saved
     */
    public int size() {
        return this.count;
    }

    /**
     * Returns all elements of the list sorted in ascending order by index as a new
     * string. The elements are returned in one line and separated by the separator
     * passed as a parameter.
     * 
     * @param separator each element is going to be separated by the parameter
     *                  "separator" when printing the elements
     * @return All the elements in the list are returned in one line and separated
     *         by the separator.
     */
    public String toString(String separator) {

        String allElements = "";
        if (size() == 0) {
            return allElements;
        }

        int i = 0;
        while (i <= size() - 2) {

            allElements = allElements + get(i) + separator;
            i++;
        }
        // if i would have looped till size() - 1 then after the last element there
        // would still be the separator.
        allElements = allElements + get(i);
        return allElements;
    }

    // checks if all arrays are full
    private boolean isArrayFull() {

        boolean full = (size() % arrayLength) == 0;
        return full;

    }

    private class ListCell {

        private int[] array;
        private ListCell prev;
        private ListCell next;

        ListCell(int arraySize, ListCell p, ListCell n) {

            this.array = new int[arraySize];
            this.prev = p;
            this.next = n;

        }
    }

}
