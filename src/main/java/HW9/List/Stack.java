package HW9.List;

public class Stack extends MyLinkedList{

    public void push(Object value){
        add(value);
    }

   public Object peek(){
        return last;
    }
    public Object pop(){
        Object resultValue = last;
        removeLastElement();
        return resultValue;
    }
}
