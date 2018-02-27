public class ListNode09 {
    public int data; // data stored in this node
    public ListNode09 next; // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode09() {
        this(0, null);
    }

     // post: constructs a node with given data and null link
    public ListNode09(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode09(int data, ListNode09 next) {
        this.data = data;
        this.next = next;
    }
}