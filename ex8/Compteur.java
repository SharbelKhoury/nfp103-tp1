import java.util.Random;

public class Compteur extends Thread {
private String nom;    
private int n;
private static int pos = 0;
private static final Object lock = new Object();

   
public Compteur (String nom, int n) {
 this.nom=nom;
 this.n = n;
    }

    @Override
    public void run() {
    super.run();
    for (int i = 1; i <= n; i++) {
    System.out.println("%t: %f ", getName(), i);
/**/ 
/*           interrupt() use :                   */

    cpts[(int)(Math.random() * cpts.length)].interrupt();


/**/ 
    try {
    sleep((int)(Math.random() * 250));
    } catch (InterruptedException ie) {
     ie.printStackTrace();
    }
    }
  synchronized (lock) {
  System.out.println("%t a fini de compter jusqu'a %f en position %d", getName(), this.n, pos++);
}
    }

    public static void main(String[] args) {
        Compteur[] cpts = new Compteur[] {
new Compteur("Cpt n1", 20),
new Compteur("Cpt n2", 20),
new Compteur("Cpt n3", 20),
new Compteur("Cpt n4", 20),
new Compteur("Cpt n5", 20),
new Compteur("Cpt n6", 20),
new Compteur("Cpt n7", 20),
new Compteur("Cpt n8", 20) };
 for (Compteur C: cpts) {
 C.start();
 }
}
}