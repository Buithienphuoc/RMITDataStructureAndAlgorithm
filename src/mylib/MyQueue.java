package mylib;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    private Element first;
    private Element last;
    private int count;

    public MyQueue() {
        first = last = null;
        count = 0;
    }

    public void enter(E element) {
        if (count == 0) {
            //insert first element
            first = new Element();
            last = first;
            count = 1;
        } else {
            // insert element into non-empty queue
            last.next = new Element();
            last = last.next;
            count++;
        }
        last.elm = element;
        last.next = null;
    }

    public E leave() throws NoSuchElementException {
        if (count <= 0) {
            throw new NoSuchElementException();
        }
        Element ret = first;
        --count;
        first = first.next;
        if (first == null) {
            last = null;
            count = 0;
        }
        return ret.elm;
    }


    public boolean isEmpty() {
        return count == 0;
    }


    public int size() {
        return count;
    }


    public void clear() {
        while (first != null) {
            Element tmp = first;
            first = first.next;
            tmp.next = null;
        }
        first = last = null;
        count = 0;
    }

    class Element {
        public E elm;
        public Element next;

        @Override
        public String toString() {
            return "Element{" +
                    "elm=" + elm +
                    '}';
        }
    }


    @Override
    public String toString(){
        StringBuilder toStringQueue = new StringBuilder();
        Element tmp = first;
        for (int i = 0; i < count; i++) {
            toStringQueue.append(tmp.toString()).append("-->");
            tmp = tmp.next;
        }
        return toStringQueue.toString();
    }
}
