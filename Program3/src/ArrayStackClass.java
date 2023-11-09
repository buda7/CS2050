
public class ArrayStackClass {
    private char[] stack;
    private int maxSize;
    private int top;

    public ArrayStackClass(int maxSize) {
        this.maxSize = maxSize;
        stack = new char[maxSize];
        top = -1;
    }

    public void push(char character) {
        if (isFull()) {
            throw new IllegalStateException("Full Stack");
        }
        stack[++top] = character;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }
}
