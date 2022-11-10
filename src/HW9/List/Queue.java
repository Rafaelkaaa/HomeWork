package List;

import HW9.List.MyLinkedList;

public class Queue extends MyLinkedList {
    public Object peek(){
        return first.value;
    }
   public Object pull(){
        Object resultValue = first;
        removeFirstElement();
        return resultValue;
    }
}