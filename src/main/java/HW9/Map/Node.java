package HW9.Map;

import java.util.Objects;

public class Node {
    public Object key;
    public Object value;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key.equals(node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("key=").append(key);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
