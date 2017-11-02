import java.util.Objects;

public class Node {
    private int layers;
    private int pid;
    private int id;

    public Node(int pid, int id, int layers) {
        this.pid = pid;
        this.id = id;
        this.layers =layers;
    }

    public Node() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLayers() {
        return layers;
    }

    public void setLayers(int layers) {
        this.layers = layers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return layers == node.layers &&
                pid == node.pid &&
                id == node.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(layers, pid, id);
    }

    @Override
    public String toString() {
        return   id+"-"+pid+"- уровень"+layers+"\n";
    }
}
