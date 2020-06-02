import java.util.Random;

public class Compteur extends Thread {
private String nom;    
private int n;

   
public Compteur ( String nom , int n ) {
this.nom=nom;
this.n = n;    }

@Override
public void run() {
super.run();
for (int i = 1 ;  i <= n ;  i++) {
System.out.println("%t: %f", getName(), i);
try {

sleep((int)(Math.random()*1000));

} catch (InterruptedException ie) {
 ie.printStackTrace();
    }
}
System.out.println("%t a fini de compter jusqu'à %f", getName(), this.n);
}

//    @Override
//public String getName() {}

public static void main(String[]  args)
 {
        Compteur[] cpts = new Compteur[] {
new Compteur("Cpt n1", 5),
new Compteur("Cpt n2", 5),
new Compteur("Cpt n3", 5),
new Compteur("Cpt n4", 5),
new Compteur("Cpt n5", 5),
new Compteur("Cpt n6", 5),
       
 };
for (Compteur C : cpts) {
    C.start(); }
    }
}