package Auditoriski.a5t1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpEvaluate {
    public static boolean isCorrect(String line){
        Stack<Character> characters = new Stack<>();
        for(int i=0;i<line.length();i++){
            char c = line.charAt(i);
            if(c=='('){
                characters.push(c);
            }else if(c=='['){
                characters.push(c);
            }else if(c==')'){
                char c1;
                if(!characters.isEmpty()){
                    c1 = characters.pop();
                    if(c1!='('){
                        return false;
                    }
                }else{
                    return false;
                }
            }else if(c==']') {
                char c1;
                if (!characters.isEmpty()) {
                    c1 = characters.pop();
                    if (c1 != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String phrase = "s x (s - a) x s - b) x (s - c)";
        System.out.println(isCorrect(phrase));
    }
}
