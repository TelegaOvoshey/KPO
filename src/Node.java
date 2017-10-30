public class Node {
    Node[] children;
    int nodeNumber;

    public Node () {

    }

    public Node setNumberOfChildren(int number) {
        this.children = new Node[number];
        return this;
    }

}
