package test;

import java.util.HashMap;

import weenotest.BinarySearchTreeTest;
import weenotest.WNStackTest;
import weeno.WNStack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)  
@Suite.SuiteClasses({ BinarySearchTreeTest.class, WNStackTest.class }) 
public class Test {
    public static void main(String [] args) throws Exception {
        junit.textui.TestRunner.run (suite());
        String exp = "(4/2+2)+(8*2-5)";
        System.out.print(exp+"=");
        calcExpression(exp);
    }
    
    public static junit.framework.Test suite() 
    {
       return new JUnit4TestAdapter(Test.class);
    }
    
    private static Integer calc(Integer right, Integer left, Character symbol) {
        Integer result = 0;
        switch(symbol) {
        case '+':
            result = left + right;
            break;
        case '-':
            result = left - right;
            break;
        case '*':
            result = left * right;
            break;
        case '/':
            result = left / right;
            break;
        default:
            break;
        }
        return result;
    }
    
    private static void calcExpression(String aExp) throws Exception {
        HashMap<Character, Integer> mymap = new HashMap<Character, Integer>();
        mymap.put('+', 1);
        mymap.put('-', 1);
        mymap.put('*', 2);
        mymap.put('/', 2);
        mymap.put('(', 0);
        WNStack<Integer> numstack = new WNStack<Integer>();
        WNStack<Character> symbolstack = new WNStack<Character>();
        for (int i=0; i<aExp.length(); i++) {
            Character c = aExp.charAt(i);
            if (c <= '9' && c >= '0') {
                String num  = String.valueOf(c);
                if (i < aExp.length()-1) {
                    for(c = aExp.charAt(++i); c <= '9' && c >= '0';) {
                        num += String.valueOf(c);
                        if (i < aExp.length()-1) {
                            c = aExp.charAt(++i);
                        }
                        else {
                            i++;
                            break;
                        }
                    }
                    i--;
                }
                numstack.Push(Integer.valueOf(num));
            }
            else {
                if (c == '(') {
                    symbolstack.Push(c);
                }
                else if (c == ')') {
                    while(symbolstack.Top() != '(') {
                        Integer result = calc(numstack.Pop(), numstack.Pop(), symbolstack.Pop());
                        numstack.Push(result);
                    }
                    symbolstack.Pop();
                }
                else {
                    // +-*/
                    if (!symbolstack.isEmpty()) {
                        if (mymap.get(c) <= mymap.get(symbolstack.Top())) {
                            Integer result = calc(numstack.Pop(), numstack.Pop(), symbolstack.Pop());
                            numstack.Push(result);
                            symbolstack.Push(c);
                        }
                        else {
                            symbolstack.Push(c);
                        }
                    }
                    else {
                        symbolstack.Push(c);
                    }
                }
            }
        }
        Integer result = 0;
        while (!symbolstack.isEmpty()) {
            result = calc(numstack.Pop(), numstack.Pop(), symbolstack.Pop());
            numstack.Push(result);
        }
        result = numstack.Pop();
        System.out.println(result);
    }
}
