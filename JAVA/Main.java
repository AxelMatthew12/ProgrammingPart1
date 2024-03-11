package JAVA;

public class Main {
    
    public String nama;
    public String nim;
    public int age;


    public String getNama(){
        return nama;
    }
    public String getNim(){
    return nim;
    }
    public int getAge(){
        return age;
    }
    public void display(){
        System.out.println("Berikut hasil nya :    ");
        System.out.println("NAMA: "+ nama +",NIM: "+nim + ", Umur: "+age);
    }
}
