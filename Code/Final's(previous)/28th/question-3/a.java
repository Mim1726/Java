import java.util.*;
public class Main{
    public static void main(String[] args){

        //multiplication of matrices
        Scanner sc=new Scanner(System.in);
        //row
        int m=sc.nextInt();
        //col1==row2
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

        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                C[i][j]=0;
                for(int k=0;k<n;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
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
