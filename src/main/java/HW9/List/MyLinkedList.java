package HW9.List;

import java.util.LinkedList;

public class MyLinkedList implements MyList {
    public Node first;
    Node last;
    int size;


    @Override
    public void add(Object value) {
        Node node = new Node(value);
        if (first == null) {
            first =(last = node);
            size++;
            return;
        }
        last.next = node;
        node.previous = last;
        last = node;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirstElement();
            return;
        }
        Node temp = first;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            removeLastElement();
            return;
        }
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        size--;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index == 0) {
            return first;
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    protected void removeFirstElement() {
        if (first.equals(last)) {
            clear();
            return;
        }else {
            first = first.next;
            first.previous = null;
        }
        size--;
    }

    void removeLastElement() {
        last = last.previous;
        last.next = null;
        size--;

    }
}
