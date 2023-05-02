
public class DecisionTree {

    private final Node root;
    private final Screen screen;

    public DecisionTree(Node root) {
        this.root = root;
        this.screen = new Screen();
    }

    public void start(){
        play();
    }

    private void play () {
        // print the Tree Log
        printTree(this.root);

        // choosing a dish
        this.screen.initialMessageDialog();

        /*
         * try to guess the dish
         * start in the root and the root location equal to 2
         */
        guessDish(this.root, 2);
    }

    private void guessDish(Node node, int side) {
        // take a guess
        int option = this.screen.getOption(node);

        /*
         * option equals 0, which means "YES"
         * verify if the guess is a leaf
         * if it's a leaf the guess is right and restart the game
         * otherwise, take a new guess from the child node on the side right
         */
        if (option == 0) {
            if (node.isLeaf()) {
                this.screen.getDialogMessage();
                play();
            }
            guessDish(node.getChildRight(), 1);
        }

        /*
         * option equals 1, which means "NOT"
         * verify if the guess is a leaf
         * if it's a leaf create new node and restart the game
         * otherwise, take a new guess from the child node on the side left
         */
        if (option == 1) {
            if (node.isLeaf()) {
                createNewNode(node, side, this.screen);
                play();
            }
            guessDish(node.getChildLeft(), 0);
        }
    }

    private static void createNewNode(Node node, int side, Screen screen) {
        String dish = screen.getNewDish();
        String message = dish + " é ______ mas "+ node.getValue() + " não.";
        String dishType = screen.getNewDishType(message);

        // create new node
        Node dishNode = new Node(dishType, false, node.getFather());
        dishNode.setChildRight(new Node(dish, true, dishNode));
        dishNode.setChildLeft(node);

        /*
         * 0 is left side
         * if side equals to 0, the new node goes on the left side
         */
        if (side == 0) {
            node.getFather().setChildLeft(dishNode);
        }

        /*
         * 1 is right side
         * if side equals to 0, the new node goes on the right side
         */
        if (side == 1){
            node.getFather().setChildRight(dishNode);
        }

        node.setFather(dishNode);
    }

    private void printTree(Node root){
        if(root.getChildRight() != null && root.getChildLeft() != null){
            System.out.println(root.getValue());
        }
        if(root.isLeaf()){
            System.out.println(root.getValue());
        }
        if(root.getChildLeft() != null){
            printTree(root.getChildLeft());
        }
        if(root.getChildRight() != null){
            printTree(root.getChildRight());
        }
    }
}
