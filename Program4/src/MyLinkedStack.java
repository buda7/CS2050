//Name: Manoj Budathoki
//Assignment: Program4
public class MyLinkedStack {
    Node top;
    int size;
    int maxSize;
    public MyLinkedStack(int maxSize) {
        top = null;
        size = 0;
        this.maxSize = maxSize;
    }
    public void push(char character) {
        if (size >= maxSize) {
            throw new IllegalStateException("Full Stack");
        }
        Node newNode = new Node(character);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }
        char character = top.data;
        top = top.next;
        size--;
        return character;
    }
    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
}
class Node {
    char data;
    Node next;
    public Node(char data) {
        this.data = data;
        next = null;
    }
}