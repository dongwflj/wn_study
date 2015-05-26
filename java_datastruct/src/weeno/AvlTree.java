package weeno;

public class AvlTree<AnyType extends Comparable<? super AnyType>>  {
    private static class AvlNode<AnyType> {
        AvlNode(AnyType aElement) {
            this(aElement, null, null);
        }
        AvlNode(AnyType aElement, AvlNode<AnyType> aLeft, AvlNode<AnyType> aRight) {
            element = aElement;
            left = aLeft;
            right = aRight;
            high = 0;
        }
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        AnyType element;
        int high;
    }
    
    private AvlNode<AnyType> root;
    
    public AvlTree() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
//    public boolean contain(AnyType aElement) {
//        return contain(root, aElement);
//    }
//    
//    public AnyType findMin() throws Exception {
//        if (isEmpty()) {
//            throw new Exception();
//        }
//        BinaryNode<AnyType> node = findMin(root);
//        return node.element;
//    }
    
    public void insert(AnyType aElement) {
        root = insert(root, aElement);
    }
    
    public void printTree() {
        printTree(root);
    }
    
    private AvlNode<AnyType> insert(AvlNode<AnyType> aNode, AnyType aElement) {
        if (aNode == null) {
            return new AvlNode<AnyType>(aElement);
        }
        int result = aElement.compareTo(aNode.element);
        if (result < 0) {
            aNode.left = insert(aNode.left, aElement);
            int leftHigh = Height(aNode.left);
            int rightHigh = Height(aNode.right);
            if (leftHigh - rightHigh > 1) {
                if (aElement.compareTo(aNode.left.element) < 0) {
                    aNode = rotateRight(aNode);
                }
                else {
                    aNode = rotateLeft(aNode.left);
                    aNode = rotateRight(aNode);
                }
            }
        }
        else if (result > 0){
            aNode.right = insert(aNode.right, aElement);
            int leftHigh = Height(aNode.left);
            int rightHigh = Height(aNode.right);
            if (rightHigh - leftHigh > 1) {
                if (aElement.compareTo(aNode.right.element) < 0) {
                    aNode = rotateLeft(aNode);
                }
                else {
                    aNode = rotateRight(aNode.left);
                    aNode = rotateLeft(aNode);
                }
            }
        }
        else {
            // Duplicate 
        }
        aNode.high = Math.max(Height(aNode.left), Height(aNode.right)) + 1;
        return aNode;
    }
    
    private int Height(AvlNode<AnyType> aNode) {
        return aNode == null ? -1 : aNode.high;
    }
    
    private AvlNode<AnyType> rotateRight(AvlNode<AnyType> aNode) {
        AvlNode<AnyType> tmp = aNode.left;
        aNode.left = tmp.right;
        tmp.right = aNode;
        aNode.high = Math.max(Height(aNode.left), Height(aNode.right)) + 1;
        tmp.high = Math.max(Height(tmp.left), Height(tmp.right)) + 1;
        return tmp;
    }
    
    private AvlNode<AnyType> rotateLeft(AvlNode<AnyType> aNode) {
        AvlNode<AnyType> tmp = aNode.right;
        aNode.right = tmp.left;
        tmp.left = aNode;
        aNode.high = Math.max(Height(aNode.left), Height(aNode.right)) + 1;
        tmp.high = Math.max(Height(tmp.left), Height(tmp.right)) + 1;
        return tmp;
    }
    
    private void printTree(AvlNode<AnyType> aNode) {
        if (aNode != null) {
            printTree(aNode.left);
            System.out.println(aNode.element);
            printTree(aNode.right);
        }
    }
}
