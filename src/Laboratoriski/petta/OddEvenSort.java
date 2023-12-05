package Laboratoriski.petta;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.Comparator;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        int j = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            j = i;
            if (a[i] % 2 != 0) {
                count++;
                while (j > 0) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    j--;
                }
            }
        }
//        int[] part1 = Arrays.stream(a).limit(count).sorted().toArray();
//        int[] part2 = Arrays.stream(a).skip(count).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
//        System.arraycopy(part1, 0, a, 0, count);
//        System.arraycopy(part2, 0, a, count, n - count);
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < count - 1 - i; k++) {
                if (a[k] > a[k + 1]) {
                    int temp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = temp;
                }
            }
        }
        for (int i = count; i < n; i++) {
            for (int k = count; k < n-1; k++) {
                if (a[k] < a[k + 1]) {
                    int temp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}
