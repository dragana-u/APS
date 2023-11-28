package Laboratoriski.treta;

import java.util.Scanner;

public class CountWordPairs {

    //TODO: implement function
    public static int countWordPairs(String [] words) {
        int wordPair=0;
        for(int i=0;i<words.length;i++){
            char c =  words[i].charAt(0);
            for(int j=i+1; j<words.length;j++){
                char c2 = words[j].charAt(0);
                if(c==c2){
                    wordPair++;
                }
            }
        }
        return wordPair;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String words[] = new String[N];

        for(int i=0;i<N;i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));

    }
}
