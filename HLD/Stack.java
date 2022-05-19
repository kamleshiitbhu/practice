public class Stack<T> {
    int capacity;
    int top;
    T st[]
    public Stack(int capacity) {
        this.capacity = capacity;
        st  = new T[this.capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public T pop() {
        if (top == -1) {
            throws Exception ("empty stack");
        } else {
            return st[top--];
        }
    }
    public void push(T data) {
        if (top == capacity - 1) {
            throws Exception ("stack is full");
        }
        else {
            st[top++] = data;
        }
    }

    public T peek() {
        if (top == -1) {
            throws Exception ("empty stack");
        } else {
            return st[top];
        }    
    }
} 