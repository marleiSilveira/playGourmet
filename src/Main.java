
public class Main {
    public static void main(String[] args) {
        // inicial node
        Node root = new Node("massa", false, null);
        root.setChildLeft(new Node("Bolo de Chocolate", true, root));
        root.setChildRight(new Node("Lasanha", true, root));

        DecisionTree tree = new DecisionTree(root);
        tree.start();
    }
}
