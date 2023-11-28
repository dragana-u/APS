package Laboratoriski.cetvrta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        int rez=0;
        Stack<Character> characters = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        for(int i=0;i<c.length;i++){
            char current = c[i];
            if(current=='('){
                characters.push(current);
            }else if(current==')'){
                int b = integers.pop();
                int a = integers.pop();
                char o = characters.pop();
                if(o=='-'){
                    rez = a-b;
                }else{
                    rez = a+b;
                }
                characters.pop();
                integers.push(rez);
            }else if(current=='+' || current=='-'){
                characters.push(current);
            }else{
                integers.push(Integer.parseInt(String.valueOf(current)));
            }
        }
        return rez;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}

