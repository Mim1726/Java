import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        //input: 9
        //4 5 6 1 2 3 7 8 9
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }

        int x=0,y=0;
        int diff=A[1]-A[0];

        for(int i=1;i<n-1;i++){
            if((A[i+1]-A[i])!=diff){
                x=i+1;
                break;
            }
        }
        diff=A[x+1]-A[x];
        for(int i=x+1;i<n-1;i++){
            if((A[i+1]-A[i])!=diff){
                y=i+2;
                break;
            }
        }
        System.out.println("x: "+x);
        System.out.println("y: "+y);

        sc.close();
    }
}
