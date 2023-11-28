package Laboratoriski.prva;
//За даден збор кој се внесува од стандарден влез,
// да се испечати истиот превртен. На влез во првиот ред се
// дава број на зборови кои ќе се внесуваат. Во наредните линии
// се внесуваат самите зборови.
import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        StringBuilder temporary= new StringBuilder();
        for(int i=word.length()-1;i>=0;i--){
            temporary.append(word.charAt(i));
        }
        System.out.println(temporary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<numberOfWords;i++){
            String baseWord = scanner.nextLine();
            printReversed(baseWord);
        }
    }
}
