package mylib;

/**
 * MyDoubleLinkedList.java
 *
 */
public class MyLinkedList<T> {
    public static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList(){
        size = 0;
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    /**
     * Inserting new node at the end of the linked list
     * If there is node present we will make the first node as out main node
     *
     * @param value - represent the Node value to be added to the linked list
     * Complexity: O(1)
     */
    public void add(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        node.next = null;

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            this.tail.next = null;
            this.tail.prev = null;
            this.size = 1;
        } else {
            Node<T> prev = this.tail;
            this.tail.next = node;
            this.tail = node;
            this.tail.prev = prev;
            this.size++;
        }
    }

    /**
     * Adding Node at the first location of the linked list
     *
     * @param value - represent item of the Node to be added to LL*
     * Complexity: O(1)
     */
    public void addFirst(T value){
        Node<T> node = new Node<>();
        node.value = value;
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        this.size++;
    }

    /**
     * Adding Node at the nth location of the linked list
     * if location is greater than half of size traverse from tail
     * if location is smaller than half of size traverse from head
     *
     * @param value - represent the value of the Node to be added to the list
     * @param position - position at which the Node is to be added
     *
     *  Complexity: O(1)
     */
    public void add(T value, int position) {
        int center = (int) Math.floor((double) size /2);
        Node<T> node = new Node<T>();
        node.value = value;
        Node<T> current = null;
        if (this.head != null && position <= this.size) {
            if(position < center){
                current = head;
                for(int i=1;i<position;i++){
                    current = current.next;
                }
            }else{
                current = tail;
                for(int i=size; i>position; i--){
                    current = current.prev;
                }
            }
            node.next = current.next;
            current.next.prev = node;
            node.prev = current;
            current.next = node;
            this.size += 1;
        }else{
            System.out.println("Exceeded the linked list size. Current Size: "+size);
        }
    }

    /**
     * Deleting the first Node from the list
     * Complexity: O(1)
     */
    public void removeFirst() {
        if(head != null){
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
        }else{
            System.out.println("Linked list is empty");
        }
    }

    /**
     * Deleting the last Node from the list
     * Complexity:O(1)
     */
    public void removeLast() {
        if(tail != null){
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
        }
    }

    /**
     * Deleting the Node from the nth location in the list
     *
     * @param position - location of the Node to be deleted
     * Complexity: O(n)
     */
    public void remove(int position) {
        Node<T> current;
        int center = (int) (double) (size / 2);
        if(position < size){
            if(position < center){
                current = head;
                for(int i=1; i<position; i++){
                    current = current.next;
                }
            }else{
                current = tail;
                for(int i=size-1;i>position;i--){
                    current = current.prev;
                }
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }else{
            System.out.println("The position is exceeds the linked list size: "+this.size);
        }
    }

    /**
     * Find if the Node exist in the list
     *
     * @param value - value to be found in the list
     * Complexity O(n)
     */
    public T getByStringValue(String value) {
        Node<T> node = this.head;
        for(int i=0;i<size; i++){
            if(node.value.toString().equals(value)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Find the Node item located at a specific location
     *
     * @param location - Find item at location
     * Complexity O(n)
     */
    public T get(int location) {
        Node<T> node = this.head;
        if(head !=null && location<= size){
            for(int i=0;i<location;i++){
                node = node.next;
            }
            return node.value;
        }
        return null;
    }

    /**
     * Find the item at the last location
     * Complexity:O(1)
     */
    public T getLast() {
        if(tail != null){
            return tail.value;
        }
        return null;
    }

    /**
     * Get linked list size
     * Complexity: O(1)
     */
    public int size(){
        return size;
    }

    /**
     * @return string value of the list
     * Complexity: O(n)
     */
    @Override
    public String toString() {
        StringBuilder stringValue = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringValue.append(get(i));
            if (i != size-1){
                stringValue.append(";");
            }
        }
        return stringValue.toString();
    }
}

