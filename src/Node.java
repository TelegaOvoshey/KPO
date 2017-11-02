import java.util.Objects;

public class Node {
    private int layers;
    private int pid;
    private int id;
    private boolean hang;
    public Node(int pid, int id, int layers,boolean hang) {
        this.pid = pid;
        this.id = id;
        this.layers =layers;
        this.hang = hang;
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

    public boolean isHang() {
        return hang;
    }

    public void setHang(boolean hang) {
        this.hang = hang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return layers == node.layers &&
                pid == node.pid &&
                id == node.id &&
                hang == node.hang;
    }

    @Override
    public int hashCode() {

        return Objects.hash(layers, pid, id, hang);
    }

    @Override
    public String toString() {
        return   id+"-"+pid+"  ;уровень:"+layers+" ;Висячий ="+hang+"\n";
    }
}
