package _22010310073_BerkUyar_;

import java.util.LinkedList;
import java.util.Queue;

public class _22010310073_Pipe {
    private Queue<String> messages;
    private final int MAX_CAPACITY = 3;

    public _22010310073_Pipe() {
        messages = new LinkedList<>();
    }
    

    public boolean isFull() {
        return messages.size() >= MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public void write(String message) {
        if (!isFull()) {
            messages.add(message);
        }
    }

    public String read() {
        if (!isEmpty()) {
            return messages.poll();
        }
        return null;
    }
}

