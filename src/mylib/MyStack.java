package mylib;

import java.util.EmptyStackException;

public class MyStack<T> implements IMyStack<T> {
    private static class Node<T> {
        private T element;
        private Node<T> previous;


        /**
         * Creates a node with null references to its element and next node
         */
        public Node()
        {
            this(null, null);
        }

        /**
         * Creates a node with the given element and next node
         */
        public Node(T e, Node<T> n)
        {
            element = e;
            previous = n;
        }

        /**
         * Accessor methods
         */
        public T getElement()
        {
            return element;
        }

        public Node<T> getPrevious()
        {
            return previous;
        }

        /**
         * Modifier methods
         */
        public void setElement(T newElem)
        {
            element = newElem;
        }

        public void setPrevious(Node<T> newNext)
        {
            previous = newNext;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    private Node<T> top;    // reference to the head node
    private int size;      // number of elements in stack

    private StringBuilder toStringValue = new StringBuilder();

    public MyStack()
    {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T top(){
        if (top != null){
            return top.getElement();
        }
        return (T) "null";
    }

    @Override
    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        T temp = top.getElement();
        top = top.getPrevious();
        size--;
        return temp;
    }

    @Override
    public String toString() {
        Node<T> temp = top;
        while (temp != null){
            toStringValue.append(temp);
            temp = temp.getPrevious();
            if (temp != null){
                toStringValue.append("<--");
            }
        }
        String stringValue = toStringValue.toString();
        toStringValue = new StringBuilder();
        return stringValue;
    }
}
