package Laboratoriski.prva;
//За потребите на софтвер за евиденција на приходите остварени од вработените во одделот запродажба, да се дефинира класа
// QuarterlySales во која се чуваат бројот на продажби остварени во одреден квартал, приходот добиен од секоја продажба и бројот на кварталот.
// Потоа, да се дефинира друга класа SalesPerson за кој се чува име (string) и низа од квартали (точно 4). За класите
// да се имплементираат соодветните конструктори и методи за правилно извршување на програмата. Да се имплементираат следните барања:
//• Метод int sumSales(SalesPerson sp) кој ќе врати сума од сите приходи остварени од дадениот вработенво одделот за продажба во сите квартали.
// • Метод SalesPerson salesChampion(SalesPerson [] arr) кој за дадената низа од работници ќе го
// врати работникот со најголем остварен приход (од сите квартали).
//• Да се дополни main методот во кој ќе се иницијализира низа од вработени во одделот за продажба
// и квартали согласно влезните тест примери. Во првиот ред се чита број на вработени, а
// понатаму прво во еден ред се чита името, па за секој квартал во еден ред бројот на продажби,
// и во следниот ред приходот добиен од секоја од тие продажби.
//• На стандарден излез да се испечати низата од вработени во одделот за продажба со помош на
// методата void table(SalesPerson [] arr) која за низата од вработени ќе
// отпечати приказ во следниот формат (за простор при печатење се користат три празни места):
import java.util.Arrays;
import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }


}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = Arrays.copyOf(quarters,4);
    }

    int sumByQuarter(int quarterNo){
        int sum = 0;
        for (int sumPerQuarter : quarters[quarterNo].getRevenues()) {
            sum += sumPerQuarter;
        }
        return sum;
    }
    int sumSales(SalesPerson sp){
        int total=0;
        for(int i=0;i<4;i++){
            total+=sumByQuarter(i);
        }
        return total;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("   ");
        for(int i=0;i<4;i++){
            stringBuilder.append(sumByQuarter(i));
            stringBuilder.append("   ");
        }
        stringBuilder.append(sumSales(this));
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }
}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        int max = arr[0].sumSales(arr[0]);
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].sumSales(arr[i])>max){
                max = arr[i].sumSales(arr[i]);
                index=i;
            }
        }
        return arr[index];
    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for (SalesPerson salesPerson : arr) {
            System.out.println(salesPerson);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++) //kolku lugje
        {
            //your code goes here
            input.nextLine();
            String name = input.nextLine();
            QuarterlySales[] qs = new QuarterlySales[4];
            for(int j=0;j<4;j++){ // kolku kvartili
                int numberOfSales = input.nextInt();
                int[] revenues = new int[numberOfSales];
                for(int k=0;k<numberOfSales;k++){ //kolku pari
                    revenues[k]=input.nextInt();
                }
                QuarterlySales quarterlySales = new QuarterlySales(numberOfSales,
                        revenues,j+1);
                qs[j]=quarterlySales;
            }
            SalesPerson sp = new SalesPerson(name,qs);
            arr[i]=sp;
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
