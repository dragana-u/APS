package Auditoriski.a0t1;

public class PrimeNumber {
    public static void main(String[] args) {
        int sum=0;
        boolean isPrime;
        for(int i=1;i<100;i++){
            isPrime=true;
            for(int j=2;j<=(i/2);j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                sum+=i;
            }
        }
        System.out.println("The sum of the first 100 nubmers is:" + sum);
    }
}
