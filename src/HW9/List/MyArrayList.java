package HW9.List;

import HW9.List.MyList;

import java.util.Arrays;

public class MyArrayList implements MyList {

    Object[] array;

    @Override
    public void add(Object value) {
        if (this.array == null) {
            this.array = new Object[]{value};
            return;
        }
        Object[] array = new Object[this.array.length + 1];
        System.arraycopy(this.array, 0, array, 0, this.array.length);
        array[array.length - 1] = value;
        this.array = Arrays.copyOf(array, array.length);

    }

    @Override
    public void remove(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - 1 - index);
        this.array = Arrays.copyOf(this.array, this.array.length - 1);
    }

    @Override
    public void clear() {
        this.array = null;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public Object get(int index) throws NullPointerException {
        try {
            return this.array[index];
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayList{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
