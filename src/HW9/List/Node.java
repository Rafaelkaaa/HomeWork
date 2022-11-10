package HW9.List;

import java.util.Objects;

public class Node {
    public Node next;
    Node previous;
    public Object value;

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        if (next != null) {
            sb.append("next=").append(next.value);
        }else {sb.append("next=null");}
        if (previous != null) {
            sb.append(", previous=").append(previous.value);
        }else {sb.append(", previous=null");}

        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
