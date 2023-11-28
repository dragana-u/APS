package PrvKolokvium.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        int proiz=1, rez=0;
        Stack<Integer> integers = new Stack<>();
        String[] nums = expression.split("\\+");
        for(int i=0;i<nums.length;i++){
            String[] mnoz = nums[i].split("\\*");
            proiz=1;
            for(int k=0;k<mnoz.length;k++){
                proiz*=Integer.parseInt(mnoz[k]);
            }
            integers.push(proiz);
        }
        while(!integers.isEmpty()){
            rez+=integers.pop();
        }
        return rez;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}