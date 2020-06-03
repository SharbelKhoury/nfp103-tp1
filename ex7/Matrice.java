

public class Matrice extends Thread{



    
  private int[][] Matrix;
    
  public  int[][] resultat, Mat1, Mat2;
    
  public  int rowI, colI;




//c1 simple

public Matrice(int[][] mtx) {
    Matrix = mtx;
    }




//c2 pour threading
public Matrice(int[][] resultat,int[][] mtx1, int[][] mtx2,int rowI, int colI){
    this.resultat=resultat;
    this.Mat1=mtx1;
    this.Mat2=mtx2;
    this.rowI=rowI;
    this.colI=colI;
    }




    

public Matrice Opera(Matrice mtx) {

int lines;
int cols;

lines = this.Matrix.length;

cols = mtx.getMatrix()[0].length;

Matrice[] M = new Matrice[lines * cols];

int[][] resultat = new int[lines][cols];


int row = 0;
int col = 0;

for (int i = 0; i < M.length; i++) {

     M[i] = new Matrice(resultat, this.Matrix, mtx.getMatrix(), row, col++);
     if (col == cols) {

          row++;
          col = 0;

     }
     M[i].start();
 }
try {
     for (Matrice mt : M) {

        mt.join();

      }
 } catch (InterruptedException ie) {

    ie.printStackTrace();

  }
  return new Matrice(resultat);
    }

   

    
   
 String PrintM(){
  String str = null;
 for(int i=0;i<this.Matrix.length;i++){

      str+="[";

      for(int j=0;j<this.Matrix[0].length;j++){

         str+=this.Matrix[i][j];

        if(j<this.Matrix[0].length-1)
             str+=", ";
      }

      str+="]\n";
  }
  return str;}

 
int[][] getMatrix(){

    return Matrix;
}


 
 
    @Override
    public void run(){
    int count=0;
    int f=0;
    while(f<this.Mat1[0].length){
    count = count+ Mat1[rowI][f]*Mat2[f][colI];
    f++;
    }
    resultat[rowI][colI]=count;
    }



 public static void main( String [] Args ) {
    	
        
  Matrice mtx1 = new Matrice(
      new int[][]{
       {1,1,1},{2,2,2},{3,3,3}
      }
   );
        
        
        
   Matrice mtx2 = new Matrice(
       new int[][]{
       {4,4,4},{5,5,5},{6,6,6}
     }
  );
       
       
       
   Matrice nouvelle = mtx1.Opera(mtx2);
      System.out.printf( nouvelle.PrintM()+"\n");}


}
