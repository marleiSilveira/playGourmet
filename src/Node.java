
public class Node {

    private final String value;
    private Node childLeft; // 'not' path
    private Node childRight; // 'yes' path
    private Node father;
    boolean leaf;

    public Node(String value, boolean leaf, Node father) {
        this.value = value;
        this.leaf = leaf;
        this.father = father;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public String getValue() {
        return value;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public Node getChildLeft() {
        return childLeft;
    }

    public void setChildLeft(Node childLeft) {
        this.childLeft = childLeft;
    }

    public Node getChildRight() {
        return childRight;
    }

    public void setChildRight(Node childRight) {
        this.childRight = childRight;
    }
}

