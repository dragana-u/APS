package Auditoriski.a0t2;

import java.util.*;
import java.util.stream.Collectors;

class Vraboten{
    private String ime;
    private String prezime;
    private static double BOD=50;
    private double plata;
    private int staz;
    private int brojBodovi;
    private Zadaca[] zadaci;
    private int brojZadaci;

    public Vraboten(String ime, String prezime, int staz, int brojBodovi) {
        this.ime = ime;
        this.prezime = prezime;
        this.staz = staz;
        this.brojBodovi = brojBodovi;
        plata = brojBodovi*BOD;
    }

    public Vraboten() {
        zadaci = new Zadaca[10];
        brojZadaci=0;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public static double getBOD() {
        return BOD;
    }

    public double getPlata() {
        return plata;
    }

    public int getStaz() {
        return staz;
    }

    public int getBrojBodovi() {
        return brojBodovi;
    }

    public Zadaca[] getZadaci() {
        return zadaci;
    }

    public int getBrojZadaci() {
        return brojZadaci;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public static void setBOD(double BOD) {
        Vraboten.BOD = BOD;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public void setBrBod(int brojBodovi) {
        this.brojBodovi = brojBodovi;
    }

    public void setZadaci(Zadaca[] zadaci) {
        this.zadaci = zadaci;
    }

    public void setBrojZadaci(int brojZadaci) {
        this.brojZadaci = brojZadaci;
    }

    public void dodadiZadaca(Zadaca z) {
        if(brojZadaci==10){
            System.out.println("Ne moze da se dodade");
        }
        zadaci[brojZadaci++]=z;
    }

    public int casoviZaZadaca(Vraboten vraboten){
        int vkupno=0;
        for(int i=0;i<vraboten.brojZadaci;i++){
            vkupno+=vraboten.zadaci[i].getBrojCasovi();
        }
        return vkupno;
    }

    public double zavrseniZadaci(){
        int counter=0;
        for(int i=0;i<brojZadaci;i++){
            if(zadaci[i].isStatus()){
                counter++;
            }
        }
        return ((counter/(double)brojZadaci)*100.00);
    }

    @Override
    public String toString() {
        return "Vraboten{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
}

class Kompanija{
    Vraboten[] vraboteni;

    public Kompanija(Vraboten[] vraboteni) {
        this.vraboteni = vraboteni;
    }

    public Vraboten najangaziran() {
        int najdobar=0;
        int indeks=0;
        for(int i=0;i<vraboteni.length;i++){
            if(vraboteni[i].casoviZaZadaca(vraboteni[i])>najdobar){
                najdobar=vraboteni[i].casoviZaZadaca(vraboteni[i]);
                indeks=i;
            }
        }
        return vraboteni[indeks];
    }

    public void pecati() {
        for(Vraboten vraboten : vraboteni){
            System.out.println(vraboten);
        }
    }

    public void pecatiPoUspesnost() {
        List<Vraboten> sortedVraboteni =
                Arrays.asList(vraboteni)
                .stream()
                .sorted(Comparator.comparing(Vraboten::zavrseniZadaci).reversed())
                        .collect(Collectors.toList());
        System.out.println(sortedVraboteni);
    }
//public void pecatiPoUspesnost(){
//    boolean flag = true;
//    while(flag){
//        flag = false;
//        for(int j = 0;j<vraboteni.length - 1;j++){
//            if(vraboteni[j].zavrseniZadaci() <
//                    vraboteni[j+1].zavrseniZadaci()){
//                Vraboten pom = vraboteni[j];
//                vraboteni[j] = vraboteni[j+1];
//                vraboteni[j+1] = pom;
//                flag = true;
//            }
//        }
//    }
//}

}

public class Zadaca {
    private String opis;
    private int brojCasovi;
    private boolean status;



    public Zadaca() {
    }

    @Override
    public String toString() {
        return "Opis: " + opis + "\ncasovi: " + brojCasovi + "\nstatus: " +
                (status ? "aktivna" : "zavrsena");
    }

    public Zadaca(String opis, int brojCasovi) {
        this.opis = opis;
        this.brojCasovi = brojCasovi;
    }

    public String getOpis() {
        return opis;
    }

    public int getBrojCasovi() {
        return brojCasovi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCasovi(int brojCasovi) {
        this.brojCasovi = brojCasovi;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //main from auditory lesson
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Vraboten[] pom = new Vraboten[n];
        for (int i = 0; i < n; i++) {
            Vraboten v = new Vraboten();
            v.setIme(input.next());
            v.setPrezime(input.next());
            v.setStaz(input.nextInt());
            v.setBrBod(input.nextInt());
            pom[i] = v;
            int p = input.nextInt();
            for(int j = 0;j<p;j++){
                Zadaca z = new Zadaca();
                z.setCasovi(input.nextInt());
                z.setOpis(input.next());
                z.setStatus(input.nextBoolean());
                v.dodadiZadaca(z);
            }
        }
        Kompanija k = new Kompanija(pom);
        k.pecati();
        k.pecatiPoUspesnost();
        System.out.println("Najangaziran vraboten e: " +
                k.najangaziran());
    }

}