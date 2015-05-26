package weenotest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import weeno.WNStack;

public class WNStackTest {
    WNStack<Integer> mystack;
    @Before
    public void setUp() throws Exception {
        mystack = new WNStack<Integer>();

        int input[] = {23, 231, 343, 211, 5455, 111, 887, 910, 887};
        for (int i=0; i<input.length; i++) {
            mystack.Push(input[i]);
        }
    }

    @After
    public void tearDown() {
        mystack.PrintStack();
    }

    @Test
    public void testPop() throws Exception {
        while (!mystack.isEmpty()) {
            mystack.Pop();
        }
        assertTrue(mystack.isEmpty());
    }
}
