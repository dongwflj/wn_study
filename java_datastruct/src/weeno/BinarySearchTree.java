package weeno;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType> {
        BinaryNode(AnyType aElement) {
            this(aElement, null, null);
        }
        BinaryNode(AnyType aElement, BinaryNode<AnyType> aLeft, BinaryNode<AnyType> aRight) {
            element = aElement;
            left = aLeft;
            right = aRight;
        }
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        AnyType element;
    }
    
    private BinaryNode<AnyType> root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public boolean contain(AnyType aElement) {
        return contain(root, aElement);
    }
    
    public AnyType findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        BinaryNode<AnyType> node = findMin(root);
        return node.element;
    }
    
    public void insert(AnyType aElement) {
        root = insert(root, aElement);
    }
    
    public void remove(AnyType aElement) {
        remove(root, aElement);
    }
    
    public void printTree() {
        printTree(root);
    }
    
    private void printTree(BinaryNode<AnyType> aNode) {
        if (aNode != null) {
            printTree(aNode.left);
            System.out.println(aNode.element);
            printTree(aNode.right);
        }
    }
    
    private boolean contain(BinaryNode<AnyType> aNode, AnyType aElement) {
        if (aNode == null) {
            return false;
        }
        int result = aElement.compareTo(aNode.element);
        if (result < 0) {
            return contain(aNode.left, aElement);
        }
        else if (result > 0) {
            return contain(aNode.right, aElement);
        }
        else {
            return true;
        }
    }
    
    private BinaryNode<AnyType> insert(BinaryNode<AnyType> aNode, AnyType aElement) {
        if (aNode == null) {
            return new BinaryNode<AnyType>(aElement);
        }
        int result = aElement.compareTo(aNode.element);
        if (result < 0) {
            aNode.left = insert(aNode.left, aElement);
        }
        else if (result > 0){
            aNode.right = insert(aNode.right, aElement);
        }
        else {
            // Duplicate 
        }
        return aNode;
    }
    
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> aNode) {
        if (aNode == null) {
            return null;
        }
        if (aNode.left == null) {
            return aNode;
        }
        else {
            return findMin(aNode.left);
        }
    }
    
    private BinaryNode<AnyType> remove(BinaryNode<AnyType> aNode, AnyType aElement) {
        if (aNode == null) {
            return null;
        }
        int result = aElement.compareTo(aNode.element);
        if (result < 0) {
            // Good point
            aNode.left = remove(aNode.left, aElement);
        }
        else if (result > 0){
            aNode.right = remove(aNode.right, aElement);
        }
        else {
            // find the node
            if (aNode.left != null && aNode.right != null) {
                BinaryNode<AnyType> minOfRight = findMin(aNode);
                aNode.element = minOfRight.element;
                aNode.right = remove(aNode.right, minOfRight.element);
            }
            else {
                // Include 2 cases(no childs or have one child
                // , both is the same
                aNode = aNode.left != null ? aNode.left : aNode.right;
            }
        }
        return aNode;
    }
}
