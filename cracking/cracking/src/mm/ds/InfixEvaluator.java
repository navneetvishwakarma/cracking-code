package mm.ds;


import java.util.HashMap;
import java.util.Map;

/**
 * Takes an infix string as input. Converts it into Postfix. Evaluates the postfix. Supports only single digits operands.
 *
 * @author mmathuria
 */
public class InfixEvaluator {
    
    Stack stack;
    Map<Character,Integer> precedenceMap;
    
    public InfixEvaluator(){
        stack = new Stack(50);
        initPrecedenceMap();
    }
    
    public String convertToPostfix(String infixString){
        char top;
        StringBuilder buf = new StringBuilder();
        for(char ch : infixString.toCharArray()){
            if(isOperand(ch)){
                buf.append(ch);
                continue;
            }

            
            if (stack.isEmpty() || ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while ((top = (char) stack.pop()) != '(') {
                    buf.append(top);
                }
            } else {
                top = (char) stack.pop();
                if (top == '(') {
                    stack.push(top);
                } else if (precedence(top) >= precedence(ch)) {
                    buf.append(top);
                } else if (precedence(top) < precedence(ch)) {
                    stack.push(top);
                }
                stack.push(ch);
            }
        }


        while(!stack.isEmpty()){
            buf.append((char)stack.pop());
        }
        
        return buf.toString();
    }
    
    public int evaluatePostfix(String postfixString){
        for(char ch : postfixString.toCharArray()){
            if(isOperand(ch)){
                stack.push(ch - 48);
            }else{
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (ch){
                    case '+' : stack.push(op1 + op2);break;
                    case '-' : stack.push(op2 - op1);break;
                    case '*' : stack.push(op1 * op2);break;
                    case '/' : stack.push(op2 / op1);break;
                }
            }
        }
        return stack.pop();
    }
    
    private boolean isOperand(char ch){
        return ch >= '0' && ch <= '9';
    }
    
    private int precedence(char ch){
        return precedenceMap.get(ch);
    }
    
    private void initPrecedenceMap(){
        precedenceMap = new HashMap<Character, Integer>();
        precedenceMap.put('+',1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('(', 3);
        precedenceMap.put(')', 3);
    }

    public static void main2(String[] args) {
        char c = '3';
        int i = c - 48;
        System.out.println(i);
    }
    
    public static void main(String[] args) {
        InfixEvaluator ie = new InfixEvaluator();
        
        String[] infixes = {"3+4*5","3+4-5","3*(4+5)","3*(4+5-3)"};
        for(String infix : infixes){
            String postfix = ie.convertToPostfix(infix);
            int value = ie.evaluatePostfix(postfix);
            System.out.println(infix + "\t\t-->\t\t" + postfix + "\t\t-->\t\t" + value);
        }
    }
}

