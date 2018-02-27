// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList09 {

    /*
    Write a method called stutter that doubles the size of a list by replacing every integer in the list with two of
    that integer. For example, suppose a variable list stores the values [1, 8, 19, 4, 17] , after a call of
    list.stutter() , it should store [1, 1, 8, 8, 19, 19, 4, 4, 17, 17] .
     */

    public void stutter() {
        int[] aux = new int[this.size()];
        ListNode09 current = front;
        int counter = 0;

        while (current != null) {
            aux[counter] = current.data;
            counter++;
            current = current.next;
        }

        front = new ListNode09(aux[0], new ListNode09(aux[0]));

        for (int i = 1; i < aux.length; i++) {
            this.add(aux[i]);
            this.add(aux[i]);
        }
    }

    // Everything below is copied from the book

    private ListNode09 front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList09() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode09 current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode09 current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode09 current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode09(value);
        } else {
            ListNode09 current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode09(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode09(value, front);
        } else {
            ListNode09 current = nodeAt(index - 1);
            current.next = new ListNode09(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode09 current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode09 nodeAt(int index) {
        ListNode09 current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}