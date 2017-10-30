import java.util.Collection;


public class Node {
    private int id;//id ноды
    private int pid;//id родителя
    private Collection<Node> children; //Потомки
    private Node parent;//Родитель

    public Node(int id, int pid) {
        this.id = id;
        this.pid = pid;
    }

    public void accept(Node[] nodes) {
        for(int i = 0; i < nodes.length; i++ ) {
            if(nodes[i].pid == id) {
                addChild(nodes[i]);
                nodes[i].accept(nodes);
            }
        }
    }

    public void addChild(Node child){
        child.parent = this;
        getChildren().add(child);
    }

    public Collection<Node> getChildren() {
        return children;
    }
}
