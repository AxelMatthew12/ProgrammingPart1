package JAVA.CIHUY;

public class Main {

    public String nama;
    public String umur;

    public String Getnama(){
        return nama;
    }
    public String Getumur(){
        return umur;
    }

    public void Display(){
        System.out.println("Berikut tampilan Identitas anda : ");
        System.out.println("Nama : "+nama + " , " + "Umur : "+ umur);
    }
}
