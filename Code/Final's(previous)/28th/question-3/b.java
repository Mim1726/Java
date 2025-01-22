import java.util.*;
public class Main{
    static class MatrixThread extends Thread{
        int row, col1, col2;
        int[][] A, B, C;

        //matris multiplication using thread
        MatrixThread(int m, int n, int p, int[][] A, int[][] B, int[][] C){
            this.row=m;
            this.col1=n;
            this.col2=p;
            this.A=A;
            this.B=B;
            this.C=C;
        }

        public void run(){
            C[row][col2]=0;
            for(int k=0;k<col1;k++){
                C[row][col2]+=A[row][k]*B[k][col2];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Scanner sc=new Scanner(System.in);

        //row1
        int m=sc.nextInt();

        //col1=row2
        int n=sc.nextInt();

        //col2
        int p=sc.nextInt();

        int[][] A=new int[m][n];
        int[][] B=new int[n][p];
        int[][] C=new int[m][p];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                A[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<p;j++){
                B[i][j]=sc.nextInt();
            }
        }

        Thread[] t=new Thread[m*p];
        int cnt=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                t[cnt]=new MatrixThread(i, n, j, A, B, C);
                t[cnt].start();
                cnt++;
            }
        }

        for(Thread x:t){
            x.join();
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                if(j!=0) System.out.print(" ");
                System.out.print(C[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
