package queue;

public class Queue<T> {
    private T[] arr;
    private int front, rear, size, capacity;

    Queue(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    void enqueue(T val) {
        if (isFull()) {
            return;
        }
        rear++;
        arr[rear] = val;
        size++;
    }
    T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T val = arr[front];
        front++;
        size--;
        return val;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    T front() {
        if (isEmpty()) return null;
        return arr[front];
    }

    T rear() {
        if (isEmpty()) return null;
        return arr[rear];
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            sb.append(arr[i]);
            if (i < rear) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
