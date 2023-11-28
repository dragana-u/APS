package Laboratoriski.treta;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;

public class MiceHoles {

    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        int[] sortedMice = Arrays.stream(mice).sorted().toArray();
        int[] sortedHoles = Arrays.stream(holes).sorted().toArray();
        int maxMinutes = abs(sortedMice[0]-sortedHoles[0]);
        for(int i=1;i<mice.length;i++){
            if(abs(sortedMice[i]-sortedHoles[i])>maxMinutes){
                maxMinutes=abs(sortedMice[i]-sortedHoles[i]);
            }
        }
        return maxMinutes;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
