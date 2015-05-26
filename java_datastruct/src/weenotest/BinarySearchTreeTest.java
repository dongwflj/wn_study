package weenotest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import weeno.BinarySearchTree;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> mytree;
    @Before
    public void setUp() throws Exception 
    {
        mytree = new BinarySearchTree<Integer>();

        int input[] = {23, 231, 343, 211, 5455, 111, 887, 910, 887};
        for (int i=0; i<input.length; i++) {
            mytree.insert(input[i]);
        }
    }
    
    @Test
    public void testIsEmpty() {
        assertFalse(mytree.isEmpty());
    }

    @Test
    public void testContain() {
        assertTrue(mytree.contain(5455));
    }

    @Test
    public void testFindMin() throws Exception {
        Integer i = 23;
        assertEquals(mytree.findMin(), i);
    }

    @Test
    public void testInsert() {
        assertTrue(true);
    }

    @Test
    public void testRemove() {
        mytree.remove(887);
        mytree.printTree();
        assertFalse(mytree.contain(887));
    }

    @Test
    public void testPrintTree() {
        mytree.printTree();
        assertTrue(true);
    }

}
