package HW9.Map;

import HW9.List.MyLinkedList;
import HW9.List.MyList;

import java.util.LinkedList;

public class MyHashMap {

    private MyLinkedList[] array;
    int size;
    int arraySectionIndex;

    public void put(Object key, Object value) {
        Node node = new Node(key, value);
        if (array == null) {
            array = new MyLinkedList[10];
        }

        if (size > array.length * 10) {
            growArray();
        }

        if (checkEqualsKeys(node)) {
            return;
        }

        int indexNodeInArray = (key.hashCode() + value.hashCode()) % 10 + arraySectionIndex;
        addNodeInList(indexNodeInArray, node);
    }

    public void remove(Object key) {
        Node node = new Node(key, null);
        for (int i = 0; i < this.array.length; i++) {

            if (this.array[i] != null) {
                HW9.List.Node tempListNode = this.array[i].first;
                if (tempListNode.value.equals(node)) {
                    removeNodeInList(i, 0);
                    return;
                }
                for (int j = 1; j < this.array[i].size(); j++) {
                    tempListNode = tempListNode.next;
                    if (tempListNode.value.equals(node)) {
                        removeNodeInList(i, j);
                        return;
                    }
                }
            }
        }
    }

    public void clear() {
        this.array = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(Object key){
        Node node = new Node(key, null);
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                HW9.List.Node tempListNode = this.array[i].first;
                if (tempListNode.value.equals(node)) {
                    return tempListNode.value;
                }
                for (int j = 1; j < this.array[i].size(); j++) {
                    tempListNode = tempListNode.next;
                    if (tempListNode.value.equals(node)) {
                        return tempListNode.value;
                    }
                }
            }
        }
        return null;
    }

    void removeNodeInList(int i, int j) {
        this.array[i].remove(j);
        if (this.array[i].first == null) {
            this.array[i] = null;
        }
        size--;
    }

    private void growArray() {
        MyList[] array = new MyLinkedList[this.array.length + 10];
        System.arraycopy(this.array, 0, array, 0, this.array.length);
        this.arraySectionIndex += 10;
    }

    private boolean checkEqualsKeys(Node node) {
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != null) {
                HW9.List.Node tempListNode = this.array[i].first;
                if (tempListNode.value.equals(node)) {
                    return true;
                }
                for (int j = 1; j < this.array[i].size(); j++) {
                    tempListNode = tempListNode.next;
                    if (tempListNode.value.equals(node)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void addNodeInList(int indexNodeInArray, Node node) {
        if (this.array[indexNodeInArray] == null) {
            this.array[indexNodeInArray] = new MyLinkedList();
        }
        this.array[indexNodeInArray].add(node);
        size++;
    }
}
