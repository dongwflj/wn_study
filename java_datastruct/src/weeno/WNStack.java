package weeno;

public class WNStack<AnyType> {
    private static class StackNode<AnyType> {
        AnyType element;
        StackNode<AnyType> next;
        StackNode (AnyType aElement, StackNode<AnyType> aNext) {
            element = aElement;
            next = aNext;
        }
    }
    
    private StackNode<AnyType> top;
    
    public void Push(AnyType aElement) {
        top = Push(top, aElement);
    }
    
    public AnyType Top() throws Exception {
        if (top == null) {
            throw new Exception();
        }
        return top.element; 
    }
    
    public AnyType Pop() throws Exception {
        if (top == null) {
            throw new Exception();
        }
        StackNode<AnyType> tmp = top;
        top = top.next;
        return tmp.element;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void PrintStack() {
        StackNode<AnyType> cursor = top;
        while (cursor != null) {
            System.out.println(cursor.element);
            cursor = cursor.next;
        }
    }
    
    private StackNode<AnyType> Push(StackNode<AnyType> aTop, AnyType aElement) {
        StackNode<AnyType> tmp = new StackNode<AnyType>(aElement, top);
        return tmp;
    }
}
