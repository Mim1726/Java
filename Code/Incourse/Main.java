public class Main{
    public static void main(String[] args){
        int[] A={4,5,6,1,2,3,7,8,9};
        int n=A.length;
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
            if((A[i+2]-A[i+1])!=diff){
                y=i+3;
                break;
            }
        }
        System.out.println("x: "+x);
        System.out.println("y: "+y);
    }
}
