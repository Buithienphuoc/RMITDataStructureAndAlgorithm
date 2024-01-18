package mylib;

public class MyBinarySearchTree<T> {

    /**
     * Every attribute will be set as public to extends this BST class
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;
        public Node<T> parent;
        public T getLeft(){
            return left!= null ? left.value : null;
        }

        public T getRight(){
            return right != null ? right.value: null;
        }
        public Node(T value) {
            this.value = value;
            right = null;
            left = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    protected Node<T> root;

    /**
     * Compare string value of T object
     */
    protected Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.toString().compareTo(current.value.toString()) < 0) {
            current.left = addRecursive(current.left, value);
            current.left.parent = current;
        } else if (value.toString().compareTo(current.value.toString()) > 0) {
            current.right = addRecursive(current.right, value);
            current.right.parent = current;
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    protected boolean containsNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value.toString().equals(current.value.toString())) {
            return true;
        }
        return (value.toString().compareTo(current.value.toString()) < 0)
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    protected T searchNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }
        if (value.toString().equals(current.value.toString())) {
            return value;
        }
        return (value.toString().compareTo(current.value.toString()) < 0)
                ? searchNodeRecursive(current.left, value)
                : searchNodeRecursive(current.right, value);
    }
    protected Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here

            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value.toString().compareTo(current.value.toString()) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    public void add(T value) {
        root = addRecursive(root, value);
    }

    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    public T search(T value){
        return searchNodeRecursive(root, value);
    }
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }
}
